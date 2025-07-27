package com.daypaytechnologies.smiletool.ui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractJPanel extends JPanel  {

    public Component getComponent(Container container, String name) {
        for (Component comp : container.getComponents()) {
            if (name.equals(comp.getName())) {
                return comp;
            }
            if (comp instanceof JScrollPane) {
                Component child = getComponent((JScrollPane) comp, name);
                if (child != null) {
                    return child;
                }
            }
        }
        return null;
    }

    public Component getComponent(String name) {
        JPanel container = getPanel();
        return getComponent(container, name);
    }

    protected abstract JPanel getPanel();
}
