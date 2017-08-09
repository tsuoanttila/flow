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

@Generated({
		"Generator: com.vaadin.generator.ComponentGenerator#0.1.17-SNAPSHOT",
		"WebComponent: vaadin-grid-table-footer-cell#UNKNOWN",
		"Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid-table-footer-cell")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-table-cell.html")
public class GeneratedVaadinGridTableFooterCell<R extends GeneratedVaadinGridTableFooterCell<R>>
		extends
			Component implements ComponentSupplier<R>, HasStyle {

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetColumn() {
		return (JsonObject) getElement().getPropertyRaw("column");
	}

	/**
	 * @param column
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setColumn(elemental.json.JsonObject column) {
		getElement().setPropertyJson("column", column);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isExpanded() {
		return getElement().getProperty("expanded", false);
	}

	/**
	 * @param expanded
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setExpanded(boolean expanded) {
		getElement().setProperty("expanded", expanded);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getFlexGrow() {
		return getElement().getProperty("flexGrow", 0.0);
	}

	/**
	 * @param flexGrow
	 *            the double value to set
	 * @return this instance, for method chaining
	 */
	public R setFlexGrow(double flexGrow) {
		getElement().setProperty("flexGrow", flexGrow);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getColSpan() {
		return getElement().getProperty("colSpan", 0.0);
	}

	/**
	 * @param colSpan
	 *            the double value to set
	 * @return this instance, for method chaining
	 */
	public R setColSpan(double colSpan) {
		getElement().setProperty("colSpan", colSpan);
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
	public boolean isFrozen() {
		return getElement().getProperty("frozen", false);
	}

	/**
	 * @param frozen
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setFrozen(boolean frozen) {
		getElement().setProperty("frozen", frozen);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isLastFrozen() {
		return getElement().getProperty("lastFrozen", false);
	}

	/**
	 * @param lastFrozen
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setLastFrozen(boolean lastFrozen) {
		getElement().setProperty("lastFrozen", lastFrozen);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isHidden() {
		return getElement().getProperty("hidden", false);
	}

	/**
	 * @param hidden
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setHidden(boolean hidden) {
		getElement().setProperty("hidden", hidden);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetInstance() {
		return (JsonObject) getElement().getPropertyRaw("instance");
	}

	/**
	 * @param instance
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setInstance(elemental.json.JsonObject instance) {
		getElement().setPropertyJson("instance", instance);
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
	public boolean isSelected() {
		return getElement().getProperty("selected", false);
	}

	/**
	 * @param selected
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setSelected(boolean selected) {
		getElement().setProperty("selected", selected);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetTemplate() {
		return (JsonObject) getElement().getPropertyRaw("template");
	}

	/**
	 * @param template
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setTemplate(elemental.json.JsonObject template) {
		getElement().setPropertyJson("template", template);
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
	public String getWidth() {
		return getElement().getProperty("width");
	}

	/**
	 * @param width
	 *            the String value to set
	 * @return this instance, for method chaining
	 */
	public R setWidth(java.lang.String width) {
		getElement().setProperty("width", width == null ? "" : width);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getOrder() {
		return getElement().getProperty("order", 0.0);
	}

	/**
	 * @param order
	 *            the double value to set
	 * @return this instance, for method chaining
	 */
	public R setOrder(double order) {
		getElement().setProperty("order", order);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public String getReorderStatus() {
		return getElement().getProperty("reorderStatus");
	}

	/**
	 * @param reorderStatus
	 *            the String value to set
	 * @return this instance, for method chaining
	 */
	public R setReorderStatus(java.lang.String reorderStatus) {
		getElement().setProperty("reorderStatus",
				reorderStatus == null ? "" : reorderStatus);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetFooterTemplate() {
		return (JsonObject) getElement().getPropertyRaw("footerTemplate");
	}

	/**
	 * @param footerTemplate
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setFooterTemplate(elemental.json.JsonObject footerTemplate) {
		getElement().setPropertyJson("footerTemplate", footerTemplate);
		return get();
	}
}