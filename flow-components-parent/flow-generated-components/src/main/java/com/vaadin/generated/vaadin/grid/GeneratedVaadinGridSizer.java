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

@Generated({
		"Generator: com.vaadin.generator.ComponentGenerator#0.1.17-SNAPSHOT",
		"WebComponent: vaadin-grid-sizer#null", "Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid-sizer")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-sizer.html")
public class GeneratedVaadinGridSizer<R extends GeneratedVaadinGridSizer<R>>
		extends
			Component implements ComponentSupplier<R>, HasStyle {

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonArray protectedGetColumnTree() {
		return (JsonArray) getElement().getPropertyRaw("columnTree");
	}

	/**
	 * @param columnTree
	 *            the JsonArray value to set
	 * @return this instance, for method chaining
	 */
	protected R setColumnTree(elemental.json.JsonArray columnTree) {
		getElement().setPropertyJson("columnTree", columnTree);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getTop() {
		return getElement().getProperty("top", 0.0);
	}

	/**
	 * @param top
	 *            the double value to set
	 * @return this instance, for method chaining
	 */
	public R setTop(double top) {
		getElement().setProperty("top", top);
		return get();
	}
}