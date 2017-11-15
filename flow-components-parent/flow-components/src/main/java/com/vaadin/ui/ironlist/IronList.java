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
package com.vaadin.ui.ironlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.vaadin.data.HasDataProvider;
import com.vaadin.data.provider.ArrayUpdater;
import com.vaadin.data.provider.ArrayUpdater.Update;
import com.vaadin.data.provider.DataCommunicator;
import com.vaadin.data.provider.DataGenerator;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.util.JsonUtils;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tag;
import com.vaadin.ui.common.ClientDelegate;
import com.vaadin.ui.common.HasSize;
import com.vaadin.ui.common.HasStyle;
import com.vaadin.ui.common.HtmlImport;
import com.vaadin.ui.common.JavaScript;

import elemental.json.JsonObject;
import elemental.json.JsonValue;

@Tag("iron-list")
@HtmlImport("bower_components/iron-list/iron-list.html")
@JavaScript("context://ironListConnector.js")
public class IronList<T> extends Component
        implements HasDataProvider<T>, HasStyle, HasSize {
    private final class UpdateQueue implements Update {
        private List<Runnable> queue = new ArrayList<>();

        private UpdateQueue(int size) {
            enqueue("$connector.updateSize", size);
        }

        @Override
        public void set(int start, List<JsonValue> items) {
            enqueue("$connector.set", start,
                    items.stream().collect(JsonUtils.asArray()));
        }

        @Override
        public void clear(int start, int length) {
            enqueue("$connector.clear", start, length);
        }

        @Override
        public void commit(int updateId) {
            enqueue("$connector.confirm", updateId);
            queue.forEach(Runnable::run);
            queue.clear();
        }

        private void enqueue(String name, Serializable... arguments) {
            queue.add(() -> getElement().callFunction(name, arguments));
        }
    }

    private final ArrayUpdater arrayUpdater = UpdateQueue::new;

    private final DataGenerator<T> gridDataGenerator = new DataGenerator<T>() {
        @Override
        public void generateData(T item, JsonObject jsonObject) {
            /// XXX Use renderers and caption providers and stuff
            jsonObject.put("caption", Objects.toString(item));
        }
    };

    private final DataCommunicator<T> dataCommunicator = new DataCommunicator<>(
            gridDataGenerator, arrayUpdater,
            data -> getElement().callFunction("$connector.updateData", data),
            getElement().getNode());

    public IronList() {
        // XXX Should also wrap in beforeClientResponse
        getElement().getNode()
                .runWhenAttached(ui -> ui.getPage().executeJavaScript(
                        "window.ironListConnector.initLazy($0)", getElement()));

        getDataCommunicator().setRequestedRange(0, 50);

        // Use renderers and stuff
        Element template = new Element("template");
        template.setProperty("innerHTML",
                "<span><template is='dom-if' if='[[item.__placeholder]]'>Placeholder for item [[index]]</template>"
                        + "<template is='dom-if' if='[[!item.__placeholder]]'>[[item.caption]]</template></span>");
        getElement().appendChild(template);
    }

    @Override
    public void setDataProvider(DataProvider<T, ?> dataProvider) {
        Objects.requireNonNull(dataProvider, "data provider cannot be null");
        getDataCommunicator().setDataProvider(dataProvider, null);
    }

    /**
     * Returns the data provider of this grid.
     *
     * @return the data provider of this grid, not {@code null}
     */
    public DataProvider<T, ?> getDataProvider() {
        return getDataCommunicator().getDataProvider();
    }

    /**
     * Returns the data communicator of this Grid.
     *
     * @return the data communicator, not {@code null}
     */
    public DataCommunicator<T> getDataCommunicator() {
        return dataCommunicator;
    }

    private T findByKey(int key) {
        T item = getDataCommunicator().getKeyMapper().get(String.valueOf(key));
        if (item == null) {
            throw new IllegalStateException("Unkonwn key: " + key);
        }
        return item;
    }

    @ClientDelegate
    private void confirmUpdate(int id) {
        getDataCommunicator().confirmUpdate(id);
    }

    @ClientDelegate
    private void setRequestedRange(int start, int length) {
        getDataCommunicator().setRequestedRange(start, length);
    }

}
