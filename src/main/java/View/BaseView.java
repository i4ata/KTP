package View;

import Controller.Controller;

import javax.swing.*;

/**
 * This is the superclass for all views. It defines some standard properties, and two functions that can be overridden.
 */
public abstract class BaseView {
    private final JPanel mainComponent = new JPanel();
    protected Controller controller = null;

    public JComponent getMainComponent() {
        return mainComponent;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public abstract void init();
    public abstract void update(Object object);
}
