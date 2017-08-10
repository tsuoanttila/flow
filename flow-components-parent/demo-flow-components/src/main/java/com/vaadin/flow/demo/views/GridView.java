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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.vaadin.annotations.ClientDelegate;
import com.vaadin.annotations.HtmlImport;
import com.vaadin.flow.demo.ComponentDemo;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.html.Div;
import com.vaadin.generated.vaadin.grid.GeneratedVaadinGrid;
import com.vaadin.generated.vaadin.grid.GeneratedVaadinGridColumn;
import com.vaadin.generated.vaadin.grid.GeneratedVaadinGridColumnGroup;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.util.JsonSerializer;

import elemental.json.JsonObject;

@HtmlImport("frontend://bower_components/iron-image/iron-image.html")
@ComponentDemo(name = "Vaadin Grid", href = "vaadin-grid")
public class GridView extends DemoView {

    private static final ExecutorService executor = Executors
            .newSingleThreadExecutor();

    private Div message;

    public static class Person {
        private Name name;
        private Picture picture;

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Picture getPicture() {
            return picture;
        }

        public void setPicture(Picture picture) {
            this.picture = picture;
        }
    }

    public static class Name {
        private String first;
        private String last;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }
    }

    public static class Picture {
        private String thumbnail;

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }

    @Override
    void initView() {
        message = new Div();
        GeneratedVaadinGrid grid = new GeneratedVaadinGrid();

        GeneratedVaadinGridColumn col = new GeneratedVaadinGridColumn();
        col.setFlexGrow(0);

        createTemplate(col, "#").getClassList().add("header");
        createClickableTemplate(col, "[[index]]");
        grid.add(col);

        col = new GeneratedVaadinGridColumn();
        col.setFlexGrow(0);

        createTemplate(col, "Picture").getClassList().add("header");
        createClickableTemplate(col,
                "<iron-image style=\"height: 48px; width: 48px; border-radius: 50%;\" src=\"[[item.picture.thumbnail]]\">");
        grid.add(col);

        GeneratedVaadinGridColumnGroup group = new GeneratedVaadinGridColumnGroup();
        createTemplate(group, "Person").getClassList().add("header");

        col = new GeneratedVaadinGridColumn();
        col.setWidth("calc(50% - 100px)");

        createTemplate(col, "First name").getClassList().add("header");
        createClickableTemplate(col, "[[item.name.first]]");
        group.getElement().appendChild(col.getElement());

        col = new GeneratedVaadinGridColumn();
        col.setWidth("calc(50% - 100px)");

        createTemplate(col, "Last name").getClassList().add("header");
        createClickableTemplate(col, "[[item.name.last]]");
        group.getElement().appendChild(col.getElement());

        grid.add(group);

        int numberOfUsers = 50;
        UI ui = UI.getCurrent();

        executor.execute(() -> {

            List<Person> people = new ArrayList<>(numberOfUsers);
            for (int i = 0; i < numberOfUsers; i++) {
                people.add(createPerson(i + 1));
            }

            ui.access(() -> {
                grid.getElement().setPropertyJson("items",
                        JsonSerializer.toJson(people));

            });
        });

        grid.setId("users-grid");
        grid.getStyle().set("width", "600px");
        add(grid, message);
        grid.getElement().getParent().getStyle().set("maxWidth", "600px")
                .set("textAlign", "left");
    }

    private Element createTemplate(Component column, String content) {
        Element templateElement = new Element("template");
        templateElement.setProperty("innerHTML", content);
        column.getElement().appendChild(templateElement);
        return templateElement;
    }

    private Element createClickableTemplate(Component column, String content) {
        String clickableContent = "<span onclick=\"var mappedToServer = this; while(!mappedToServer.$server) {mappedToServer = mappedToServer.parentElement;} mappedToServer.$server.handleClick(this.item);\" item=\"[[item]]\">"
                + content + "</span>";
        return createTemplate(column, clickableContent);
    }

    private Person createPerson(int index) {
        Person person = new Person();

        Name name = new Name();
        name.setFirst("Some" + String.valueOf(index));
        name.setLast("Some" + String.valueOf(index - 1) + "son");
        person.setName(name);

        Picture picture = new Picture();
        picture.setThumbnail("https://randomuser.me/api/portraits/thumb/men/"
                + String.valueOf(index % 100) + ".jpg");
        person.setPicture(picture);

        return person;
    }

    @ClientDelegate
    private void handleClick(JsonObject object) {
        Person person = JsonSerializer.toObject(Person.class, object);
        message.setText("Item clicked: " + person.getName().getFirst() + " "
                + person.getName().getLast());
    }

}
