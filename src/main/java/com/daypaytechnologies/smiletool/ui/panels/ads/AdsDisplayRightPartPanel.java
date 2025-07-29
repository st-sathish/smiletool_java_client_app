package com.daypaytechnologies.smiletool.ui.panels.ads;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
public class AdsDisplayRightPartPanel extends JPanel {

    String path = "C:\\Users\\Daypay-PC\\Pictures\\Screenshots\\Screenshot 2025-05-13 213753.png";

    public AdsDisplayRightPartPanel(){
        //setBorder(BorderFactory.createLineBorder(Color.BLUE)); // Debug border
        setLayout(new BorderLayout());
        AdsImageDisplayPanel displayImagePanel = new AdsImageDisplayPanel(path);
        add(displayImagePanel, BorderLayout.CENTER);
    }
}
