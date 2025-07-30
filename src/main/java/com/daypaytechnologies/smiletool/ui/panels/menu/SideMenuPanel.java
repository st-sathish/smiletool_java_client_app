package com.daypaytechnologies.smiletool.ui.panels.menu;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
public class SideMenuPanel extends JPanel {

    public SideMenuPanel() {
        add(new JLabel("Menu Panel"));
        setOpaque(false);
        setBackground(Color.WHITE);
    }
}
