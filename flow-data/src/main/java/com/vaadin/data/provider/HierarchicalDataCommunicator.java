package com.vaadin.data.provider;

import java.util.stream.Stream;

import com.vaadin.flow.StateNode;
import com.vaadin.function.SerializableConsumer;
import com.vaadin.util.Range;

import elemental.json.JsonArray;

public class HierarchicalDataCommunicator<T> extends DataCommunicator<T> {

    private HierarchyMapper<T, ?> mapper;
    private T requestedParent;

    /**
     * Construct a new hierarchical data communicator backed by a
     * {@link TreeDataProvider}.
     */
    public HierarchicalDataCommunicator(DataGenerator<T> dataGenerator,
            ArrayUpdater arrayUpdater,
            SerializableConsumer<JsonArray> dataUpdater, StateNode stateNode) {
        super(dataGenerator, arrayUpdater, dataUpdater, stateNode);
        // setDataProvider(new TreeDataProvider<>(new TreeData<>()), null);
    }

    public HierarchyMapper<T, ?> getHierarchyMapper() {
        return mapper;
    }

    public void setHierarchyMapper(HierarchyMapper<T, ?> mapper) {
        this.mapper = mapper;
    }

    @Override
    public Stream<T> fetchFromProvider(int offset, int limit) {
        // Instead of adding logic to this class, delegate request to the
        // separate object handling hierarchies.
        return mapper.fetchItems(requestedParent,
                Range.withLength(offset, limit));
    }

    @Override
    public HierarchicalDataProvider<T, ?> getDataProvider() {
        return (HierarchicalDataProvider<T, ?>) super.getDataProvider();
    }

    /**
     * Set the current hierarchical data provider for this communicator.
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
            HierarchicalDataProvider<T, F> dataProvider, F initialFilter) {
        SerializableConsumer<F> consumer = super.setDataProvider(dataProvider,
                initialFilter);

        // Set up mapper for requests
        // mapper.setBackEndSorting(getBackEndSorting());
        // mapper.setInMemorySorting(getInMemorySorting());
        mapper.setFilter(getFilter());
        mapper.setDataProvider((HierarchicalDataProvider) dataProvider);

        return consumer;
    }

    /**
     * Set the current hierarchical data provider for this communicator.
     *
     * @param dataProvider
     *            the data provider to set, must extend
     *            {@link HierarchicalDataProvider}, not <code>null</code>
     * @param initialFilter
     *            the initial filter value to use, or <code>null</code> to not
     *            use any initial filter value
     *
     * @param <F>
     *            the filter type
     *
     * @return a consumer that accepts a new filter value to use
     */
    @Override
    public <F> SerializableConsumer<F> setDataProvider(
            DataProvider<T, F> dataProvider, F initialFilter) {
        if (dataProvider instanceof HierarchicalDataProvider) {
            return setDataProvider(
                    (HierarchicalDataProvider<T, F>) dataProvider,
                    initialFilter);
        }
        throw new IllegalArgumentException(
                "Only " + HierarchicalDataProvider.class.getName()
                        + " and subtypes supported.");
    }

    /**
     * Returns whether given item has children.
     *
     * @param item
     *            the item to test
     * @return {@code true} if item has children; {@code false} if not
     */
    public boolean hasChildren(T item) {
        HierarchyMapper<T, ?> mapper = getHierarchyMapper();
        return mapper.hasChildren(item);
    }

    /**
     * Returns whether given item is expanded.
     *
     * @param item
     *            the item to test
     * @return {@code true} if item is expanded; {@code false} if not
     */
    public boolean isExpanded(T item) {
        return mapper.isExpanded(item);
    }

    /**
     * Returns parent index for the row or {@code null}.
     *
     * @param item
     *            the item to find the parent of
     * @return the parent index or {@code null} for top-level items
     */
    public Integer getParentIndex(T item) {
        return mapper.getParentIndex(item);
    }

    @Override
    public int getDataProviderSize() {
        return mapper.getTreeSize();
    }

    public void setRequestedParent(T requestedParent) {
        this.requestedParent = requestedParent;
    }

}
