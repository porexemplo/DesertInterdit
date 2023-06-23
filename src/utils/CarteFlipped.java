package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CarteFlipped {
    private static ImageIcon[] icons = new ImageIcon[36];

    public CarteFlipped(int width, int height) {
        icons[0] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_1_v.png").getImage(), width, height));
        icons[1] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_2_v.png").getImage(), width, height));
        icons[2] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_3_v.png").getImage(), width, height));
        icons[3] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_4_v.png").getImage(), width, height));

        icons[4] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_1_h.png").getImage(), width, height));
        icons[5] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_2_h.png").getImage(), width, height));
        icons[6] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_3_h.png").getImage(), width, height));
        icons[7] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_4_h.png").getImage(), width, height));

        icons[8] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_1_v_clicked.png").getImage(), width, height));
        icons[9] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_2_v_clicked.png").getImage(), width, height));
        icons[10] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_3_v_clicked.png").getImage(), width, height));
        icons[11] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_4_v_clicked.png").getImage(), width, height));

        icons[12] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_1_h_clicked.png").getImage(), width, height));
        icons[13] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_2_h_clicked.png").getImage(), width, height));
        icons[14] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_3_h_clicked.png").getImage(), width, height));
        icons[15] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_4_h_clicked.png").getImage(), width, height));

        icons[16] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_1_v_highlighted.png").getImage(), width, height));
        icons[17] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_2_v_highlighted.png").getImage(), width, height));
        icons[18] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_3_v_highlighted.png").getImage(), width, height));
        icons[19] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_4_v_highlighted.png").getImage(), width, height));

        icons[20] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_1_h_highlighted.png").getImage(), width, height));
        icons[21] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_2_h_highlighted.png").getImage(), width, height));
        icons[22] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_3_h_highlighted.png").getImage(), width, height));
        icons[23] = new ImageIcon(getScaledImage(new ImageIcon("assets/part_4_h_highlighted.png").getImage(), width, height));

        icons[24] = new ImageIcon(getScaledImage(new ImageIcon("assets/engrenage.png").getImage(), width, height));
        icons[25] = new ImageIcon(getScaledImage(new ImageIcon("assets/engrenage_clicked.png").getImage(), width, height));
        icons[26] = new ImageIcon(getScaledImage(new ImageIcon("assets/engrenage_highlighted.png").getImage(), width, height));

        icons[27] = new ImageIcon(getScaledImage(new ImageIcon("assets/engrenage_tunnel.png").getImage(), width, height));
        icons[28] = new ImageIcon(getScaledImage(new ImageIcon("assets/engrenage_tunnel_clicked.png").getImage(), width, height));
        icons[29] = new ImageIcon(getScaledImage(new ImageIcon("assets/engrenage_tunnel_highlighted.png").getImage(), width, height));

        icons[30] = new ImageIcon(getScaledImage(new ImageIcon("assets/oasis.png").getImage(), width, height));
        icons[31] = new ImageIcon(getScaledImage(new ImageIcon("assets/oasis_clicked.png").getImage(), width, height));
        icons[32] = new ImageIcon(getScaledImage(new ImageIcon("assets/oasis_highlighted.png").getImage(), width, height));

        icons[33] = new ImageIcon(getScaledImage(new ImageIcon("assets/piste.png").getImage(), width, height));
        icons[34] = new ImageIcon(getScaledImage(new ImageIcon("assets/piste_clicked.png").getImage(), width, height));
        icons[35] = new ImageIcon(getScaledImage(new ImageIcon("assets/piste_highlighted.png").getImage(), width, height));
    }

    public ImageIcon getIcon(TypeCase type) {
        return switch (type) {
            case TURBINE_V -> icons[0]; case TURBINE_H -> icons[4];
            case WHEEL_V -> icons[1]; case WHEEL_H -> icons[5];
            case MOTEUR_V -> icons[2]; case MOTEUR_H -> icons[6];
            case LAUNCHER_V -> icons[3]; case LAUNCHER_H -> icons[7];
            case OASIS -> icons[30]; case ENGRENNAGE -> icons[24];
            case TUNNEL -> icons[27]; case PISTE -> icons[33];
        };
    }

    public ImageIcon getIconClicked(TypeCase type) {
        return switch (type) {
            case TURBINE_V -> icons[8]; case TURBINE_H -> icons[12];
            case WHEEL_V -> icons[9]; case WHEEL_H -> icons[13];
            case MOTEUR_V -> icons[10]; case MOTEUR_H -> icons[14];
            case LAUNCHER_V -> icons[11]; case LAUNCHER_H -> icons[15];
            case OASIS -> icons[31]; case ENGRENNAGE -> icons[25];
            case TUNNEL -> icons[28]; case PISTE -> icons[34];
        };
    }

    public ImageIcon getIconHighlighted(TypeCase type) {
        return switch (type) {
            case TURBINE_V -> icons[16]; case TURBINE_H -> icons[20];
            case WHEEL_V -> icons[17]; case WHEEL_H -> icons[21];
            case MOTEUR_V -> icons[18]; case MOTEUR_H -> icons[22];
            case LAUNCHER_V -> icons[19]; case LAUNCHER_H -> icons[23];
            case OASIS -> icons[32]; case ENGRENNAGE -> icons[26];
            case TUNNEL -> icons[29]; case PISTE -> icons[35];
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
