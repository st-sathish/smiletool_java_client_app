package com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options.body;

import com.daypaytechnologies.smiletool.core.PanelComponent;
import com.daypaytechnologies.smiletool.ui.AbstractJPanel;
import com.daypaytechnologies.smiletool.ui.components.JsonTextPane;
import com.daypaytechnologies.smiletool.ui.components.LineNumberView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Service
@PanelComponent("urlResourceRequestBodyPanel")
public class ResourceBodyPanel extends AbstractJPanel {

    private final ResourceBodyOptionPanel resourceBodyOptionPanel;

    public ResourceBodyPanel(ResourceBodyOptionPanel resourceBodyOptionPanel) {
        this.resourceBodyOptionPanel = resourceBodyOptionPanel;
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(this.resourceBodyOptionPanel);
        add(editorPanel());
    }

    private JPanel editorPanel() {
        JPanel editorPanel = new JPanel();
        editorPanel.setName("editorPanel");
        editorPanel.setLayout(new BorderLayout());
        JsonTextPane textPane = textViewComponent();
        LineNumberView lineNumbers = new LineNumberView(textPane);
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setName("reqBodyScrollPane");
        scrollPane.setRowHeaderView(lineNumbers);
        editorPanel.add(scrollPane);
        return editorPanel;
    }

    private JsonTextPane textViewComponent() {
        JsonTextPane textPane = new JsonTextPane();
        textPane.setName("requestBodyContainer");
        textPane.setEditable(true);
        textPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        return textPane;
    }

    private void formatTextBeauty() {
        JPanel jPanel = (JPanel) getComponent("editorPanel");
        JScrollPane scrollPane = (JScrollPane) getComponent(jPanel, "reqBodyScrollPane");
        JsonTextPane textPane = (JsonTextPane) scrollPane.getViewport().getView();
        textPane.setJsonData(textPane.getText());
    }

    @Override
    protected JPanel getPanel() {
        return this;
    }
}
