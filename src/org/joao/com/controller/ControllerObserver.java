package org.joao.com.controller;

import javax.swing.AbstractButton;
import java.awt.event.ActionListener;

public abstract class ControllerObserver implements Subscriber<AbstractButton, ActionListener> {
    public ControllerObserver() {
        init();
        startSubscription();
    }

    protected abstract void init();

    @Override
    public void handleEvent(AbstractButton component, ActionListener event) {
        component.addActionListener(event);
    }
}
