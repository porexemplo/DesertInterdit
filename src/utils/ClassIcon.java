package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ClassIcon {
    private static final String EXPLORATEUR = "assets/explorateur.png";
    private static final String ARCHEOLOGUE = "assets/archeologue.png";
    private static final String ALPINISTE = "assets/alpiniste.png";
    private static final String PORTEUSE_EAU = "assets/porteuse_eau.png";
    private static final String NAVIGATRICE = "assets/navigatrice.png";
    private static final String METEOROLOGUE = "assets/meterologue.png";

    private static ImageIcon[] icons = new ImageIcon[6];

    public ClassIcon(int width, int height) {
        icons[0] = new ImageIcon(getScaledImage(new ImageIcon(EXPLORATEUR).getImage(), width, height));
        icons[1] = new ImageIcon(getScaledImage(new ImageIcon(ARCHEOLOGUE).getImage(), width, height));
        icons[2] = new ImageIcon(getScaledImage(new ImageIcon(ALPINISTE).getImage(), width, height));
        icons[3] = new ImageIcon(getScaledImage(new ImageIcon(PORTEUSE_EAU).getImage(), width, height));
        icons[4] = new ImageIcon(getScaledImage(new ImageIcon(NAVIGATRICE).getImage(), width, height));
        icons[5] = new ImageIcon(getScaledImage(new ImageIcon(METEOROLOGUE).getImage(), width, height));
    }

    public static ImageIcon getIcon(int i) { return icons[i]; }

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

    public static Color getColor(String s) {
        return switch (s) {
            case "Explorateur" -> Color.decode("0x70A32F");
            case "Archéologue" -> Color.decode("0xC64B27");
            case "Alpiniste" -> Color.decode("0x322717");
            case "Porteuse d'eau" -> Color.decode("0x047395");
            case "Navigatrice" -> Color.decode("0xF0D719");
            case "Météorologue" -> Color.decode("0xE5DAC9");
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
