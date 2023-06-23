package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class WaterIcon {
    private static ImageIcon icon[] = new ImageIcon[2];

    public WaterIcon(int width, int height) {
        icon[0] = new ImageIcon(getScaledImage(new ImageIcon("assets/water.png").getImage(), width, height));
        icon[1] = new ImageIcon(getScaledImage(new ImageIcon("assets/nowater.png").getImage(), width, height));
    }

    public static ImageIcon getIcon() {
        return icon[0];
    }

    public static ImageIcon getEmpty() {
        return icon[1];
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
