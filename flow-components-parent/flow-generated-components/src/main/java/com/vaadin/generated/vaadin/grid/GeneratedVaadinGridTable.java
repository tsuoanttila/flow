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
import com.vaadin.ui.HasComponents;

@Generated({
		"Generator: com.vaadin.generator.ComponentGenerator#0.1.17-SNAPSHOT",
		"WebComponent: vaadin-grid-table#null", "Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid-table")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-table.html")
public class GeneratedVaadinGridTable<R extends GeneratedVaadinGridTable<R>>
		extends
			Component implements ComponentSupplier<R>, HasStyle, HasComponents {

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Specifies the element that will handle the scroll event on the behalf of
	 * the current element. This is typically a reference to an element, but
	 * there are a few more posibilities:
	 * 
	 * ### Elements id
	 * 
	 * {@code }`html <div id="scrollable-element" style="overflow: auto;">
	 * <x-element scroll-target="scrollable-element"> <!-- Content-->
	 * </x-element> </div> {@code }` In this case, the {@code scrollTarget} will
	 * point to the outer div element.
	 * 
	 * ### Document scrolling
	 * 
	 * For document scrolling, you can use the reserved word {@code document}:
	 * 
	 * {@code }`html <x-element scroll-target="document"> <!-- Content -->
	 * </x-element> {@code }`
	 * 
	 * ### Elements reference
	 * 
	 * {@code }`js appHeader.scrollTarget =
	 * document.querySelector('#scrollable-element'); {@code }`
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	protected JsonObject protectedGetScrollTarget() {
		return (JsonObject) getElement().getPropertyRaw("scrollTarget");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Specifies the element that will handle the scroll event on the behalf of
	 * the current element. This is typically a reference to an element, but
	 * there are a few more posibilities:
	 * 
	 * ### Elements id
	 * 
	 * {@code }`html <div id="scrollable-element" style="overflow: auto;">
	 * <x-element scroll-target="scrollable-element"> <!-- Content-->
	 * </x-element> </div> {@code }` In this case, the {@code scrollTarget} will
	 * point to the outer div element.
	 * 
	 * ### Document scrolling
	 * 
	 * For document scrolling, you can use the reserved word {@code document}:
	 * 
	 * {@code }`html <x-element scroll-target="document"> <!-- Content -->
	 * </x-element> {@code }`
	 * 
	 * ### Elements reference
	 * 
	 * {@code }`js appHeader.scrollTarget =
	 * document.querySelector('#scrollable-element'); {@code }`
	 * 
	 * @param scrollTarget
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setScrollTarget(elemental.json.JsonObject scrollTarget) {
		getElement().setPropertyJson("scrollTarget", scrollTarget);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * The max count of physical items the pool can extend to.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getMaxPhysicalCount() {
		return getElement().getProperty("maxPhysicalCount", 0.0);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * The max count of physical items the pool can extend to.
	 * 
	 * @param maxPhysicalCount
	 *            the double value to set
	 * @return this instance, for method chaining
	 */
	public R setMaxPhysicalCount(double maxPhysicalCount) {
		getElement().setProperty("maxPhysicalCount", maxPhysicalCount);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * The name of the variable to add to the binding scope for the array
	 * element associated with a given template instance.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public String getAs() {
		return getElement().getProperty("as");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * The name of the variable to add to the binding scope for the array
	 * element associated with a given template instance.
	 * 
	 * @param as
	 *            the String value to set
	 * @return this instance, for method chaining
	 */
	public R setAs(java.lang.String as) {
		getElement().setProperty("as", as == null ? "" : as);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * The name of the variable to add to the binding scope with the index for
	 * the row.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public String getIndexAs() {
		return getElement().getProperty("indexAs");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * The name of the variable to add to the binding scope with the index for
	 * the row.
	 * 
	 * @param indexAs
	 *            the String value to set
	 * @return this instance, for method chaining
	 */
	public R setIndexAs(java.lang.String indexAs) {
		getElement().setProperty("indexAs", indexAs == null ? "" : indexAs);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isIos() {
		return getElement().getProperty("ios", false);
	}

	/**
	 * @param ios
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setIos(boolean ios) {
		getElement().setProperty("ios", ios);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isFixedSections() {
		return getElement().getProperty("fixedSections", false);
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isScrolling() {
		return getElement().getProperty("scrolling", false);
	}

	/**
	 * @param scrolling
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setScrolling(boolean scrolling) {
		getElement().setProperty("scrolling", scrolling);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getSize() {
		return getElement().getProperty("size", 0.0);
	}

	/**
	 * @param size
	 *            the double value to set
	 * @return this instance, for method chaining
	 */
	public R setSize(double size) {
		getElement().setProperty("size", size);
		return get();
	}

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
	protected JsonObject protectedGetBindData() {
		return (JsonObject) getElement().getPropertyRaw("bindData");
	}

	/**
	 * @param bindData
	 *            the JsonObject value to set
	 * @return this instance, for method chaining
	 */
	protected R setBindData(elemental.json.JsonObject bindData) {
		getElement().setPropertyJson("bindData", bindData);
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
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public boolean isColumnReorderingAllowed() {
		return getElement().getProperty("columnReorderingAllowed", false);
	}

	/**
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
	public boolean isSafari() {
		return getElement().getProperty("safari", false);
	}

	/**
	 * @param safari
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setSafari(boolean safari) {
		getElement().setProperty("safari", safari);
		return get();
	}

	/**
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getScrollbarWidth() {
		return getElement().getProperty("scrollbarWidth", 0.0);
	}

	/**
	 * @param scrollbarWidth
	 *            the double value to set
	 * @return this instance, for method chaining
	 */
	public R setScrollbarWidth(double scrollbarWidth) {
		getElement().setProperty("scrollbarWidth", scrollbarWidth);
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
	public boolean hasData() {
		return getElement().getProperty("hasData", false);
	}

	/**
	 * @param hasData
	 *            the boolean value to set
	 * @return this instance, for method chaining
	 */
	public R setHasData(boolean hasData) {
		getElement().setProperty("hasData", hasData);
		return get();
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Generates an anonymous {@code TemplateInstance} class (stored as
	 * {@code this.ctor}) for the provided template. This method should be
	 * called once per template to prepare an element for stamping the template,
	 * followed by {@code stamp} to create new instances of the template.
	 * 
	 * @param template
	 *            Template to prepare
	 * @param mutableData
	 *            When `true`, the generated class will skip strict
	 *            dirty-checking for objects and arrays (always consider them to
	 *            be "dirty"). Defaults to false.
	 */
	protected void templatize(elemental.json.JsonObject template,
			elemental.json.JsonObject mutableData) {
		getElement().callFunction("templatize", template, mutableData);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Creates an instance of the template prepared by {@code templatize}. The
	 * object returned is an instance of the anonymous class generated by
	 * {@code templatize} whose {@code root} property is a document fragment
	 * containing newly cloned template content, and which has property
	 * accessors corresponding to properties referenced in template bindings.
	 * 
	 * @param model
	 *            Object containing initial property values to populate into the
	 *            template bindings.
	 * @return It would return a interface elemental.json.JsonObject
	 */
	@NotSupported
	protected void stamp(elemental.json.JsonObject model) {
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Returns the template "model" ({@code TemplateInstance}) associated with a
	 * given element, which serves as the binding scope for the template
	 * instance the element is contained in. A template model should be used to
	 * manipulate data associated with this template instance.
	 * 
	 * @param el
	 *            Element for which to return a template model.
	 * @return It would return a interface elemental.json.JsonObject
	 */
	@NotSupported
	protected void modelForElement(elemental.json.JsonObject el) {
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Scrolls the content to a particular place.
	 * 
	 * @param left
	 *            The left position
	 * @param top
	 *            The top position
	 */
	public void scroll(double left, double top) {
		getElement().callFunction("scroll", left, top);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Enables or disables the scroll event listener.
	 * 
	 * @param yes
	 *            True to add the event, False to remove it.
	 */
	public void toggleScrollListener(boolean yes) {
		getElement().callFunction("toggleScrollListener", yes);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Gets the index of the first visible item in the viewport.
	 */
	public void firstVisibleIndex() {
		getElement().callFunction("firstVisibleIndex");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Gets the index of the last visible item in the viewport.
	 */
	public void lastVisibleIndex() {
		getElement().callFunction("lastVisibleIndex");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Invoke this method if you dynamically update the viewport's size or CSS
	 * padding.
	 */
	public void updateViewportBoundaries() {
		getElement().callFunction("updateViewportBoundaries");
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Scroll to a specific index in the virtual list regardless of the physical
	 * items in the DOM tree.
	 * 
	 * @param idx
	 *            The index of the item
	 */
	public void scrollToIndex(double idx) {
		getElement().callFunction("scrollToIndex", idx);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * TODO: rename to updateSizeForIndex ?
	 * 
	 * @param index
	 *            Missing documentation!
	 */
	protected void updateSizeForItem(elemental.json.JsonObject index) {
		getElement().callFunction("updateSizeForItem", index);
	}

	/**
	 * Description copied from corresponding location in WebComponent:
	 * 
	 * Scroll to a specific index (also scaled indexes) in the virtual list.
	 * 
	 * @param idx
	 *            Missing documentation!
	 */
	protected void scrollToScaledIndex(elemental.json.JsonObject idx) {
		getElement().callFunction("scrollToScaledIndex", idx);
	}

	/**
	 * Adds the given components as children of this component at the slot
	 * 'header'.
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
	public R addToHeader(com.vaadin.ui.Component... components) {
		for (Component component : components) {
			component.getElement().setAttribute("slot", "header");
			getElement().appendChild(component.getElement());
		}
		return get();
	}

	/**
	 * Adds the given components as children of this component at the slot
	 * 'items'.
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
	public R addToItems(com.vaadin.ui.Component... components) {
		for (Component component : components) {
			component.getElement().setAttribute("slot", "items");
			getElement().appendChild(component.getElement());
		}
		return get();
	}

	/**
	 * Adds the given components as children of this component at the slot
	 * 'footer'.
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
	public R addToFooter(com.vaadin.ui.Component... components) {
		for (Component component : components) {
			component.getElement().setAttribute("slot", "footer");
			getElement().appendChild(component.getElement());
		}
		return get();
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
	public GeneratedVaadinGridTable(com.vaadin.ui.Component... components) {
		add(components);
	}

	/**
	 * Default constructor.
	 */
	public GeneratedVaadinGridTable() {
	}
}