package com.daypaytechnologies.smiletool.ui;

import com.daypaytechnologies.smiletool.ui.components.MenuPanel;
import com.daypaytechnologies.smiletool.ui.panels.workspace.WorkspacePanel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SmileFrameMainLauncher extends JFrame {

    private final WorkspacePanel workspacePanel;

    private final MenuPanel menuPanel;

    public void run() {
        setTitle("SmileTool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        showLogo();
        addAllPanels();
        setVisible(true);
    }

    public void addAllPanels() {
        JSplitPane splitPane = new JSplitPane();
        splitPane.setLeftComponent(menuPanel);
        splitPane.setRightComponent(workspacePanel);
        add(splitPane);
    }

    private void showLogo() {
        Image icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/smile_logo.png"))).getImage();
        setIconImage(icon);
    }
}
