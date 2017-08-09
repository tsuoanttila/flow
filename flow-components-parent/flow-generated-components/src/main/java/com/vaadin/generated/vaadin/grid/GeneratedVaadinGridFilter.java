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
import com.vaadin.components.data.HasValue;

/**
 * Description copied from corresponding location in WebComponent:
 * 
 * {@code vaadin-grid-filter} is a helper element for the {@code vaadin-grid}
 * that provides out-of-the-box UI controls, and handlers for filtering the grid
 * data.
 */
@Generated({
		"Generator: com.vaadin.generator.ComponentGenerator#0.1.17-SNAPSHOT",
		"WebComponent: vaadin-grid-filter#null", "Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid-filter")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-filter.html")
public class GeneratedVaadinGridFilter<R extends GeneratedVaadinGridFilter<R>>
		extends
			Component
		implements
			ComponentSupplier<R>,
			HasStyle,
			HasValue<R, String> {

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * JS Path of the property in the item used for filtering the data.
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
	 * JS Path of the property in the item used for filtering the data.
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
	 * Current filter value.
	 * <p>
	 * This property is synchronized automatically from client side when a
	 * 'value-changed' event happens.
	 */
	@Synchronize(property = "value", value = "value-changed")
	@Override
	public String getValue() {
		return getElement().getProperty("value");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Current filter value.
	 * 
	 * @param value
	 *            the String value to set
	 * @return this instance, for method chaining
	 */
	@Override
	public R setValue(java.lang.String value) {
		getElement().setProperty("value", value == null ? "" : value);
		return get();
	}

	/**
	 * Adds the given components as children of this component at the slot
	 * 'filter'.
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
	public R addToFilter(com.vaadin.ui.Component... components) {
		for (Component component : components) {
			component.getElement().setAttribute("slot", "filter");
			getElement().appendChild(component.getElement());
		}
		return get();
	}

	/**
	 * Removes the given child components from this component.
	 * 
	 * @param components
	 *            The components to remove.
	 * @throws IllegalArgumentException
	 *             if any of the components is not a child of this component.
	 */
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

	/**
	 * Removes all contents from this component, this includes child components,
	 * text content as well as child elements that have been added directly to
	 * this component using the {@link Element} API.
	 */
	public void removeAll() {
		getElement().getChildren().forEach(
				child -> child.removeAttribute("slot"));
		getElement().removeAllChildren();
	}
}