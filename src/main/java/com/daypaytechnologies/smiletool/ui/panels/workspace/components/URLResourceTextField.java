package com.daypaytechnologies.smiletool.ui.panels.workspace.components;

import com.daypaytechnologies.smiletool.ui.components.DefaultExtendedCaret;

import javax.swing.*;
import java.awt.*;

public class URLResourceTextField extends JTextField {

    public URLResourceTextField() {
        setCaret(new DefaultExtendedCaret());
        setMargin(new Insets(5, 5, 5, 5));
    }
}
