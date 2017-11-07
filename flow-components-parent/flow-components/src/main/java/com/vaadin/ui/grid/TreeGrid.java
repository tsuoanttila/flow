package com.vaadin.ui.grid;

import java.util.Objects;

import com.vaadin.data.HasHierarchicalDataProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.HierarchicalDataCommunicator;
import com.vaadin.data.provider.HierarchicalDataProvider;
import com.vaadin.data.provider.HierarchyMapper;
import com.vaadin.flow.dom.Element;
import com.vaadin.ui.common.ClientDelegate;
import com.vaadin.ui.common.HtmlImport;

@HtmlImport("frontend://bower_components/vaadin-grid/vaadin-grid-hierarchy-toggle.html")
public class TreeGrid<T> extends Grid<T>
        implements HasHierarchicalDataProvider<T> {

    private Column<T> hierarchyColumn;

    /**
     * Creates a new {@code TreeGrid} without support for creating columns based
     * on property names. Use an alternative constructor, such as
     * {@link TreeGrid#TreeGrid(Class)}, to create a {@code TreeGrid} that
     * automatically sets up columns based on the type of presented data.
     */
    public TreeGrid() {
        super(null);
        HierarchicalDataCommunicator<T> hierarchicalDataCommunicator = new HierarchicalDataCommunicator<T>(
                new GridDataGenerator<>(), UpdateQueue::new,
                data -> getElement().callFunction("$connector.updateData",
                        data),
                getElement().getNode());

        dataCommunicator = hierarchicalDataCommunicator;

        HierarchyMapper<T, Object> mapper = new HierarchyMapper<>();
        hierarchicalDataCommunicator.setHierarchyMapper(mapper);
        getDataGenerator().addDataGenerator(mapper);

        initialSetup(50);
    }

    /**
     * Creates a new {@code TreeGrid} using the given
     * {@code HierarchicalDataProvider}, without support for creating columns
     * based on property names. Use an alternative constructor, such as
     * {@link TreeGrid#TreeGrid(Class)}, to create a {@code TreeGrid} that
     * automatically sets up columns based on the type of presented data.
     *
     * @param dataProvider
     *            the data provider, not {@code null}
     */
    public TreeGrid(HierarchicalDataProvider<T, ?> dataProvider) {
        this();
        setDataProvider(dataProvider);
    }

    @Override
    public void setDataProvider(DataProvider<T, ?> dataProvider) {
        if (!(dataProvider instanceof HierarchicalDataProvider)) {
            throw new IllegalArgumentException(
                    "TreeGrid only accepts hierarchical data providers");
        }
        // getRpcProxy(TreeGridClientRpc.class).clearPendingExpands();
        super.setDataProvider(dataProvider);
    }

    /**
     * Get the currently set hierarchy column.
     *
     * @return the currently set hierarchy column, or {@code null} if no column
     *         has been explicitly set
     */
    public Column<T> getHierarchyColumn() {
        return hierarchyColumn;
    }

    /**
     * Set the column that displays the hierarchy of this grid's data. By
     * default the hierarchy will be displayed in the first column.
     * <p>
     * Setting a hierarchy column by calling this method also sets the column to
     * be visible and not hidable.
     * <p>
     * <strong>Note:</strong> Changing the Renderer of the hierarchy column is
     * not supported.
     *
     * @param column
     *            the column to use for displaying hierarchy
     */
    public void setHierarchyColumn(Column<T> column) {
        Objects.requireNonNull(column, "column may not be null");
        if (!getColumns().contains(column)) {
            throw new IllegalArgumentException(
                    "Given column is not a column of this TreeGrid");
        }
        column.setHidden(false);
        Element template = column.getElement().getChildren()
                .filter(element -> "template".equals(element.getTag())
                        && element.getClassList().isEmpty())
                .findFirst().orElseThrow(() -> new IllegalStateException(
                        "Given column doesn't have a <template> without class"));

        template.setProperty("innerHTML",
                "<vaadin-grid-hierarchy-toggle icon-hidden=\"[[!item.hasChildren]]\" expanded=\"{{expanded}}\" level=\"[[level]]\">"
                        + template.getProperty("innerHTML")
                        + "</vaadin-grid-hierarchy-toggle>");

        hierarchyColumn = column;
    }

    /**
     * Returns whether a given item is expanded or collapsed.
     *
     * @param item
     *            the item to check
     * @return true if the item is expanded, false if collapsed
     */
    public boolean isExpanded(T item) {
        return getDataCommunicator().isExpanded(item);
    }

    @Override
    public HierarchicalDataCommunicator<T> getDataCommunicator() {
        return (HierarchicalDataCommunicator<T>) super.getDataCommunicator();
    }

    @Override
    public HierarchicalDataProvider<T, ?> getDataProvider() {
        if (!(super.getDataProvider() instanceof HierarchicalDataProvider)) {
            return null;
        }
        return (HierarchicalDataProvider<T, ?>) super.getDataProvider();
    }

    @ClientDelegate
    private void setRequestedRangeAndParentKey(int start, int length,
            String parentKey) {
        HierarchicalDataCommunicator<T> communicator = getDataCommunicator();
        communicator
                .setRequestedParent(communicator.getKeyMapper().get(parentKey));
        communicator.setRequestedRange(start, length);
    }
}
