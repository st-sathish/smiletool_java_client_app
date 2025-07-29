package com.daypaytechnologies.smiletool.ui.panels.ads;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
public class AdsDisplayContainerPanel extends JPanel {

    public AdsDisplayContainerPanel(AdsDisplayLeftPartPanel adsDisplayLeftPartPanel, AdsDisplayRightPartPanel adsDisplayRightPartPanel){
        //setBorder(BorderFactory.createLineBorder(Color.YELLOW)); // Debug border
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        setLayout(new BorderLayout());

        // Split them horizontally
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, adsDisplayLeftPartPanel, adsDisplayRightPartPanel);
        splitPane.setDividerLocation(0.5); // initial location (won't work until frame is shown)
        splitPane.setResizeWeight(0.5);// keeps them equal during resizing
        //splitPane.setDividerSize(1); // Makes it very thin

        add(splitPane, BorderLayout.CENTER);
    }
}
