/*
 * Copyright 2000-2017 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.generated.vaadin.grid;

import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentSupplier;
import com.vaadin.ui.HasStyle;
import javax.annotation.Generated;
import com.vaadin.annotations.Tag;
import com.vaadin.annotations.HtmlImport;
import elemental.json.JsonObject;
import elemental.json.JsonArray;
import com.vaadin.components.NotSupported;
import com.vaadin.annotations.DomEvent;
import com.vaadin.ui.ComponentEvent;
import com.vaadin.flow.event.ComponentEventListener;
import com.vaadin.shared.Registration;
import com.vaadin.ui.HasComponents;

/**
 * Description copied from corresponding location in WebComponent:
 * 
 * {@code vaadin-grid} is a free, high quality data grid / data table Polymer
 * element, part of the Vaadin Core Elements.
 * 
 * ### Quick Start
 * 
 * - Use the <a href="#vaadin-grid-column">{@code <vaadin-grid-column>}</a>
 * element to configure the grid columns.
 * 
 * - Then assign an array to the <a href="#vaadin-grid:property-items">
 * {@code items}</a> property to visualize your data.
 * 
 * - In addition, there's helper elements such as <a
 * href="#vaadin-grid-column-group">{@code <vaadin-grid-column-group>}</a>, <a
 * href="#vaadin-grid-filter">{@code <vaadin-grid-filter>}</a>, <a
 * href="#vaadin-grid-sorter">{@code <vaadin-grid-sorter>}</a> and <a
 * href="#vaadin-grid-selection-column">{@code <vaadin-grid-selection-column>}
 * </a> that can be used to customize the grid. __Note that the helper elements
 * must be explicitly imported.__ If you want to import everything at once you
 * can use the {@code all-imports.html} bundle.
 * 
 * - A column template can be decorated with one the following class names to
 * specify its purpose - "header": Marks a header template - "footer": Marks a
 * footer template - "row-details": Marks a row details template
 * 
 * - The following built-in template variables can be bound to inside the column
 * templates - "index": Number representing the row index - "item" and it's
 * sub-properties: Data object (provided by a data provider / items array) -
 * "selected": True if the item is selected (can be two-way bound) - "expanded":
 * True if the item is expanded for row details (can be two-way bound)
 * 
 * #### Example:
 * 
 * <vaadin-grid items='[{"name": "John", "surname": "Lennon", "role": "singer"},
 * {"name": "Ringo", "surname": "Starr", "role": "drums"}]'>
 * <vaadin-grid-column> <template class="header">Name</template>
 * <template>[[item.name]]</template> </vaadin-grid-column> <vaadin-grid-column>
 * <template class="header">Surname</template>
 * <template>[[item.surname]]</template> </vaadin-grid-column>
 * <vaadin-grid-column> <template class="header">Role</template>
 * <template>[[item.role]]</template> </vaadin-grid-column> </vaadin-grid>
 * 
 * ### Lazy Loading with Function Data Provider
 * 
 * In addition to assigning an array to the items property, you can
 * alternatively provide the vaadin-grid data through the {@code dataProvider}
 * function property. The vaadin-grid element calls this function lazily, only
 * when it needs more data to be displayed.
 * 
 * See the <a href="#vaadin-grid:property-dataProvider">{@code dataProvider}</a>
 * in the API reference below for the detailed data provider arguments
 * description, and the “Assigning Data” page in the demos</a>.
 * 
 * __Note that when using function data providers, {@code size} always needs to
 * be set manually.__
 * 
 * grid.size = 200; // The total number of items grid.dataProvider =
 * function(params, callback) { var url = 'https://api.example/data' + '?page='
 * + params.page + // the requested page index '&per_page=' + params.pageSize;
 * // number of items on the page
 * 
 * var xhr = new XMLHttpRequest(); xhr.onload = function() { var response =
 * JSON.parse(xhr.responseText); callback(response.employees); };
 * xhr.open('GET', url, true); xhr.send(); };
 * 
 * ### Styling
 * 
 * The following custom properties and mixins are available for styling:
 * 
 * Custom property | Description | Default
 * ----------------|-------------|---------- {@code --vaadin-grid-cell} | Mixin
 * applied to all cells | {@code {@code --vaadin-grid-header-cell} | Mixin
 * applied to header cells | {@code {@code --vaadin-grid-footer-cell} | Mixin
 * applied to footer cells | {@code {@code --vaadin-grid-body-cell} | Mixin
 * applied to body cells | {@code {@code --vaadin-grid-body-row-odd-cell} |
 * Mixin applied to body cells on odd rows | {@code
 * {@code --vaadin-grid-cell-last-frozen} | Mixin applied to the last frozen
 * column cells | {@code {@code --vaadin-grid-body-row-hover-cell} | Mixin
 * applied to body cells on hovered row | {@code
 * {@code --vaadin-grid-body-row-selected-cell} | Mixin applied to body cells on
 * selected rows | {@code {@code --vaadin-grid-body-row-active-cell} | Mixin
 * applied to body cells on active row | {@code
 * {@code --vaadin-grid-body-row-details-cell} | Mixin applied to cells on
 * details rows | {@code {@code --vaadin-grid-focused-cell} | Mixin applied to
 * cells with keyboard focus | {@code {@code --vaadin-grid-loading-spinner} |
 * Mixin applied to the loading spinner | {@code
 * {@code --vaadin-grid-column-resize-handle} | Mixin applied to the column
 * resize handle | {@code
 * 
 * __Note:__ you can also style cell template contents by targeting them with
 * standard CSS. For example, using classes to apply custom background on a
 * frozen column and aling numeric contents to the right:
 * 
 * <style is="custom-style"> vaadin-grid { --vaadin-grid-cell: { padding: 0; };
 * }
 * 
 * .cell { height: 100%; display: flex; flex-direction: column; justify-content:
 * center; padding: 8px; }
 * 
 * .frozen { background: lightgray; }
 * 
 * .numeric { text-align: right; } </style>
 * 
 * <vaadin-grid>
 * 
 * <vaadin-grid-column width="100px" frozen> <template class="header"> <div
 * class="cell frozen">User Name</div> </template> <template> <div
 * class="cell frozen">[[item.username]]</div> </template> </vaadin-grid-column>
 * 
 * ...
 * 
 * <vaadin-grid-column> <template class="header"> <div
 * class="cell numeric">Age</div> </template> <template> <div
 * class="cell numeric">[[item.age]]</div> </template> </vaadin-grid-column>
 * 
 * </vaadin-grid>
 * 
 * See also the “Styling” demos.
 * 
 * ### Keyboard Navigation
 * 
 * #### In navigation mode
 * 
 * Key | Action ----|-------- <kbd>Tab</kbd> | Moves the keyboard focus from
 * header -> body -> footer <kbd>Shift</kbd>+<kbd>Tab</kbd> | Moves the keyboard
 * focus from header <- body <- footer <kbd>Down</kbd> | Moves the keyboard
 * focus to the cell on the next row <kbd>Up</kbd> | Moves the keyboard focus to
 * the cell on the previous row <kbd>Right</kbd> | Moves the keyboard focus to
 * the next cell <kbd>Left</kbd> | Moves the keyboard focus to the previous cell
 * <kbd>PgDn</kbd> | Moves the keyboard focus one page down <kbd>PgUp</kbd> |
 * Moves the keyboard focus one page up <kbd>Home</kbd> | Moves the keyboard
 * focus to the first cell of the focused row <kbd>End</kbd> | Moves the
 * keyboard focus to the last cell of the focused row
 * <kbd>Ctrl</kbd>+<kbd>Home</kbd> | Moves the keyboard focus to the first cell
 * of the first row <kbd>Ctrl</kbd>+<kbd>End</kbd> | Moves the keyboard focus to
 * the last cell of the last row <kbd>Space</kbd> | Activates the item on the
 * focused body cell <kbd>Enter</kbd> or <kbd>F2</kbd> | Activates the
 * interactive mode for the focused cell
 * 
 * <b>Note</b>: If the focused cell has child elements, the <kbd>Space</kbd> key
 * clicks the first child element of the focused cell. See an example on the
 * “Selection” demo page for more information.
 * 
 * #### In interactive mode
 * 
 * Key | Action ----|-------- <kbd>F2</kbd> or <kbd>ESC</kbd> | Deactivates the
 * interactive mode
 * 
 * <b>Note</b>: When entering interactive mode with <kbd>Enter</kbd> or
 * <kbd>F2</kbd>, the first element in the cell will be focused. You can
 * override the behavior by applying a {@code focus-target} attribute on the
 * child element your want to be focused first.
 */
@Generated({
		"Generator: com.vaadin.generator.ComponentGenerator#0.1.17-SNAPSHOT",
		"WebComponent: vaadin-grid#null", "Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid.html")
public class GeneratedVaadinGrid<R extends GeneratedVaadinGrid<R>>
		extends
			Component implements ComponentSupplier<R>, HasStyle, HasComponents {

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * The EventTarget that will be firing relevant KeyboardEvents. Set it to
	 * {@code null} to disable the listeners.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetKeyEventTarget() {
		return (JsonObject) getElement().getPropertyRaw("keyEventTarget");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * The EventTarget that will be firing relevant KeyboardEvents. Set it to
	 * {@code null} to disable the listeners.
	 * 
	 * @param keyEventTarget
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setKeyEventTarget(elemental.json.JsonObject keyEventTarget) {
		getElement().setPropertyJson("keyEventTarget", keyEventTarget);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * If true, this property will cause the implementing element to
	 * automatically stop propagation on any handled KeyboardEvents.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isStopKeyboardEventPropagation() {
		return getElement().getProperty("stopKeyboardEventPropagation", false);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * If true, this property will cause the implementing element to
	 * automatically stop propagation on any handled KeyboardEvents.
	 * 
	 * @param stopKeyboardEventPropagation
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setStopKeyboardEventPropagation(
			boolean stopKeyboardEventPropagation) {
		getElement().setProperty("stopKeyboardEventPropagation",
				stopKeyboardEventPropagation);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * To be used to express what combination of keys will trigger the relative
	 * callback. e.g. {@code keyBindings: 'esc': '_onEscPressed'}}
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetKeyBindings() {
		return (JsonObject) getElement().getPropertyRaw("keyBindings");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * To be used to express what combination of keys will trigger the relative
	 * callback. e.g. {@code keyBindings: 'esc': '_onEscPressed'}}
	 * 
	 * @param keyBindings
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setKeyBindings(elemental.json.JsonObject keyBindings) {
		getElement().setPropertyJson("keyBindings", keyBindings);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * The item user has last interacted with. Turns to {@code null} after user
	 * deactivates the item by re-interacting with the currently active item.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetActiveItem() {
		return (JsonObject) getElement().getPropertyRaw("activeItem");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * The item user has last interacted with. Turns to {@code null} after user
	 * deactivates the item by re-interacting with the currently active item.
	 * 
	 * @param activeItem
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setActiveItem(elemental.json.JsonObject activeItem) {
		getElement().setPropertyJson("activeItem", activeItem);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * An array containing references to expanded items.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonArray protectedGetExpandedItems() {
		return (JsonArray) getElement().getPropertyRaw("expandedItems");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * An array containing references to expanded items.
	 * 
	 * @param expandedItems
	 *            the JsonArray value to set
	 * @return this instance, for method chaining
	 */
	protected R setExpandedItems(elemental.json.JsonArray expandedItems) {
		getElement().setPropertyJson("expandedItems", expandedItems);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Number of items fetched at a time from the dataprovider.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getPageSize() {
		return getElement().getProperty("pageSize", 0.0);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Number of items fetched at a time from the dataprovider.
	 * 
	 * @param pageSize
	 *            the double value to set
	 * @return this instance, for method chaining
	 */
	public R setPageSize(double pageSize) {
		getElement().setProperty("pageSize", pageSize);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Function that provides items lazily. Receives arguments {@code params},
	 * {@code callback}
	 * 
	 * {@code params.page} Requested page index
	 * 
	 * {@code params.pageSize} Current page size
	 * 
	 * {@code params.filters} Currently applied filters
	 * 
	 * {@code params.sortOrders} Currently applied sorting orders
	 * 
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetDataProvider() {
		return (JsonObject) getElement().getPropertyRaw("dataProvider");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Function that provides items lazily. Receives arguments {@code params},
	 * {@code callback}
	 * 
	 * {@code params.page} Requested page index
	 * 
	 * {@code params.pageSize} Current page size
	 * 
	 * {@code params.filters} Currently applied filters
	 * 
	 * {@code params.sortOrders} Currently applied sorting orders
	 * 
	 * 
	 * @param dataProvider
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setDataProvider(elemental.json.JsonObject dataProvider) {
		getElement().setPropertyJson("dataProvider", dataProvider);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * An array containing the items which will be stamped to the column
	 * template instances.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonArray protectedGetItems() {
		return (JsonArray) getElement().getPropertyRaw("items");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * An array containing the items which will be stamped to the column
	 * template instances.
	 * 
	 * @param items
	 *            the JsonArray value to set
	 * @return this instance, for method chaining
	 */
	protected R setItems(elemental.json.JsonArray items) {
		getElement().setPropertyJson("items", items);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * An array that contains the selected items.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetSelectedItems() {
		return (JsonObject) getElement().getPropertyRaw("selectedItems");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * An array that contains the selected items.
	 * 
	 * @param selectedItems
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setSelectedItems(elemental.json.JsonObject selectedItems) {
		getElement().setPropertyJson("selectedItems", selectedItems);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When {@code true}, all {@code <vaadin-grid-sorter>} are applied for
	 * sorting.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isMultiSort() {
		return getElement().getProperty("multiSort", false);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When {@code true}, all {@code <vaadin-grid-sorter>} are applied for
	 * sorting.
	 * 
	 * @param multiSort
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setMultiSort(boolean multiSort) {
		getElement().setProperty("multiSort", multiSort);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Set to true to allow column reordering.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isColumnReorderingAllowed() {
		return getElement().getProperty("columnReorderingAllowed", false);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Set to true to allow column reordering.
	 * 
	 * @param columnReorderingAllowed
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setColumnReorderingAllowed(boolean columnReorderingAllowed) {
		getElement().setProperty("columnReorderingAllowed",
				columnReorderingAllowed);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isInteracting() {
		return getElement().getProperty("interacting", false);
	}

	/**
	 * @param interacting
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setInteracting(boolean interacting) {
		getElement().setProperty("interacting", interacting);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isNavigating() {
		return getElement().getProperty("navigating", false);
	}

	/**
	 * @param navigating
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setNavigating(boolean navigating) {
		getElement().setProperty("navigating", navigating);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Estimated size of the grid data (number of items). When using function
	 * data providers, it always needs to be set manually.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getSize() {
		return getElement().getProperty("size", 0.0);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Estimated size of the grid data (number of items). When using function
	 * data providers, it always needs to be set manually.
	 * 
	 * @param size
	 *            the double value to set
	 * @return this instance, for method chaining
	 */
	public R setSize(double size) {
		getElement().setProperty("size", size);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Can be used to imperatively add a key binding to the implementing
	 * element. This is the imperative equivalent of declaring a keybinding in
	 * the {@code keyBindings} prototype property.
	 * 
	 * @param eventString
	 *            Missing documentation!
	 * @param handlerName
	 *            Missing documentation!
	 */
	public void addOwnKeyBinding(java.lang.String eventString,
			java.lang.String handlerName) {
		getElement().callFunction("addOwnKeyBinding", eventString, handlerName);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When called, will remove all imperatively-added key bindings.
	 */
	public void removeOwnKeyBindings() {
		getElement().callFunction("removeOwnKeyBindings");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Returns true if a keyboard event matches {@code eventString}.
	 * 
	 * @param event
	 *            Missing documentation!
	 * @param eventString
	 *            Missing documentation!
	 * @return It would return a boolean
	 */
	@NotSupported
	protected void keyboardEventMatchesKeys(elemental.json.JsonObject event,
			java.lang.String eventString) {
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Can be called to manually notify a resizable and its descendant
	 * resizables of a resize change.
	 */
	public void notifyResize() {
		getElement().callFunction("notifyResize");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Used to assign the closest resizable ancestor to this resizable if the
	 * ancestor detects a request for notifications.
	 * 
	 * @param parentResizable
	 *            Missing documentation!
	 */
	protected void assignParentResizable(
			elemental.json.JsonObject parentResizable) {
		getElement().callFunction("assignParentResizable", parentResizable);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Used to remove a resizable descendant from the list of descendants that
	 * should be notified of a resize change.
	 * 
	 * @param target
	 *            Missing documentation!
	 */
	protected void stopResizeNotificationsFor(elemental.json.JsonObject target) {
		getElement().callFunction("stopResizeNotificationsFor", target);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * This method can be overridden to filter nested elements that should or
	 * should not be notified by the current element. Return true if an element
	 * should be notified, or false if it should not be notified.
	 * 
	 * @param element
	 *            A candidate descendant element that implements
	 *            `IronResizableBehavior`.
	 * @return It would return a boolean
	 */
	@NotSupported
	protected void resizerShouldNotify(elemental.json.JsonObject element) {
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Expand the details row of a given item.
	 * 
	 * @param item
	 *            Missing documentation!
	 */
	protected void expandItem(elemental.json.JsonObject item) {
		getElement().callFunction("expandItem", item);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Collapse the details row of a given item.
	 * 
	 * @param item
	 *            Missing documentation!
	 */
	protected void collapseItem(elemental.json.JsonObject item) {
		getElement().callFunction("collapseItem", item);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Clears the cached pages and reloads data from dataprovider when needed.
	 */
	public void clearCache() {
		getElement().callFunction("clearCache");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Selects the given item.
	 * 
	 * @param item
	 *            The item index or the item object
	 */
	protected void selectItem(elemental.json.JsonObject item) {
		getElement().callFunction("selectItem", item);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Selects the given item.
	 * 
	 * @param item
	 *            The item index or the item object
	 */
	public void selectItem(double item) {
		getElement().callFunction("selectItem", item);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Deselects the given item if it is already selected.
	 * 
	 * @param item
	 *            The item index or the item object
	 */
	protected void deselectItem(elemental.json.JsonObject item) {
		getElement().callFunction("deselectItem", item);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Deselects the given item if it is already selected.
	 * 
	 * @param item
	 *            The item index or the item object
	 */
	public void deselectItem(double item) {
		getElement().callFunction("deselectItem", item);
	}

	@DomEvent("active-item-changed")
	public static class ActiveItemChangeEvent<R extends GeneratedVaadinGrid<R>>
			extends
				ComponentEvent<R> {
		public ActiveItemChangeEvent(R source, boolean fromClient) {
			super(source, fromClient);
		}
	}

	public Registration addActiveItemChangeListener(
			ComponentEventListener<ActiveItemChangeEvent<R>> listener) {
		return addListener(ActiveItemChangeEvent.class,
				(ComponentEventListener) listener);
	}

	@DomEvent("data-provider-changed")
	public static class DataProviderChangeEvent<R extends GeneratedVaadinGrid<R>>
			extends
				ComponentEvent<R> {
		public DataProviderChangeEvent(R source, boolean fromClient) {
			super(source, fromClient);
		}
	}

	public Registration addDataProviderChangeListener(
			ComponentEventListener<DataProviderChangeEvent<R>> listener) {
		return addListener(DataProviderChangeEvent.class,
				(ComponentEventListener) listener);
	}

	@DomEvent("selected-items-changed")
	public static class SelectedItemsChangeEvent<R extends GeneratedVaadinGrid<R>>
			extends
				ComponentEvent<R> {
		public SelectedItemsChangeEvent(R source, boolean fromClient) {
			super(source, fromClient);
		}
	}

	public Registration addSelectedItemsChangeListener(
			ComponentEventListener<SelectedItemsChangeEvent<R>> listener) {
		return addListener(SelectedItemsChangeEvent.class,
				(ComponentEventListener) listener);
	}

	/**
	 * Adds the given components as children of this component at the slot
	 * 'footerFocusTrap'.
	 * 
	 * @param components
	 *            The components to add.
	 * @see <a
	 *      href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/slot">MDN
	 *      page about slots</a>
	 * @see <a
	 *      href="https://html.spec.whatwg.org/multipage/scripting.html#the-slot-element">Spec
	 *      website about slots</a>
	 * @return this instance, for method chaining
	 */
	public R addToFooterFocusTrap(com.vaadin.ui.Component... components) {
		for (Component component : components) {
			component.getElement().setAttribute("slot", "footerFocusTrap");
			getElement().appendChild(component.getElement());
		}
		return get();
	}

	@Override
	public void remove(com.vaadin.ui.Component... components) {
		for (Component component : components) {
			if (getElement().equals(component.getElement().getParent())) {
				component.getElement().removeAttribute("slot");
				getElement().removeChild(component.getElement());
			} else {
				throw new IllegalArgumentException("The given component ("
						+ component + ") is not a child of this component");
			}
		}
	}

	@Override
	public void removeAll() {
		getElement().getChildren().forEach(
				child -> child.removeAttribute("slot"));
		getElement().removeAllChildren();
	}

	/**
	 * Adds the given components as children of this component.
	 * 
	 * @param components
	 *            the components to add
	 * @see HasComponents#add(Component...)
	 */
	public GeneratedVaadinGrid(com.vaadin.ui.Component... components) {
		add(components);
	}

	/**
	 * Default constructor.
	 */
	public GeneratedVaadinGrid() {
	}
}