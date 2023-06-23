package utils;

import Model.Equipement;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CarteEquipement {
    private static ImageIcon[] icons = new ImageIcon[8];

    public CarteEquipement(int width, int height) {
        icons[0] = new ImageIcon(getScaledImage(new ImageIcon("assets/blaster.png").getImage(), width, height));
        icons[1] = new ImageIcon(getScaledImage(new ImageIcon("assets/bouclier.png").getImage(), width, height));
        icons[2] = new ImageIcon(getScaledImage(new ImageIcon("assets/jetpack.png").getImage(), width, height));
        icons[3] = new ImageIcon(getScaledImage(new ImageIcon("assets/eau.png").getImage(), width, height));
        icons[4] = new ImageIcon(getScaledImage(new ImageIcon("assets/time.png").getImage(), width, height));
        icons[5] = new ImageIcon(getScaledImage(new ImageIcon("assets/vue.png").getImage(), width, height));
        icons[6] = new ImageIcon(getScaledImage(new ImageIcon("assets/equipement.png").getImage(), width, height));
        icons[7] = new ImageIcon(getScaledImage(new ImageIcon("assets/empty_equipement.png").getImage(), width, height));
    }

    public static ImageIcon getIcon(String equipement) {
        return switch (equipement) {
            case "BLASTER" -> icons[0];
            case "BOUCLIER" -> icons[1];
            case "JETPACK" -> icons[2];
            case "RESERVE_EAU" -> icons[3];
            case "ACCELERATEURTEMPS" -> icons[4];
            case "APPAREILVUE" -> icons[5];
            default -> icons[7];
        };
    }
    public static ImageIcon getUnflippedIcon() {  return icons[6]; }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
