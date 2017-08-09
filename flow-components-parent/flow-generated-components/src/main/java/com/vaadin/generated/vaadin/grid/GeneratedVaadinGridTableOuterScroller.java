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
import com.vaadin.ui.HasComponents;

@Generated({
		"Generator: com.vaadin.generator.ComponentGenerator#0.1.17-SNAPSHOT",
		"WebComponent: vaadin-grid-table-outer-scroller#null",
		"Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid-table-outer-scroller")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-table-outer-scroller.html")
public class GeneratedVaadinGridTableOuterScroller<R extends GeneratedVaadinGridTableOuterScroller<R>>
		extends
			Component implements ComponentSupplier<R>, HasStyle, HasComponents {

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetScrollTarget() {
		return (JsonObject) getElement().getPropertyRaw("scrollTarget");
	}

	/**
	 * @param scrollTarget
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setScrollTarget(elemental.json.JsonObject scrollTarget) {
		getElement().setPropertyJson("scrollTarget", scrollTarget);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isPassthrough() {
		return getElement().getProperty("passthrough", false);
	}

	/**
	 * @param passthrough
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setPassthrough(boolean passthrough) {
		getElement().setProperty("passthrough", passthrough);
		return get();
	}

	/**
	 * Adds the given components as children of this component.
	 * 
	 * @param components
	 *            the components to add
	 * @see HasComponents#add(Component...)
	 */
	public GeneratedVaadinGridTableOuterScroller(
			com.vaadin.ui.Component... components) {
		add(components);
	}

	/**
	 * Default constructor.
	 */
	public GeneratedVaadinGridTableOuterScroller() {
	}
}