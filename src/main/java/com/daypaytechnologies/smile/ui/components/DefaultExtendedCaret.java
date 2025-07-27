package com.daypaytechnologies.smile.ui.components;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DefaultExtendedCaret extends DefaultCaret {

    public final int aWidth = 1;

    public final int aHeight = 50;

    public DefaultExtendedCaret() {
        setBlinkRate(500);
    }

    @Override
    public void paint(Graphics g) {
        JTextComponent comp = getComponent();
        if (comp == null || !isVisible()) return;

        try {
            Rectangle2D r = comp.modelToView2D(getDot());
            if (r == null) {
                return;
            }
            int caretWidth = 2;
            int fieldHeight = comp.getHeight();
            int caretHeight = aHeight;//20; // Total height of the caret (can adjust)
            int y = (fieldHeight - caretHeight) / 2;
            g.setColor(comp.getCaretColor());
            g.fillRect((int)r.getX(), y, aWidth, caretHeight);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected synchronized void damage(Rectangle r) {
        if (r == null) return;
        // Make damage area big enough to repaint the full caret
        x = r.x;
        y = 0;
        width = 2;
        height = getComponent().getHeight();
        repaint();
    }
}
