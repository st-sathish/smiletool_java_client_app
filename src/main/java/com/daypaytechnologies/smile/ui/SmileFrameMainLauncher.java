package com.daypaytechnologies.smile.ui;

import com.daypaytechnologies.smile.ui.components.MenuPanel;
import com.daypaytechnologies.smile.ui.panels.workspace.WorkspacePanel;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Component
public class SmileFrameMainLauncher extends JFrame {

    public void run() {
        setTitle("Smile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        showLogo();
        addAllPanels();
        setVisible(true);
    }

    public void addAllPanels() {
        MenuPanel leftPanel = new MenuPanel();
        WorkspacePanel rightPanel = new WorkspacePanel();
        JSplitPane splitPane = new JSplitPane();
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);
        add(splitPane);
    }

    private void showLogo() {
        Image icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/smile_logo.png"))).getImage();
        setIconImage(icon);
    }
}
