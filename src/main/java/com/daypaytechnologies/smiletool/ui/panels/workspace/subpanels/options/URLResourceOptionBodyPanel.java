package com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
public class URLResourceOptionBodyPanel extends JPanel {

    public URLResourceOptionBodyPanel() {
        setBackground(Color.ORANGE);
        add(new JCheckBox("Enable Feature"));
    }
}
