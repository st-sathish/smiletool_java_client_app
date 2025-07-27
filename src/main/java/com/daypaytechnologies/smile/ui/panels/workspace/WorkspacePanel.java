package com.daypaytechnologies.smile.ui.panels.workspace;

import com.daypaytechnologies.smile.ui.panels.workspace.subpanels.URLResourceOptionPanel;
import com.daypaytechnologies.smile.ui.panels.workspace.subpanels.URLResourcePanel;
import com.daypaytechnologies.smile.ui.panels.workspace.subpanels.URLResourceResultPanel;

import javax.swing.*;
import java.awt.*;

public class WorkspacePanel extends JPanel {

    public WorkspacePanel() {
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new URLResourcePanel());
        add(new URLResourceOptionPanel());
        add(new URLResourceResultPanel());
    }
}
