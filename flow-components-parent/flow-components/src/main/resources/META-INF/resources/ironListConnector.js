window.ironListConnector = {
  initLazy: function(list) {
    const extraItemsBuffer = 20;
    
    let lastRequestedRange = [0, 0];

    list.$connector = {};
    
    const updateRequestedItem = function() {
    	/* 
    	 * TODO Iron list seems to do a small index adjustment after scrolling
    	 * has stopped. This causes a redundant request to be sent to make a
    	 * corresponding minimal change to the buffer. We should avoid these
    	 * requests by making the logic skip doing a request if the available
    	 * buffer is within some tolerance compared to the requested buffer.   
    	 */ 
        let firstNeededItem = list._virtualStart;
        let lastNeededItem = list._virtualEnd;

        let first = Math.max(0,  firstNeededItem - extraItemsBuffer);
        let last = Math.min(lastNeededItem + extraItemsBuffer, list.items.length);

        if (lastRequestedRange[0] != first || lastRequestedRange[1] != last) {
          lastRequestedRange = [first, last];
          let count = 1 + last - first;
          list.$server.setRequestedRange(first, count);
        }    	
    }
    
    var requestDebounce;
    const scheduleUpdateRequest = function() {
    	requestDebounce = Polymer.Debouncer.debounce(
    			requestDebounce,
    			  Polymer.Async.timeOut.after(10),
				  updateRequestedItem);
    }
    
    /*
     * Ensure all items that iron list will be looking at are actually defined.
     * If this is not done, the component will keep looking ahead through the
     * array until finding enough present items to render. In our case, that's
     * a really slow way of achieving nothing since the rest of the array is
     * empty.  
     */
    const originalAssign = list._assignModels;
    list._assignModels = function() {
    	var tempItems = [];
    	var start = list._virtualStart
    	for(var i = 0; i < list._physicalCount; i++) {
    		if (list.items[start + i] === undefined) {
    			tempItems.push(i);
    			list.items[start + i] = {__placeholder: true};
    		}
    	}
    	
    	originalAssign.apply(list, arguments);
    	
    	/*
    	 * TODO: Keep track of placeholder items in the "active" range and
    	 * avoid deleting them so that the next pass will be faster. Instead,
    	 * the end of each pass should only delete placeholders that are no
    	 * longer needed. 
    	 */
    	for(var i = 0; i < tempItems.length; i++) {
    		delete list.items[start + tempItems[i]];
    	}
    	
    	/*
    	 * Check if we need to do anything once things have settled down.
    	 * This method is called multiple times in sequence for the same user
    	 * action, but we only want to do the check once.
    	 */
    	scheduleUpdateRequest();
    }
    
    list.items = [];

    list.$connector.set = function(index, items) {
    	for(var i = 0; i < items.length; i++) {
    		var itemsIndex = index + i;
    		list.items[itemsIndex] = items[i];
    	}
    	// Do a full render since dirty detection for splices is broken
    	list._render();
    };

    list.$connector.updateData = function(items) {
    	// TODO How to find the right index to update based on only keys?
    	debugger;
    };

    list.$connector.clear = function(index, length) {
    	for(var i = 0; i < length; i++) {
    		var itemsIndex = index + i;
    		delete list.items[itemsIndex];
    		
    		// Most likely a no-op since the affected index isn't in view
    		list.notifyPath("items." + itemsIndex)
    	}
    };

    list.$connector.updateSize = function(newSize) {
    	var delta = newSize - list.items.length;
    	if (delta > 0) {
    		list.items.length = newSize;
    		
    		list.notifySplices("items", [{index: newSize - delta, removed: [], addedCount : delta, object: list.items, type: "splice"}]);
    	} else if (delta < 0){
    		// TODO Handle shrinking with a similar splice (but collect removed items before changing the length
    		debugger;
    	}
    	
    };

    list.$connector.confirm = function(id) {
      // TODO gridConnector does lots of stuff here. Anything relevant for us?
      list.$server.confirmUpdate(id);
    }
  }
}
