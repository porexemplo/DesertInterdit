package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TuileMachine {
    private static final ImageIcon[] icons = new ImageIcon[5];

    public TuileMachine(int width, int height) {
        icons[0] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_1.png").getImage(), width, height));
        icons[1] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_2.png").getImage(), width, height));
        icons[2] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_3.png").getImage(), width, height));
        icons[3] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_4.png").getImage(), width, height));
        icons[4] = new ImageIcon(getScaledImage(new ImageIcon("assets/empty_part.png").getImage(), width, height));
    }

    public static ImageIcon getIcon(int part) {
        return switch (part) {
            case 1 -> icons[0];
            case 2 -> icons[1];
            case 3 -> icons[2];
            case 4 -> icons[3];
            default -> icons[4];
        };
    }

    public static Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
