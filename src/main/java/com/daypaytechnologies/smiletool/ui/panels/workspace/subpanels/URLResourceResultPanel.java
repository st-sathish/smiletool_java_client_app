package com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels;

import com.daypaytechnologies.smiletool.ui.components.UnderlineTabUI;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.results.URLResourceResultBodyPanel;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.results.URLResourceResultHeaderPanel;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.results.URLResourceResultTestResultPanel;

import javax.swing.*;
import java.awt.*;

public class URLResourceResultPanel extends JPanel {

    private static final String BODY_TAB_NAME = "Body";

    private static final String HEADERS_TAB_NAME = "Headers";

    private static final String TEST_RESULT_TAB_NAME = "Test Results";

    public URLResourceResultPanel(){
        setBorder(BorderFactory.createLineBorder(Color.RED)); // Debug border
        //Dimension size = getPreferredSize();
        //setPreferredSize(new Dimension(size.width, 150));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 500));
        setLayout(new BorderLayout());
        addAllComponent();
    }

    private void addAllComponent() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setUI(new UnderlineTabUI());
        tabbedPane.setOpaque(false);
        tabbedPane.setBackground(new Color(0, 0, 0, 0));
        //tabbedPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); // Debug border

        // Add tabs to the JTabbedPane
        tabbedPane.addTab(BODY_TAB_NAME, new URLResourceResultBodyPanel());
        tabbedPane.addTab(HEADERS_TAB_NAME, new URLResourceResultHeaderPanel());
        tabbedPane.addTab(TEST_RESULT_TAB_NAME, new URLResourceResultTestResultPanel());
        add(tabbedPane, BorderLayout.CENTER);
    }
}
