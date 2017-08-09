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
		"WebComponent: vaadin-grid-table-focus-trap#null",
		"Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid-table-focus-trap")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-table-focus-trap.html")
public class GeneratedVaadinGridTableFocusTrap<R extends GeneratedVaadinGridTableFocusTrap<R>>
		extends
			Component implements ComponentSupplier<R>, HasStyle, HasComponents {

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public String getActiveTarget() {
		return getElement().getProperty("activeTarget");
	}

	/**
	 * @param activeTarget
	 *            the String value to set
	 * @return this instance, for method chaining
	 */
	public R setActiveTarget(java.lang.String activeTarget) {
		getElement().setProperty("activeTarget",
				activeTarget == null ? "" : activeTarget);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * so it's easier to avoid using them across shadow roots.
	 * 
	 * @param e
	 *            Missing documentation!
	 */
	protected void focus(JsonObject e) {
		getElement().callFunction("focus", e);
	}

	/**
	 * Adds the given components as children of this component.
	 * 
	 * @param components
	 *            the components to add
	 * @see HasComponents#add(Component...)
	 */
	public GeneratedVaadinGridTableFocusTrap(
			com.vaadin.ui.Component... components) {
		add(components);
	}

	/**
	 * Default constructor.
	 */
	public GeneratedVaadinGridTableFocusTrap() {
	}
}