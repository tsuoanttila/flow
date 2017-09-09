window.gridConnector = {
    initLazy: function(grid, pageSize) {
    	var extraPageBuffer = 2;
    	var pageCallbacks = {};
    	var cache = {};
    	var lastRequestedRange = [0, 0]
    	var selectedKeys = {};
    	
    	grid.pageSize = pageSize;
    	grid.size = 0; // To avoid NaN here and there before we get proper data
    	
    	grid.selectedItems = {
    		indexOf: function(item) {
    			if (item && selectedKeys[item.key]) {
    				return +item.key;
    			} else {
    				return -1;
    			}
    		},
    		push: function() {
    			for(var i = 0; i < arguments.length; i++) {
    				var item = arguments[i];
    				var key = item.key;
    				selectedKeys[key] = item;
    				grid.$server.select(key);
    			}
    		},
    		splice: function(key, deleteCount) {
    			if (deleteCount == 1 && arguments.length == 2 && selectedKeys[key]) {
    				var item = selectedKeys[key];
    				delete selectedKeys[key];
    				grid.$server.deselect(key);
    				return [item];
    			} else {
    				throw "wat";
    			}
    		}
    	};
    	
		grid.dataProvider = function(params, callback) {
			if (params.pageSize != pageSize) { throw "Invalid pageSize"; }
			
			var page = params.page;
			if (cache[page]) {
				callback(cache[page]);
			} else {
				pageCallbacks[page] = callback;
			}
			
			// Determine what to fetch based on scroll position and not only what grid asked for 
    		var firstNeededPage = Math.min(page, grid._getPageForIndex(grid.$.scroller._virtualStart));
    		var lastNeededPage = Math.max(page, grid._getPageForIndex(grid.$.scroller._virtualEnd));
    		
	        var first = Math.max(0,  firstNeededPage - extraPageBuffer);
	        var last = Math.min(lastNeededPage + extraPageBuffer, Math.max(0, Math.floor(grid.size / grid.pageSize) - 1));

	        if (lastRequestedRange[0] != first || lastRequestedRange[1] != last) {
	        	lastRequestedRange = [first, last];
	        	
		        var count = 1 + last - first;
		        
				// setTimeout to avoid race condition in ServerRpcQueue
				setTimeout(() => grid.$server.setRequestedRange(first * pageSize, count * pageSize), 0);
	        }
		}
		
		var updateGridCache = function(page) {
			if (!grid._cache[page]) {
				return;
			}
			
			var items = cache[page];
			
			if (!items) {
				delete grid._cache[page];
			}
			
			// Force update unless there's a callback waiting
			if (!pageCallbacks[page]) {
				if (items) {
					// Replace existing cache page
					grid._cache[page] = items;
				} else {
					// Fake page to pass to _updateItems
					items = new Array(pageSize);
				}
				
				grid._updateItems(page, items);
			}
		}
		var updatedPages = {};
		grid.connectorSet = function(index, items) {
			if (index % pageSize != 0) {
				throw "Got new data to index " + index + " which is not aligned with the page size of " + pageSize;
			}
			
			var firstPage = index / pageSize;
			var updatedPageCount = Math.ceil(items.length / pageSize);
			
			for (var i = 0; i < updatedPageCount; i++) {
				var page = firstPage + i;
				
				var items = items.slice(i * pageSize, (i + 1) * pageSize);
				cache[page] = items;
				
				for(var j = 0; j < items.length; j++) {
					var item = items[j]
					if (item.selected) {
						selectedKeys[item.key] = item;
					} else {
						delete selectedKeys[item.key];
					}
				}
				
				updatedPages[page] = true;
			}
		};
		grid.connectorClear = function(index, length) {
			if (index % pageSize != 0) {
				throw "Got cleared data for index " + index + " which is not aligned with the page size of " + pageSize;
			}
			
			var firstPage = index / pageSize;
			var updatedPageCount = Math.ceil(length / pageSize);
			
			for (var i = 0; i < updatedPageCount; i++) {
				var page = firstPage + i;
				
				items = cache[page];
				for(var j = 0; j < items.length; j++) {
					var item = items[j]
					delete selectedKeys[item.key];
				}
				
				delete cache[page];
				
				updatedPages[page] = true;
			}
		};
		grid.connectorUpdateSize = function(newSize) {
			grid.size = newSize;
		};
		
		grid.connectorConfirm = function(id) {
			// We're done applying changes from this batch, update grid and resolve callbacks
			for(var page in updatedPages) {
				updateGridCache(+page);
			}
			updatesPages = {}
			
        	var outstandingRequests = Object.getOwnPropertyNames(pageCallbacks);
        	
        	for(var i = 0; i < outstandingRequests.length; i++) {
        		var page = outstandingRequests[i];
        		
        		// Resolve if we have data or if we don't expect to get data
        		if (cache[page] || page < lastRequestedRange[0] || page > lastRequestedRange[1]) {
            		var callback = pageCallbacks[page];
        			delete pageCallbacks[page];
            		
        			callback(cache[page] || new Array(pageSize));
        		}
        	}

        	// Let server know we're done 
			grid.$server.confirmUpdate(id);
		}
    },

	initArray: function(grid) {
		grid.items = [];
		grid.connectorSet = function(index, items) {
			for(var i = 0; i < items.length; i++) {
				grid.set("items." + (i + index), items[i]);
			} 
		};
		grid.connectorClear = function(index, length) {
			for(var i = 0; i < items.length; i++) {
				grid.set("items." + (i + index), null);
				delete grid.items[i + index];
			} 
		};
		grid.connectorUpdateSize = function(newSize) {
			var sizeDiff = newSize - grid.items.length;
			if (sizeDiff > 0) {
				var oldLength = grid.items.length;
				grid.items.length += sizeDiff;
				grid.notifySplices("items", [
					{
						index: oldLength,
						removed: [],
						addedCount: sizeDiff,
						object: grid.items,
						type: "splice"
					}
				]);
			} else if (sizeDiff < 0) {
				grid.splice("items", oldLength + sizeDiff, -sizeDiff);
			}
		};
		grid.connectorConfirm = function(id) {
			grid.$server.confirmUpdate(id);
		}
	}
}