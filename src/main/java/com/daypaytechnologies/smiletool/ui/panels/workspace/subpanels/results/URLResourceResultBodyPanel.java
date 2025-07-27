package com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.results;

import com.daypaytechnologies.smiletool.commands.dto.URLResourceResultBodyCommandDTO;
import com.daypaytechnologies.smiletool.core.OnDataTransferListener;
import com.daypaytechnologies.smiletool.core.PanelComponent;
import com.daypaytechnologies.smiletool.core.commands.dto.CommandDTO;
import com.daypaytechnologies.smiletool.ui.AbstractJPanel;
import com.daypaytechnologies.smiletool.ui.components.JsonTextPane;
import com.daypaytechnologies.smiletool.ui.components.LineNumberView;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
@PanelComponent("urlResourceResultBodyPanel")
public class URLResourceResultBodyPanel extends AbstractJPanel implements OnDataTransferListener {

    public URLResourceResultBodyPanel() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        JsonTextPane textPane = textViewComponent();
        LineNumberView lineNumbers = new LineNumberView(textPane);
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setName("bodyScrollPane");
        scrollPane.setRowHeaderView(lineNumbers);
        add(scrollPane);
    }

    private JsonTextPane textViewComponent() {
        JsonTextPane textPane = new JsonTextPane();
        textPane.setName("resultViewContainer");
        textPane.setEditable(false);
        textPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        //textPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        return textPane;
    }

    @Override
    public void onHandleResult(CommandDTO commandDTO) {
        URLResourceResultBodyCommandDTO commandResultDTO = (URLResourceResultBodyCommandDTO) commandDTO;
        JScrollPane scrollPane = (JScrollPane) getComponent("bodyScrollPane");
        JsonTextPane textPane = (JsonTextPane) scrollPane.getViewport().getView();
        if(textPane != null) {
            textPane.setJsonData(commandResultDTO.getResult());
        }
    }

    @Override
    protected JPanel getPanel() {
        return this;
    }
}
