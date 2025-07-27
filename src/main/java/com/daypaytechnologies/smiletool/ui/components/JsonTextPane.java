package com.daypaytechnologies.smiletool.ui.components;

import com.daypaytechnologies.smiletool.ui.helpers.JsonFormatHelper;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class JsonTextPane extends JTextPane {

    private final Style keyStyle;
    private final Style stringStyle;
    private final Style numberStyle;
    private final Style booleanStyle;
    private final Style defaultStyle;

    public JsonTextPane() {
        setEditable(false);
        setFont(new Font("Monospaced", Font.PLAIN, 13));

        StyledDocument doc = getStyledDocument();

        keyStyle = doc.addStyle("key", null);
        StyleConstants.setForeground(keyStyle, new Color(36, 132, 195)); // blue

        stringStyle = doc.addStyle("string", null);
        StyleConstants.setForeground(stringStyle, new Color(0, 153, 0)); // green

        numberStyle = doc.addStyle("number", null);
        StyleConstants.setForeground(numberStyle, new Color(255, 140, 0)); // orange

        booleanStyle = doc.addStyle("boolean", null);
        StyleConstants.setForeground(booleanStyle, new Color(174, 0, 255)); // purple

        defaultStyle = doc.addStyle("default", null);
        StyleConstants.setForeground(defaultStyle, Color.DARK_GRAY);
    }

    public void setJsonData(String rawJson) {
        String formattedJson = JsonFormatHelper.getPrettyJson(rawJson);
        renderJson(formattedJson);
    }

    private void renderJson(String json) {
        StyledDocument doc = getStyledDocument();
        try {
            doc.remove(0, doc.getLength());

            int i = 0;
            while (i < json.length()) {
                char c = json.charAt(i);

                if (c == '"') {
                    int start = i;
                    i++;
                    while (i < json.length() && (json.charAt(i) != '"' || json.charAt(i - 1) == '\\')) {
                        i++;
                    }
                    i++; // include end quote
                    String token = json.substring(start, i);
                    boolean isKey = false;

                    // look ahead to see if next non-whitespace character is a colon
                    int lookAhead = i;
                    while (lookAhead < json.length() && Character.isWhitespace(json.charAt(lookAhead))) {
                        lookAhead++;
                    }
                    if (lookAhead < json.length() && json.charAt(lookAhead) == ':') {
                        isKey = true;
                    }

                    doc.insertString(doc.getLength(), token, isKey ? keyStyle : stringStyle);
                } else if (Character.isDigit(c) || c == '-') {
                    int start = i;
                    while (i < json.length() && (Character.isDigit(json.charAt(i)) || json.charAt(i) == '.' || json.charAt(i) == '-')) {
                        i++;
                    }
                    doc.insertString(doc.getLength(), json.substring(start, i), numberStyle);
                } else if (json.startsWith("true", i) || json.startsWith("false", i)) {
                    boolean isTrue = json.startsWith("true", i);
                    doc.insertString(doc.getLength(), isTrue ? "true" : "false", booleanStyle);
                    i += isTrue ? 4 : 5;
                } else if (json.startsWith("null", i)) {
                    doc.insertString(doc.getLength(), "null", booleanStyle);
                    i += 4;
                } else {
                    doc.insertString(doc.getLength(), String.valueOf(c), defaultStyle);
                    i++;
                }
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
