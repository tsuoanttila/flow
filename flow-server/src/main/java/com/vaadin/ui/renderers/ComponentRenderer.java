package com.vaadin.ui.renderers;

import com.vaadin.function.SerializableBiConsumer;
import com.vaadin.function.SerializableSupplier;

public class ComponentRenderer<COMPONENT, ITEM> extends TemplateRenderer<ITEM> {

    private SerializableSupplier<COMPONENT> componentSupplier;
    private SerializableBiConsumer<COMPONENT, ITEM> itemConsumer;

    public ComponentRenderer(SerializableSupplier<COMPONENT> componentSupplier,
            SerializableBiConsumer<COMPONENT, ITEM> itemConsumer) {

        setTemplate(String.format(
                "<flow-component-renderer parentNodeId='%d' componentNodeId='%d'></flow-component-renderer>"));
    }

    public COMPONENT createComponent(ITEM item) {
        COMPONENT component = componentSupplier.get();
        itemConsumer.accept(component, item);
        return component;
    }

}
