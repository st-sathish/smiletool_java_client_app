package com.daypaytechnologies.smiletool.ui.components;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class LineNumberView extends JComponent {

    private final JsonTextPane textPane;
    private final Font font = new Font("Monospaced", Font.PLAIN, 12);
    private final int padding = 8;

    public LineNumberView(JsonTextPane textPane) {
        this.textPane = textPane;
        setFont(font);
        // Listen for changes to refresh line numbers
        textPane.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { repaint(); }
            public void removeUpdate(DocumentEvent e) { repaint(); }
            public void changedUpdate(DocumentEvent e) { repaint(); }
        });

        // Also repaint on scroll
        textPane.addPropertyChangeListener("document", evt -> repaint());
        textPane.addCaretListener(e -> repaint());

        setPreferredWidth();
    }

    private void setPreferredWidth() {
        int lines = textPane.getDocument().getDefaultRootElement().getElementCount();
        int digits = Math.max(3, String.valueOf(lines).length());
        int width = getFontMetrics(font).charWidth('0') * digits + padding;
        setPreferredSize(new Dimension(width, Integer.MAX_VALUE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Rectangle clip = g.getClipBounds();
        Element root = textPane.getDocument().getDefaultRootElement();

        g.setColor(new Color(245, 245, 245));
        g.fillRect(clip.x, clip.y, clip.width, clip.height);

        g.setFont(font);
        g.setColor(Color.GRAY);

        int startOffset = textPane.viewToModel2D(new Point(0, clip.y));
        int endOffset = textPane.viewToModel2D(new Point(0, clip.y + clip.height));

        int startLine = root.getElementIndex(startOffset);
        int endLine = root.getElementIndex(endOffset);

        for (int line = startLine; line <= endLine; line++) {
            Element lineElem = root.getElement(line);
            try {
                Rectangle2D r = textPane.modelToView2D(lineElem.getStartOffset());
                if (r != null) {
                    int y = ((int) r.getY()) + ((int) r.getHeight()) - 4;
                    String lineNumber = String.valueOf(line + 1);
                    g.drawString(lineNumber, padding / 2, y);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
