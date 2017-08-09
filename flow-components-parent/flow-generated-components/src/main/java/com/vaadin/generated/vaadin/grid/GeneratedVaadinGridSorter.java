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
import com.vaadin.ui.HasComponents;

/**
 * Description copied from corresponding location in WebComponent:
 * 
 * {@code vaadin-grid-sorter} is a helper element for the {@code vaadin-grid}
 * that provides out-of-the-box UI controls, visual feedback, and handlers for
 * sorting the grid data.
 * 
 * 
 * ### Styling The following custom properties and mixins are available for
 * styling:
 * 
 * Custom property | Description | Default
 * ----------------|-------------|---------- {@code --vaadin-grid-sorter-arrow}
 * | Mixin applied to the arrow | {@code {@code --vaadin-grid-sorter-order} |
 * Mixin applied to the order | {@code
 */
@Generated({
		"Generator: com.vaadin.generator.ComponentGenerator#0.1.17-SNAPSHOT",
		"WebComponent: vaadin-grid-sorter#null", "Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid-sorter")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-sorter.html")
public class GeneratedVaadinGridSorter<R extends GeneratedVaadinGridSorter<R>>
		extends
			Component implements ComponentSupplier<R>, HasStyle, HasComponents {

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * JS Path of the property in the item used for sorting the data.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public String getPath() {
		return getElement().getProperty("path");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * JS Path of the property in the item used for sorting the data.
	 * 
	 * @param path
	 *            the String value to set
	 * @return this instance, for method chaining
	 */
	public R setPath(java.lang.String path) {
		getElement().setProperty("path", path == null ? "" : path);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * How to sort the data. Possible values are {@code asc} to use an ascending
	 * algorithm, {@code desc} to sort the data in descending direction, or
	 * {@code null} for not sorting the data.
	 * <p>
	 * This property is synchronized automatically from client side when a
	 * 'direction-changed' event happens.
	 */
	@Synchronize(property = "direction", value = "direction-changed")
	public String getDirection() {
		return getElement().getProperty("direction");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * How to sort the data. Possible values are {@code asc} to use an ascending
	 * algorithm, {@code desc} to sort the data in descending direction, or
	 * {@code null} for not sorting the data.
	 * 
	 * @param direction
	 *            the String value to set
	 * @return this instance, for method chaining
	 */
	public R setDirection(java.lang.String direction) {
		getElement().setProperty("direction",
				direction == null ? "" : direction);
		return get();
	}

	@DomEvent("direction-changed")
	public static class DirectionChangeEvent<R extends GeneratedVaadinGridSorter<R>>
			extends
				ComponentEvent<R> {
		public DirectionChangeEvent(R source, boolean fromClient) {
			super(source, fromClient);
		}
	}

	public Registration addDirectionChangeListener(
			ComponentEventListener<DirectionChangeEvent<R>> listener) {
		return addListener(DirectionChangeEvent.class,
				(ComponentEventListener) listener);
	}

	/**
	 * Adds the given components as children of this component.
	 * 
	 * @param components
	 *            the components to add
	 * @see HasComponents#add(Component...)
	 */
	public GeneratedVaadinGridSorter(com.vaadin.ui.Component... components) {
		add(components);
	}

	/**
	 * Default constructor.
	 */
	public GeneratedVaadinGridSorter() {
	}
}