package com.daypaytechnologies.smile.ui.components;

import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class UnderlineTabUI extends BasicTabbedPaneUI {

    private final Color underlineColor = new Color(30, 144, 255); // DodgerBlue
    private final int underlineHeight = 3;

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex,
                                  int x, int y, int w, int h, boolean isSelected) {
        // Don't paint default border
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        // Don't paint anything — makes the background "invisible"
        // Optional: paint only a border or underline here if needed
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement,
                                       Rectangle[] rects, int tabIndex,
                                       Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        // No focus indicator
    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement,
                                      int selectedIndex) {
        // Skip painting the content border if you want a flat style
    }

    @Override
    protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects,
                            int tabIndex, Rectangle iconRect, Rectangle textRect) {
        super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);

        if (tabIndex == tabPane.getSelectedIndex()) {
            Rectangle rect = rects[tabIndex];
            g.setColor(underlineColor);
            g.fillRect(rect.x + 10, rect.y + rect.height - underlineHeight,
                    rect.width - 20, underlineHeight);
        }
    }
}
