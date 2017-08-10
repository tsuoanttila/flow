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
package com.vaadin.flow.demo.grid;

import java.io.Serializable;
import java.util.Set;

import com.vaadin.components.data.HasValue;
import com.vaadin.ui.Component;

/**
 * Models the selection logic of a {@code Listing} component. Determines how
 * items can be selected and deselected.
 *
 * @author Vaadin Ltd.
 *
 * @param <T>
 *            the type of the items to select
 */
public interface SelectionModel<T> extends Serializable {

    /**
     * A selection model in which at most one item can be selected at a time.
     * Selecting another item deselects the originally selected item.
     *
     * @param <T>
     *            the type of the items to select
     */
    public interface Single<C extends Component, T>
            extends SelectionModel<T>, HasValue<C, T> {

    }

    /**
     * A selection model in which multiple items can be selected at the same
     * time. Selecting an item adds it to the selection.
     *
     * @param <T>
     *            the type of the items to select
     */
    public interface Multi<C extends Component, T>
            extends SelectionModel<T>, HasValue<C, Set<T>> {

        /**
         * Updates the selection by adding and removing the given items from it.
         * <p>
         * If all the added items were already selected and the removed items
         * were not selected, this is a NO-OP.
         * <p>
         * Duplicate items (in both add &amp; remove sets) are ignored.
         *
         * @param addedItems
         *            the items to add, not {@code null}
         * @param removedItems
         *            the items to remove, not {@code null}
         */
        public void updateSelection(Set<T> addedItems, Set<T> removedItems);
    }

    /**
     * Returns an immutable set of the currently selected items. It is safe to
     * invoke other {@code SelectionModel} methods while iterating over the set.
     * <p>
     * <em>Implementation note:</em> the iteration order of the items in the
     * returned set should be well-defined and documented by the implementing
     * class.
     *
     * @return the items in the current selection, not null
     */
    public Set<T> getSelectedItems();

    /**
     * Selects the given item. Depending on the implementation, may cause other
     * items to be deselected. If the item is already selected, does nothing.
     *
     * @param item
     *            the item to select, not null
     */
    public void select(T item);

    /**
     * Deselects the given item. If the item is not currently selected, does
     * nothing.
     *
     * @param item
     *            the item to deselect, not null
     */
    public void deselect(T item);
}
