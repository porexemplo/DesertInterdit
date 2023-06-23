package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerIcon {
    private static ImageIcon[] icons = new ImageIcon[6];

    public PlayerIcon(int width, int height) {
        icons[0] = new ImageIcon(getScaledImage(new ImageIcon("assets/p_explorateur.png").getImage(), width, height));
        icons[1] = new ImageIcon(getScaledImage(new ImageIcon("assets/p_archeologue.png").getImage(), width, height));
        icons[2] = new ImageIcon(getScaledImage(new ImageIcon("assets/p_alpiniste.png").getImage(), width, height));
        icons[3] = new ImageIcon(getScaledImage(new ImageIcon("assets/p_porteuse_eau.png").getImage(), width, height));
        icons[4] = new ImageIcon(getScaledImage(new ImageIcon("assets/p_navigatrice.png").getImage(), width, height));
        icons[5] = new ImageIcon(getScaledImage(new ImageIcon("assets/p_meteorologue.png").getImage(), width, height));
    }

    public static ImageIcon getIcon(String s) {
        return switch (s) {
            case "Explorateur" -> icons[0];
            case "Archéologue" -> icons[1];
            case "Alpiniste" -> icons[2];
            case "Porteuse d'eau" -> icons[3];
            case "Navigatrice" -> icons[4];
            case "Météorologue" -> icons[5];
            default -> null;
        };
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
