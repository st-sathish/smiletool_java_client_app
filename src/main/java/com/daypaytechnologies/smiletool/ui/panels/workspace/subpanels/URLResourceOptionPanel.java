package com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels;

import com.daypaytechnologies.smiletool.ui.components.UnderlineTabUI;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options.authorization.URLResourceOptionAuthorizationPanel;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options.body.ResourceBodyPanel;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options.header.URLResourceOptionHeaderPanel;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options.params.URLResourceOptionParamsPanel;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
public class URLResourceOptionPanel extends JPanel {

    private static final String HEADER_TAB_NAME = "Headers";

    private static final String PARAMS_TAB_NAME = "Params";

    private static final String AUTHORIZATION_TAB_NAME = "Authorization";

    private static final String BODY_TAB_NAME = "Body";

    private final ResourceBodyPanel resourceBodyPanel;

    public URLResourceOptionPanel(ResourceBodyPanel resourceBodyPanel) {
        this.resourceBodyPanel = resourceBodyPanel;
        setBorder(BorderFactory.createLineBorder(Color.BLUE)); // Debug border
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 300));
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
        tabbedPane.addTab(PARAMS_TAB_NAME, new URLResourceOptionParamsPanel());
        tabbedPane.addTab(AUTHORIZATION_TAB_NAME, new URLResourceOptionAuthorizationPanel());
        tabbedPane.addTab(HEADER_TAB_NAME, new URLResourceOptionHeaderPanel());
        tabbedPane.addTab(BODY_TAB_NAME, resourceBodyPanel);
        add(tabbedPane, BorderLayout.CENTER);
    }
}
