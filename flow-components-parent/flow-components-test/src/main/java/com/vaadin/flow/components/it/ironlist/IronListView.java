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
package com.vaadin.flow.components.it.ironlist;

import java.util.stream.IntStream;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.flow.components.it.TestView;
import com.vaadin.ui.button.Button;
import com.vaadin.ui.ironlist.IronList;

public class IronListView extends TestView {
    private IronList<String> list;

    private DataProvider<String, ?> dataProvider1 = DataProvider
            .fromCallbacks(
                    query -> IntStream
                            .range(query.getOffset(),
                                    query.getOffset() + query.getLimit())
                            .mapToObj(index -> "Item " + index),
                    query -> 10000);

    private DataProvider<String, ?> dataProvider2 = DataProvider.ofItems("foo",
            "foob", "fooba", "foobar");

    /**
     * Creates a view with an iron list.
     */
    public IronListView() {
        list = new IronList<>();
        list.setHeight("200px");
        list.getElement().getStyle().set("border", "1px solid black");

        list.setDataProvider(dataProvider1);

        add(list);

        Button updateProvider = new Button("Use another provider",
                event -> setProvider(list));
        updateProvider.setId("update-provider");

        add(updateProvider);
    }

    private void setProvider(IronList<String> list) {
        list.setDataProvider(list.getDataCommunicator().getDataProvider()
                .equals(dataProvider1) ? dataProvider2 : dataProvider1);
    }
}
