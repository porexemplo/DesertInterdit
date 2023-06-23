package utils;

import Model.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CarteTempete {

    private static ImageIcon[] icons = new ImageIcon[15];
    public CarteTempete(int width, int height) {
        icons[0] = new ImageIcon(getScaledImage(new ImageIcon("assets/up_1.png").getImage(), width, height));
        icons[1] = new ImageIcon(getScaledImage(new ImageIcon("assets/up_2.png").getImage(), width, height));
        icons[2] = new ImageIcon(getScaledImage(new ImageIcon("assets/up_3.png").getImage(), width, height));
        icons[3] = new ImageIcon(getScaledImage(new ImageIcon("assets/down_1.png").getImage(), width, height));
        icons[4] = new ImageIcon(getScaledImage(new ImageIcon("assets/down_2.png").getImage(), width, height));
        icons[5] = new ImageIcon(getScaledImage(new ImageIcon("assets/down_3.png").getImage(), width, height));
        icons[6] = new ImageIcon(getScaledImage(new ImageIcon("assets/left_1.png").getImage(), width, height));
        icons[7] = new ImageIcon(getScaledImage(new ImageIcon("assets/left_2.png").getImage(), width, height));
        icons[8] = new ImageIcon(getScaledImage(new ImageIcon("assets/left_3.png").getImage(), width, height));
        icons[9] = new ImageIcon(getScaledImage(new ImageIcon("assets/right_1.png").getImage(), width, height));
        icons[10] = new ImageIcon(getScaledImage(new ImageIcon("assets/right_2.png").getImage(), width, height));
        icons[11] = new ImageIcon(getScaledImage(new ImageIcon("assets/right_3.png").getImage(), width, height));
        icons[12] = new ImageIcon(getScaledImage(new ImageIcon("assets/CT_unflipped.png").getImage(), width, height));
        icons[13] = new ImageIcon(getScaledImage(new ImageIcon("assets/vague_chaleur.png").getImage(), width, height));
        icons[14] = new ImageIcon(getScaledImage(new ImageIcon("assets/unleash.png").getImage(), width, height));
    }

    public static ImageIcon getIcon(Direction dir, int f) {
        return icons[
            switch (dir) {
                case NORD -> 0; case SUD -> 3;
                case OUEST -> 6; case EST -> 9;
                default -> -1;
            } + f - 1
        ];
    }

    public static ImageIcon getUnflippedIcon() { return icons[12]; }

    public static ImageIcon getVagueChaleurIcon() { return icons[13]; }

    public static ImageIcon getUnleashIcon() { return icons[14]; }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
