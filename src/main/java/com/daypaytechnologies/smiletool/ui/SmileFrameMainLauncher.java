package com.daypaytechnologies.smiletool.ui;

import com.daypaytechnologies.smiletool.ui.panels.menu.SideMenuPanel;
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

    private final SideMenuPanel sideMenuPanel;

    public void run() {
        setTitle("SmileTool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        showLogo();
        addAllPanels();

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        // Create menu items
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add menu items to the File menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();  // adds a line separator
        fileMenu.add(exitItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Set the menu bar to the frame
        setJMenuBar(menuBar);

        setVisible(true);
        setBackground(Color.WHITE);
    }

    public void addAllPanels() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sideMenuPanel, workspacePanel);
        splitPane.setDividerLocation(200); // initial location (won't work until frame is shown)
        splitPane.setResizeWeight(0.5);// keeps them equal during resizing
        splitPane.setOpaque(false);
        splitPane.setBackground(Color.WHITE);
        add(splitPane);
    }

    private void showLogo() {
        Image icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/smile_logo.png"))).getImage();
        setIconImage(icon);
    }
}
