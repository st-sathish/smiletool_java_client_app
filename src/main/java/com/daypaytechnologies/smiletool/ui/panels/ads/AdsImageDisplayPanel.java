package com.daypaytechnologies.smiletool.ui.panels.ads;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AdsImageDisplayPanel extends JPanel {

    private BufferedImage image;

    public AdsImageDisplayPanel(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath)); // Use getResource() for JAR
        } catch (IOException e) {
            e.printStackTrace();
        }
        //setBorder(BorderFactory.createLineBorder(Color.BLUE)); // Debug border
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            int imgWidth = image.getWidth();
            int imgHeight = image.getHeight();

            // Compute the scaling factor to fit image within panel, keeping aspect ratio
            double scale = Math.min((double) panelWidth / imgWidth, (double) panelHeight / imgHeight);

            int drawWidth = (int) (imgWidth * scale);
            int drawHeight = (int) (imgHeight * scale);

            // Center the image
            int x = (panelWidth - drawWidth) / 2;
            int y = (panelHeight - drawHeight) / 2;

            //g.drawImage(image, x, y, drawWidth, drawHeight, this);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
