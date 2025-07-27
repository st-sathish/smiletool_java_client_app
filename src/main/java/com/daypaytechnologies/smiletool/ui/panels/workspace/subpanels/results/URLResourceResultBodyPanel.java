package com.daypaytechnologies.smiletool.ui.panels.workspace.subpanels.results;

import com.daypaytechnologies.smiletool.commands.dto.URLResourceResultBodyCommandDTO;
import com.daypaytechnologies.smiletool.core.OnDataTransferListener;
import com.daypaytechnologies.smiletool.core.PanelComponent;
import com.daypaytechnologies.smiletool.core.commands.dto.CommandDTO;
import com.daypaytechnologies.smiletool.ui.AbstractJPanel;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import java.awt.*;

@Service
@PanelComponent("urlResourceResultBodyPanel")
public class URLResourceResultBodyPanel extends AbstractJPanel implements OnDataTransferListener {

    public URLResourceResultBodyPanel() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        //add(new JScrollPane(textViewComponent()));
        add(textViewComponent());
    }

    private JTextPane textViewComponent() {
        //JLabel jLabel = new JLabel();
        //jLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE)); // Debug border
        //jLabel.setName("resultViewContainer");

        JTextPane textPane = new JTextPane();
        textPane.setName("resultViewContainer");
        textPane.setEditable(false);
        textPane.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        // Get the StyledDocument from JTextPane
        StyledDocument doc = textPane.getStyledDocument();
        // Define some styles
        Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        Style redStyle = doc.addStyle("Red", defaultStyle);
        StyleConstants.setForeground(redStyle, Color.RED);
        StyleConstants.setBold(redStyle, true);

        Style blueStyle = doc.addStyle("Blue", defaultStyle);
        StyleConstants.setForeground(blueStyle, Color.BLUE);
        StyleConstants.setItalic(blueStyle, true);

        return textPane;
    }

    @Override
    public void onHandleResult(CommandDTO commandDTO) {
        URLResourceResultBodyCommandDTO commandResultDTO = (URLResourceResultBodyCommandDTO) commandDTO;
        JTextPane jLabel = (JTextPane) getComponent("resultViewContainer");
        if(jLabel != null) {
            jLabel.setText(commandResultDTO.getResult());
        }
    }

    @Override
    protected JPanel getPanel() {
        return this;
    }
}
