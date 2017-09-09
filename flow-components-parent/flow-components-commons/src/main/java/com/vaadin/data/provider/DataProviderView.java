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
package com.vaadin.data.provider;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.vaadin.data.ValueProvider;
import com.vaadin.data.provider.DataChangeEvent.DataRefreshEvent;
import com.vaadin.server.SerializableConsumer;
import com.vaadin.shared.Registration;

public class DataProviderView<T> {
    public interface Subscriber<T> {
        void reset();

        void refresh(T item);

        void setIdentifierGetter(ValueProvider<T, Object> identifierGetter);
    }

    private DataProvider<T, ?> dataProvider = DataProvider.ofItems();
    private Object filter;
    private Comparator<T> inMemorySorting;
    private final List<QuerySortOrder> backEndSorting = new ArrayList<>();

    private final List<Subscriber<T>> subscribers = new ArrayList<>();
    private Registration dataProviderRegistration;

    /**
     * Get the object used for filtering in this data communicator.
     *
     * @return the filter object of this data communicator
     * @since 8.0.6
     */
    protected Object getFilter() {
        return filter;
    }

    /**
     * Fetches a list of items from the DataProvider.
     *
     * @param offset
     *            the starting index of the range
     * @param limit
     *            the max number of results
     * @return the list of items in given range
     *
     * @since 8.1
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Stream<T> fetchFromProvider(int offset, int limit) {
        return getDataProvider().fetch(new Query(offset, limit, backEndSorting,
                inMemorySorting, filter));
    }

    /**
     * Gets the current data provider from this DataCommunicator.
     *
     * @return the data provider
     */
    public DataProvider<T, ?> getDataProvider() {
        return dataProvider;
    }

    /**
     * Sets the current data provider for this DataCommunicator.
     * <p>
     * The returned consumer can be used to set some other filter value that
     * should be included in queries sent to the data provider. It is only valid
     * until another data provider is set.
     *
     * @param dataProvider
     *            the data provider to set, not <code>null</code>
     * @param initialFilter
     *            the initial filter value to use, or <code>null</code> to not
     *            use any initial filter value
     *
     * @param <F>
     *            the filter type
     *
     * @return a consumer that accepts a new filter value to use
     */
    public <F> SerializableConsumer<F> setDataProvider(
            DataProvider<T, F> dataProvider, F initialFilter) {
        Objects.requireNonNull(dataProvider, "data provider cannot be null");
        filter = initialFilter;

        removeDataProviderListener();

        forEachSubscriber(Subscriber::reset);

        this.dataProvider = dataProvider;

        forEachSubscriber(subscriber -> subscriber
                .setIdentifierGetter(dataProvider::getId));

        addDataProviderListener();

        return filter -> {
            if (this.dataProvider != dataProvider) {
                throw new IllegalStateException(
                        "Filter slot is no longer valid after data provider has been changed");
            }

            if (!Objects.equals(this.filter, filter)) {
                this.filter = filter;
                forEachSubscriber(Subscriber::reset);
            }
        };
    }

    /**
     * Getter method for finding the size of DataProvider. Can be overridden by
     * a subclass that uses a specific type of DataProvider and/or query.
     *
     * @return the size of data provider with current filter
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int getDataProviderSize() {
        return getDataProvider().size(new Query(getFilter()));
    }

    public Registration addSubscriber(Subscriber<T> subscriber) {
        assert subscriber != null;

        if (subscribers.isEmpty()) {
            addDataProviderListener();
        }

        subscribers.add(subscriber);

        return () -> {
            subscribers.remove(subscriber);
            if (subscribers.isEmpty()) {
                removeDataProviderListener();
            }
        };
    }

    private void removeDataProviderListener() {
        if (dataProviderRegistration != null) {
            dataProviderRegistration.remove();
            dataProviderRegistration = null;
        }
    }

    private void forEachSubscriber(Consumer<Subscriber<T>> handler) {
        new ArrayList<>(subscribers).forEach(handler);
    }

    private void addDataProviderListener() {
        removeDataProviderListener();
        dataProviderRegistration = dataProvider
                .addDataProviderListener(event -> {
                    // XXX: FW8 wraps this in UI.access, but we don't have any
                    // easily available UI here. Maybe do in DataCoumunicator
                    // instead?
                    if (event instanceof DataRefreshEvent) {
                        T item = ((DataRefreshEvent<T>) event).getItem();

                        forEachSubscriber(handler -> handler.refresh(item));
                    } else {
                        forEachSubscriber(Subscriber::reset);
                    }
                });
    }

}
