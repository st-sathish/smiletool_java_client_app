package com.daypaytechnologies.smiletool.ui.panels.workspace;

import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.URLResourceOptionPanel;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.URLResourcePanel;
import com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.URLResourceResultPanel;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
public class WorkspacePanel extends JPanel {

    public WorkspacePanel(URLResourcePanel urlResourcePanel, URLResourceOptionPanel urlResourceOptionPanel,
                          URLResourceResultPanel urlResourceResultPanel) {
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(urlResourcePanel);
        add(urlResourceOptionPanel);
        add(urlResourceResultPanel);
    }
}
