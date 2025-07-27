package com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels;

import com.daypaytechnologies.smiletool.core.rmi.RmiServiceFactory;
import com.daypaytechnologies.smiletool.executions.dto.RestRequestDTO;
import com.daypaytechnologies.smiletool.executions.rmi.RestRmiExecutorService;
import com.daypaytechnologies.smiletool.core.rmi.RmiConnection;
import com.daypaytechnologies.smiletool.ui.panels.workspace.components.URLResourceTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class URLResourcePanel extends JPanel implements ActionListener {

    String[] httpMethods = {"GET", "POST", "PUT", "DELETE"};

    public URLResourcePanel() {
        //setBorder(BorderFactory.createLineBorder(Color.RED));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        addAllComponents();
    }

    private void addAllComponents() {
        this.add(prepareHttpMethods());
        this.add(prepareURLResourceBox());
        this.add(prepareActionBtn());
    }

    private JComboBox<String> prepareHttpMethods() {
        JComboBox<String> httpMethodBox = new JComboBox<>(httpMethods);
        httpMethodBox.setPreferredSize(new Dimension(100, 40));
        return httpMethodBox;
    }

    private URLResourceTextField prepareURLResourceBox() {
        URLResourceTextField urlTextField = new URLResourceTextField();
        urlTextField.setPreferredSize(new Dimension(1000, 40));
        return urlTextField;
    }

    private JButton prepareActionBtn() {
        JButton sndButton = new JButton("Send");
        sndButton.setPreferredSize(new Dimension(100, 40));

        // Style to mimic HTML button
        sndButton.setFocusPainted(false);
        sndButton.setBorderPainted(true);
        sndButton.setBackground(new Color(239, 91, 37));
        sndButton.setForeground(Color.WHITE);
        sndButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        sndButton.setOpaque(true);
        sndButton.setName("ExecuteBtn");
        sndButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        sndButton.addActionListener(this);

        // Optional: cursor on hover
        sndButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return sndButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if("ExecuteBtn".equals(button.getName())) {
            try {
                RestRmiExecutorService restRmiExecutorService = RmiServiceFactory.getInstance().getRestRmiExecutorService();
                final RestRequestDTO restRequestDTO = new RestRequestDTO();
                restRequestDTO.setRestURL("http://localhost:9090/accounts");
                restRequestDTO.setHttpMethod("GET");
                String result = restRmiExecutorService.execute(restRequestDTO);
                System.out.println(result);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
