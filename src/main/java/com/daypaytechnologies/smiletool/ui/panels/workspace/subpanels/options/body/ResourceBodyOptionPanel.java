package com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options.body;

import com.daypaytechnologies.smiletool.ui.AbstractJPanel;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Service
public class ResourceBodyOptionPanel extends AbstractJPanel {

    public ResourceBodyOptionPanel() {
        setBackground(Color.WHITE);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        //setLayout(new BorderLayout());
        //setBorder(BorderFactory.createLineBorder(Color.GREEN));
        add(getLeftSideOptionPanel());
        add(getRightSideOptionPanel());
    }

    public JPanel getLeftSideOptionPanel() {
        JPanel editoOptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //editoOptionPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        //editoOptionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        editoOptionPanel.setOpaque(false);
        editoOptionPanel.setBackground(Color.WHITE);

        JRadioButton none = new JRadioButton("none");
        /*JRadioButton none = new JRadioButton("none") {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(Color.CYAN);
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };*/
        none.setName("noneBtn");
        none.setOpaque(false);
        none.setContentAreaFilled(false);
        none.setBorderPainted(false);
        none.setBackground(editoOptionPanel.getBackground());

        JRadioButton formData = new JRadioButton("form-data");
        formData.setName("form_data");
        formData.setOpaque(false);
        formData.setContentAreaFilled(false);

        JRadioButton urlEncoded = new JRadioButton("x-www-form-urlencoded");
        urlEncoded.setName("form_url_encoded");
        urlEncoded.setOpaque(false);
        urlEncoded.setContentAreaFilled(false);

        JRadioButton raw = new JRadioButton("raw");
        raw.setName("raw");
        raw.setOpaque(false);
        raw.setContentAreaFilled(false);

        // Group the radio buttons to allow only one selection
        ButtonGroup group = new ButtonGroup();
        group.add(none);
        group.add(formData);
        group.add(urlEncoded);
        group.add(raw);

        editoOptionPanel.add(none);
        editoOptionPanel.add(formData);
        editoOptionPanel.add(urlEncoded);
        editoOptionPanel.add(raw);
        editoOptionPanel.add(getRawOptions());

        // Add action listeners (optional)
        ActionListener listener = e -> {
            JRadioButton selected = (JRadioButton) e.getSource();
            JComboBox rawOptionBox = (JComboBox) getComponent(editoOptionPanel, "rawOptionBox");
            if("raw".equals(selected.getName())) {
                rawOptionBox.setVisible(true);
            } else {
                rawOptionBox.setVisible(false);
            }
            System.out.println("Selected: " + selected.getText());
        };

        none.addActionListener(listener);
        formData.addActionListener(listener);
        urlEncoded.addActionListener(listener);
        raw.addActionListener(listener);

        return editoOptionPanel;
    }

    private JComboBox<String> getRawOptions() {
        String[] rawOptions = {"Text", "JSON", "HTML", "XML"};
        JComboBox<String> httpMethodBox = new JComboBox<>(rawOptions);
        //httpMethodBox.setPreferredSize(new Dimension(100, 40));
        httpMethodBox.setName("rawOptionBox");
        httpMethodBox.setVisible(false);
        return httpMethodBox;
    }

    private JPanel getRightSideOptionPanel() {
        JPanel editoOptionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        editoOptionPanel.setOpaque(false);
        editoOptionPanel.setBackground(Color.WHITE);
        //editoOptionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //editoOptionPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        editoOptionPanel.setName("editorOptionPanel");
        JLabel beautyBtn = prepareBeautyBtn();
        editoOptionPanel.add(beautyBtn);
        editoOptionPanel.add(preparePreviewBtn());
        return editoOptionPanel;
    }

    private JLabel prepareBeautyBtn() {
        JLabel sndButton = new JLabel("Beauty");
        //sndButton.setPreferredSize(new Dimension(30, 20));
        sndButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        sndButton.setForeground(new Color(239, 91, 37));
        //sndButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
        sndButton.setName("ExecuteBeautyBtn");
        sndButton.setOpaque(false);
        sndButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //formatTextBeauty();
            }
        });

        // Optional: cursor on hover
        sndButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return sndButton;
    }

    private JLabel preparePreviewBtn() {
        JLabel sndButton = new JLabel("FullScreen");
        //sndButton.setPreferredSize(new Dimension(100, 20));
        sndButton.setForeground(new Color(239, 91, 37));
        //sndButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        sndButton.setName("ExecutePreviewBtn");
        sndButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return sndButton;
    }

    @Override
    protected JPanel getPanel() {
        return this;
    }
}
