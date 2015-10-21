package com.vaadin.hummingbird.kernel.change;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.hummingbird.kernel.StateNode;

public class ListInsertManyChange extends NodeListChange {
    public ListInsertManyChange(int index, Object key, Object... values) {
        super(index, key, new ArrayList<Object>());
        for (Object value : values) {
            getValue().add(value);
        }
    }

    @Override
    public List<Object> getValue() {
        return (List<Object>) super.getValue();
    }

    @Override
    public void accept(StateNode node, NodeChangeVisitor visitor) {
        visitor.visitListInsertManyChange(node, this);
    }

    public void addValue(Object value) {
        getValue().add(value);
    }

}