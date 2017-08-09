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
 * A {@code vaadin-grid-column-group} is used to wrap many columns under a
 * common header. It supports nested groups.
 * 
 * The {@code class} attribute is used to differentiate header and footer
 * templates.
 * 
 * #### Example:
 * 
 * <vaadin-grid> <vaadin-grid-column-group> <template class="header">I'm in the
 * group header</template> <template class="footer">I'm in the group
 * footer</template> <vaadin-grid-column> <template class="header">I'm in the
 * first header</template> <template>I'm in the first body cell</template>
 * <template class="footer">I'm in the first footer</template>
 * </vaadin-grid-column> <vaadin-grid-column> <template class="header">I'm in
 * the second header</template> <template>I'm in the second body cell</template>
 * <template class="footer">I'm in the second footer</template>
 * </vaadin-grid-column> </vaadin-grid-column-group> </vaadin-grid>
 */
@Generated({
		"Generator: com.vaadin.generator.ComponentGenerator#0.1.17-SNAPSHOT",
		"WebComponent: vaadin-grid-column-group#null", "Flow#0.1.17-SNAPSHOT"})
@Tag("vaadin-grid-column-group")
@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-column-group.html")
public class GeneratedVaadinGridColumnGroup<R extends GeneratedVaadinGridColumnGroup<R>>
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
	 * Flex grow ratio for the column group as the sum of the ratios of its
	 * child columns.
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
	 * Width of the column group as the sum of the widths of its child columns.
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
	 * Represents the number of child columns of this group.
	 * <p>
	 * This property is not synchronized automatically from the client side, so
	 * the returned value may not be the same as in client side.
	 */
	public double getColSpan() {
		return getElement().getProperty("colSpan", 0.0);
	}

	@DomEvent("frozen-changed")
	public static class FrozenChangeEvent<R extends GeneratedVaadinGridColumnGroup<R>>
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
	public static class HiddenChangeEvent<R extends GeneratedVaadinGridColumnGroup<R>>
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

	@DomEvent("col-span-changed")
	public static class ColSpanChangeEvent<R extends GeneratedVaadinGridColumnGroup<R>>
			extends
				ComponentEvent<R> {
		public ColSpanChangeEvent(R source, boolean fromClient) {
			super(source, fromClient);
		}
	}

	public Registration addColSpanChangeListener(
			ComponentEventListener<ColSpanChangeEvent<R>> listener) {
		return addListener(ColSpanChangeEvent.class,
				(ComponentEventListener) listener);
	}
}