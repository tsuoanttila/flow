package com.vaadin.flow.demo.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.flow.demo.ComponentDemo;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.grid.Grid.Column;
import com.vaadin.ui.grid.TreeGrid;

@ComponentDemo(name = "TreeGrid", href = "vaadin-treegrid")
@HtmlImport("bower_components/vaadin-valo-theme/vaadin-grid.html")
@HtmlImport("bower_components/vaadin-valo-theme/vaadin-button.html")
@HtmlImport("bower_components/vaadin-valo-theme/vaadin-text-field.html")
public class TreeGridView extends DemoView {

    public static class File {
        private String name;
        private boolean directory;
        private long size;
        private List<File> children;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isDirectory() {
            return directory;
        }

        public void setDirectory(boolean directory) {
            this.directory = directory;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public List<File> getChildren() {
            return children;
        }

        public void setChildren(List<File> children) {
            this.children = children;
        }
    }

    @Override
    void initView() {
        createBasicTreeGrid();
    }

    private void createBasicTreeGrid() {
        TreeGrid<File> treeGrid = new TreeGrid<>();

        List<File> data = generateData(50, 4, 20);
        TreeData<File> tree = getTreeData(data);

        TreeDataProvider<File> dataProvider = new TreeDataProvider<>(tree);
        treeGrid.setDataProvider(dataProvider);
        Column<File> hierarchyColumn = treeGrid.addColumn("Name",
                File::getName);
        treeGrid.setHierarchyColumn(hierarchyColumn);

        treeGrid.addColumn("Size", File::getSize);

        addCard("Basic usage", treeGrid);
    }

    private TreeData<File> getTreeData(List<File> listData) {
        TreeData<File> tree = new TreeData<>();
        tree.addRootItems(listData);

        listData.forEach(file -> populateTree(tree, file, file.getChildren()));
        return tree;
    }

    private void populateTree(TreeData<File> tree, File parent,
            List<File> children) {
        if (!parent.isDirectory()) {
            return;
        }
        tree.addItems(parent, children);
        children.stream().filter(File::isDirectory)
                .forEach(directory -> populateTree(tree, directory,
                        directory.getChildren()));
    }

    private List<File> generateData(int rootAmmount, int levels,
            int maxChildren) {
        List<File> list = new ArrayList<>(rootAmmount);
        Random random = new Random(42);

        for (int i = 0; i < rootAmmount; i++) {
            File file = new File();
            file.setDirectory(levels > 0);
            if (file.isDirectory()) {
                file.setName("Directory " + (i + 1));
                file.setChildren(generateData(random.nextInt(maxChildren),
                        levels - 1, maxChildren));
            } else {
                file.setName("file" + (i + 1) + ".txt");
                file.setSize(Math.abs(random.nextLong()));
            }
            list.add(file);
        }

        return list;
    }

}
