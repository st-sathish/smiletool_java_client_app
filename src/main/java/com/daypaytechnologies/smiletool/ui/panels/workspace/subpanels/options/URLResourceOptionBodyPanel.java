package com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options;

import com.daypaytechnologies.smiletool.core.PanelComponent;
import com.daypaytechnologies.smiletool.ui.AbstractJPanel;
import com.daypaytechnologies.smiletool.ui.components.JsonTextPane;
import com.daypaytechnologies.smiletool.ui.components.LineNumberView;
import com.daypaytechnologies.smiletool.utils.ComponentUtils;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Service
@PanelComponent("urlResourceRequestBodyPanel")
public class URLResourceOptionBodyPanel extends AbstractJPanel {

    public URLResourceOptionBodyPanel() {
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(multiOptionPanel());
        add(editorPanel());
    }

    private JPanel multiOptionPanel() {
        JPanel editoOptionPanel = new JPanel();
        editoOptionPanel.setName("editorOptionPanel");
        editoOptionPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        JLabel beautyBtn = prepareBeautyBtn();
        editoOptionPanel.add(beautyBtn);
        return editoOptionPanel;
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

    private JLabel prepareBeautyBtn() {
        JLabel sndButton = new JLabel("Beauty");
        sndButton.setPreferredSize(new Dimension(100, 40));
        sndButton.setForeground(new Color(239, 91, 37));
        sndButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        sndButton.setName("ExecuteBeautyBtn");
        sndButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                formatTextBeauty();
            }
        });

        // Optional: cursor on hover
        sndButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return sndButton;
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
