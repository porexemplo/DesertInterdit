package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CarteTerrain {

    private static final ImageIcon[] icons = new ImageIcon[7];

    public CarteTerrain(int width, int height) {
        icons[0] = new ImageIcon(getScaledImage(new ImageIcon("assets/carte_desert.png").getImage(), width, height));
        icons[1] = new ImageIcon(getScaledImage(new ImageIcon("assets/tuile.png").getImage(), 50, 50));
        icons[2] = new ImageIcon(getScaledImage(new ImageIcon("assets/carte_desert_2.png").getImage(), width, height));
        icons[3] = new ImageIcon(getScaledImage(new ImageIcon("assets/carte_highlighted.png").getImage(), width, height));
        icons[4] = new ImageIcon(getScaledImage(new ImageIcon("assets/carte_oasis.png").getImage(), width, height));
        icons[5] = new ImageIcon(getScaledImage(new ImageIcon("assets/carte_oasis_clicked.png").getImage(), width, height));
        icons[6] = new ImageIcon(getScaledImage(new ImageIcon("assets/carte_oasis_highlighted.png").getImage(), width, height));
    }

    public static ImageIcon getDesert() { return icons[0]; }
    public static ImageIcon getSable() { return icons[1]; }
    public static ImageIcon getClicked() { return icons[2]; }
    public static ImageIcon getOasis() { return icons[4]; }
    public static ImageIcon getOasisClicked() { return icons[5]; }
    public static ImageIcon getOasisHighlighted() { return icons[6]; }
    public static ImageIcon getHighlighted() { return icons[3]; }

    public static Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public ImageIcon getIcon(TypeCase typeCase) {
//        System.out.println("Type case: " + typeCase);
        switch (typeCase) {
            case OASIS -> {
//                System.out.println("Detected case Oasis");
                  return getOasis(); }
            default -> { return getDesert(); }
        }
    }

    public ImageIcon getIconClicked(TypeCase typeCase) {
        return switch (typeCase) {
            case OASIS -> getOasisClicked();
            default -> getClicked();
        };
    }

    public ImageIcon getIconHighlighted(TypeCase typeCase) {
        return switch (typeCase) {
            case OASIS -> getOasisHighlighted();
            default -> getHighlighted();
        };
    }
}
