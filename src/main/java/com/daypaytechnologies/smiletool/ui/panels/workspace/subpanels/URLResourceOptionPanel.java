package com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels;

import com.daypaytechnologies.smiletool.ui.components.UnderlineTabUI;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options.URLResourceOptionAuthorizationPanel;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options.URLResourceOptionBodyPanel;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options.URLResourceOptionHeaderPanel;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.options.URLResourceOptionParamsPanel;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
public class URLResourceOptionPanel extends JPanel {

    private static final String HEADER_TAB_NAME = "Headers";

    private static final String PARAMS_TAB_NAME = "Params";

    private static final String AUTHORIZATION_TAB_NAME = "Authorization";

    private static final String BODY_TAB_NAME = "Body";

    private final URLResourceOptionBodyPanel urlResourceOptionBodyPanel;

    public URLResourceOptionPanel(URLResourceOptionBodyPanel urlResourceOptionBodyPanel) {
        this.urlResourceOptionBodyPanel = urlResourceOptionBodyPanel;
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
        tabbedPane.addTab(BODY_TAB_NAME, urlResourceOptionBodyPanel);
        add(tabbedPane, BorderLayout.CENTER);
    }
}
