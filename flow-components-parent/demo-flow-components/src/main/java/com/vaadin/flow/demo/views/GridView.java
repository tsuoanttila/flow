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
package com.vaadin.flow.demo.views;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vaadin.flow.demo.ComponentDemo;
import com.vaadin.flow.demo.grid.Grid;
import com.vaadin.flow.demo.grid.Grid.SimpleDataProvider;
import com.vaadin.flow.demo.views.VaadinComboBoxView.Song;
import com.vaadin.flow.html.H3;

/**
 * 
 */
@ComponentDemo(name = "Vaadin Grid", href = "vaadin-grid")
public class GridView extends DemoView {

    @Override
    void initView() {
        initDefaultView();
        initSetItemsView();
    }

    private void initDefaultView() {
        // begin-source-example
        // source-example-heading: Basic Grid
        Grid<Song> grid = new Grid<>(SimpleDataProvider.fromCallbacks(
                () -> 1000000, (page, pageSize) -> getRandomSongs(pageSize)));

        grid.addColumn(Song::getName).setHeaderTemplate("Name").setFooterTemplate("Name Footer");
        grid.addColumn(Song::getArtist).setHeaderTemplate("Artist").setFooterTemplate("Artist Footer");
        grid.addColumn(Song::getAlbum).setHeaderTemplate("Album").setFooterTemplate("Album Footer");
        // end-source-example

        add(new H3("Basic Grid"), grid);

        setStylesForGrid(grid);
    }

    private void initSetItemsView() {
        // begin-source-example
        // source-example-heading: Grid with List Data
        Grid<Song> grid = new Grid<>();
        grid.setItems(getRandomSongs(1000).collect(Collectors.toList()));

        grid.addColumn(Song::getName).setHeaderTemplate("Name");
        grid.addColumn(Song::getArtist).setHeaderTemplate("Artist");
        grid.addColumn(Song::getAlbum).setHeaderTemplate("Album");
        // end-source-example

        addCard(new H3("Grid with List Data"), grid);

        setStylesForGrid(grid);
    }

    private void setStylesForGrid(Grid<?> grid) {
        grid.getElement()
            .getParent()
            .getStyle()
            .set("minWidth", "600px")
            // Apparently vaadin-grid doesn't like text-align: center
            .set("textAlign", "left");
    }

    private Stream<Song> getRandomSongs(int number) {
        Stream.Builder<Song> sb = Stream.builder();
        for (int i = 0; i < number; ++i) {
            // TODO: actually build some random songs?
            sb.add(new Song("name", "artist", "album"));
        }
        return sb.build();
    }
}
