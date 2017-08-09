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
import elemental.json.JsonArray;
import elemental.json.JsonObject;

@Generated({
		"Generator: com.vaadin.generator.ComponentGenerator#0.1.17-SNAPSHOT",
		"WebComponent: vaadin-grid-table-header-row#UNKNOWN",
		"Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid-table-header-row")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-table-row.html")
public class GeneratedVaadinGridTableHeaderRow<R extends GeneratedVaadinGridTableHeaderRow<R>>
		extends
			Component implements ComponentSupplier<R>, HasStyle {

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isActive() {
		return getElement().getProperty("active", false);
	}

	/**
	 * @param active
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setActive(boolean active) {
		getElement().setProperty("active", active);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonArray protectedGetColumns() {
		return (JsonArray) getElement().getPropertyRaw("columns");
	}

	/**
	 * @param columns
	 *            the JsonArray value to set
	 * @return this instance, for method chaining
	 */
	protected R setColumns(elemental.json.JsonArray columns) {
		getElement().setPropertyJson("columns", columns);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getIndex() {
		return getElement().getProperty("index", 0.0);
	}

	/**
	 * @param index
	 *            the double value to set
	 * @return this instance, for method chaining
	 */
	public R setIndex(double index) {
		getElement().setProperty("index", index);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetCells() {
		return (JsonObject) getElement().getPropertyRaw("cells");
	}

	/**
	 * @param cells
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setCells(elemental.json.JsonObject cells) {
		getElement().setPropertyJson("cells", cells);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetTarget() {
		return (JsonObject) getElement().getPropertyRaw("target");
	}

	/**
	 * @param target
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setTarget(elemental.json.JsonObject target) {
		getElement().setPropertyJson("target", target);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetExpanded() {
		return (JsonObject) getElement().getPropertyRaw("expanded");
	}

	/**
	 * @param expanded
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setExpanded(elemental.json.JsonObject expanded) {
		getElement().setPropertyJson("expanded", expanded);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isFocused() {
		return getElement().getProperty("focused", false);
	}

	/**
	 * @param focused
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setFocused(boolean focused) {
		getElement().setProperty("focused", focused);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetItem() {
		return (JsonObject) getElement().getPropertyRaw("item");
	}

	/**
	 * @param item
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setItem(elemental.json.JsonObject item) {
		getElement().setPropertyJson("item", item);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetSelected() {
		return (JsonObject) getElement().getPropertyRaw("selected");
	}

	/**
	 * @param selected
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setSelected(elemental.json.JsonObject selected) {
		getElement().setPropertyJson("selected", selected);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetRowDetailsTemplate() {
		return (JsonObject) getElement().getPropertyRaw("rowDetailsTemplate");
	}

	/**
	 * @param rowDetailsTemplate
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setRowDetailsTemplate(
			elemental.json.JsonObject rowDetailsTemplate) {
		getElement().setPropertyJson("rowDetailsTemplate", rowDetailsTemplate);
		return get();
	}

	/**
	 * @param callback
	 *            Missing documentation!
	 */
	protected void iterateCells(elemental.json.JsonObject callback) {
		getElement().callFunction("iterateCells", callback);
	}

	public void updateRowDetailsCellMetrics() {
		getElement().callFunction("updateRowDetailsCellMetrics");
	}

	public void updateLastColumn() {
		getElement().callFunction("updateLastColumn");
	}
}