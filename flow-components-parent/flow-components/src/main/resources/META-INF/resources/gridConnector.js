window.gridConnector = {
	initArray: function(grid) {
		debugger;
		grid.items = [];
		grid.connectorSet = function(index, items) {
			debugger;
			for(var i = 0; i < items.length; i++) {
				grid.set("items." + (i + index), items[i]);
			} 
		};
		grid.connectorClear = function(index, length) {
			debugger;
			for(var i = 0; i < items.length; i++) {
				grid.set("items." + (i + index), null);
				delete grid.items[i + index];
			} 
		};
		grid.connectorUpdateSize = function(newSize) {
			debugger;
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