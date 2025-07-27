package com.daypaytechnologies.smiletool.ui.components;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
public class MenuPanel extends JPanel {

    public MenuPanel() {
        setBackground(Color.LIGHT_GRAY);
        add(new JLabel("Left Panel"));
    }
}
