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
import com.vaadin.annotations.Synchronize;
import com.vaadin.annotations.DomEvent;
import com.vaadin.ui.ComponentEvent;
import com.vaadin.flow.event.ComponentEventListener;
import com.vaadin.shared.Registration;

/**
 * Description copied from corresponding location in WebComponent:
 * 
 * {@code vaadin-grid-selection-column} is a helper element for the
 * {@code vaadin-grid} that provides default templates and functionality for the
 * selection. With it the user can select rows using checkboxes displayed in a
 * column.
 * 
 * When the grid is configured with an array of items as the data provider, it
 * provides the feature of selecting all the items by clicking on the checkbox
 * in the header.
 */
@Generated({
		"Generator: com.vaadin.generator.ComponentGenerator#0.1.17-SNAPSHOT",
		"WebComponent: vaadin-grid-selection-column#null",
		"Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid-selection-column")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-selection-column.html")
public class GeneratedVaadinGridSelectionColumn<R extends GeneratedVaadinGridSelectionColumn<R>>
		extends
			Component implements ComponentSupplier<R>, HasStyle {

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When set to true, the column is user-resizable.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isResizable() {
		return getElement().getProperty("resizable", false);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When set to true, the column is user-resizable.
	 * 
	 * @param resizable
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setResizable(boolean resizable) {
		getElement().setProperty("resizable", resizable);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When true, the column is frozen. When a column inside of a column group
	 * is frozen, all of the sibling columns inside the group will get frozen
	 * also.
	 * <p>
	 * This property is synchronized automatically from client side when a
	 * 'frozen-changed' event happens.
	 */
	@Synchronize(property = "frozen", value = "frozen-changed")
	public boolean isFrozen() {
		return getElement().getProperty("frozen", false);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When true, the column is frozen. When a column inside of a column group
	 * is frozen, all of the sibling columns inside the group will get frozen
	 * also.
	 * 
	 * @param frozen
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setFrozen(boolean frozen) {
		getElement().setProperty("frozen", frozen);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When set to true, the cells for this column are hidden.
	 * <p>
	 * This property is synchronized automatically from client side when a
	 * 'hidden-changed' event happens.
	 */
	@Synchronize(property = "hidden", value = "hidden-changed")
	public boolean isHidden() {
		return getElement().getProperty("hidden", false);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When set to true, the cells for this column are hidden.
	 * 
	 * @param hidden
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setHidden(boolean hidden) {
		getElement().setProperty("hidden", hidden);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Width of the cells for this column.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public String getWidth() {
		return getElement().getProperty("width");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Width of the cells for this column.
	 * 
	 * @param width
	 *            the String value to set
	 * @return this instance, for method chaining
	 */
	public R setWidth(java.lang.String width) {
		getElement().setProperty("width", width == null ? "" : width);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Flex grow ratio for the cell widths. When set to 0, cell width is fixed.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getFlexGrow() {
		return getElement().getProperty("flexGrow", 0.0);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Flex grow ratio for the cell widths. When set to 0, cell width is fixed.
	 * 
	 * @param flexGrow
	 *            the double value to set
	 * @return this instance, for method chaining
	 */
	public R setFlexGrow(double flexGrow) {
		getElement().setProperty("flexGrow", flexGrow);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When true it selects all the items.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isSelectAll() {
		return getElement().getProperty("selectAll", false);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When true it selects all the items.
	 * 
	 * @param selectAll
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setSelectAll(boolean selectAll) {
		getElement().setProperty("selectAll", selectAll);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When true it adds the active item to selectedItems.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isAutoSelect() {
		return getElement().getProperty("autoSelect", false);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * When true it adds the active item to selectedItems.
	 * 
	 * @param autoSelect
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setAutoSelect(boolean autoSelect) {
		getElement().setProperty("autoSelect", autoSelect);
		return get();
	}

	@DomEvent("frozen-changed")
	public static class FrozenChangeEvent<R extends GeneratedVaadinGridSelectionColumn<R>>
			extends
				ComponentEvent<R> {
		public FrozenChangeEvent(R source, boolean fromClient) {
			super(source, fromClient);
		}
	}

	public Registration addFrozenChangeListener(
			ComponentEventListener<FrozenChangeEvent<R>> listener) {
		return addListener(FrozenChangeEvent.class,
				(ComponentEventListener) listener);
	}

	@DomEvent("hidden-changed")
	public static class HiddenChangeEvent<R extends GeneratedVaadinGridSelectionColumn<R>>
			extends
				ComponentEvent<R> {
		public HiddenChangeEvent(R source, boolean fromClient) {
			super(source, fromClient);
		}
	}

	public Registration addHiddenChangeListener(
			ComponentEventListener<HiddenChangeEvent<R>> listener) {
		return addListener(HiddenChangeEvent.class,
				(ComponentEventListener) listener);
	}

	@DomEvent("select-all-changed")
	public static class SelectAllChangeEvent<R extends GeneratedVaadinGridSelectionColumn<R>>
			extends
				ComponentEvent<R> {
		public SelectAllChangeEvent(R source, boolean fromClient) {
			super(source, fromClient);
		}
	}

	public Registration addSelectAllChangeListener(
			ComponentEventListener<SelectAllChangeEvent<R>> listener) {
		return addListener(SelectAllChangeEvent.class,
				(ComponentEventListener) listener);
	}
}