package com.vaadin.ui.renderers;

import com.vaadin.flow.dom.Element;
import com.vaadin.function.SerializableBiConsumer;
import com.vaadin.function.SerializableSupplier;

public class ComponentRenderer<COMPONENT, ITEM> extends TemplateRenderer<ITEM> {

    private SerializableSupplier<COMPONENT> componentSupplier;
    private SerializableBiConsumer<COMPONENT, ITEM> itemConsumer;

    private final Element componentRendererElement = new Element(
            "flow-component-renderer", false);

    public ComponentRenderer(SerializableSupplier<COMPONENT> componentSupplier,
            SerializableBiConsumer<COMPONENT, ITEM> itemConsumer) {

        this.componentSupplier = componentSupplier;
        this.itemConsumer = itemConsumer;
    }

    public void setTemplateAttribute(String attribute, String value) {
        componentRendererElement.setAttribute(attribute, value);
    }

    @Override
    public String getTemplate() {
        return componentRendererElement.getOuterHTML();
    }

    public COMPONENT createComponent(ITEM item) {
        COMPONENT component = componentSupplier.get();
        itemConsumer.accept(component, item);
        return component;
    }

}
