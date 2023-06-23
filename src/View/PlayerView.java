package View;

import Model.Equipement;
import Model.cModel;
import utils.CarteEquipement;
import utils.ClassIcon;
import utils.PlayerIcon;
import utils.WaterIcon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class PlayerView extends JPanel implements Observer {
    private String playerName;
    private ArrayList<String> equipements;
    private int niveauEau;
    private String playerClass;
    JPanel waterPanel;
    JLabel playerLabel;
    JPanel equipmentPanel;
    JButton btnClass;
    ImageIcon waterImage = null;
    BufferedImage img0 = null;

    public PlayerView(String playerName, int niveauEau, String playerClass) {
        new ClassIcon(95, 25);
        new PlayerIcon(10, 20);
        new WaterIcon(15, 21);
        new CarteEquipement(35, 50);

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(210, 125));;
        setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, ClassIcon.getColor(playerClass)));

        this.playerName = playerName;
        this.niveauEau = niveauEau;
        this.playerClass = playerClass;
        this.equipements = new ArrayList<>();

        waterPanel = new JPanel();
        waterPanel.setLayout(new GridLayout(1, 6));

//        waterPanel.setBackground(Color.WHITE);
        waterPanel.setOpaque(true);
        waterPanel.setPreferredSize(new Dimension(50, 50));
        waterPanel.setMaximumSize(new Dimension(50, 50));
        waterPanel.setMinimumSize(new Dimension(50, 50));

        equipmentPanel = new JPanel();
        equipmentPanel.setLayout(new GridLayout(1, 4));
        equipmentPanel.setOpaque(true);
        equipmentPanel.setPreferredSize(new Dimension(50, 60));
        equipmentPanel.setMaximumSize(new Dimension(50, 60));
        equipmentPanel.setMinimumSize(new Dimension(50, 60));

        btnClass = new JButton(ClassIcon.getIcon(playerClass));
        btnClass.setPreferredSize(new Dimension(30, 30));
        btnClass.setMaximumSize(new Dimension(30, 30));
        btnClass.setMinimumSize(new Dimension(30, 30));
        btnClass.setFocusPainted(false);
        btnClass.setBorderPainted(false);
        btnClass.setContentAreaFilled(false);

        playerLabel = new JLabel();
        playerLabel.setText(playerName);
        playerLabel.setIcon(PlayerIcon.getIcon(playerClass));
        playerLabel.setPreferredSize(new Dimension(25, 20));
        playerLabel.setMaximumSize(new Dimension(25, 20));
        playerLabel.setMinimumSize(new Dimension(25, 20));
        playerLabel.setHorizontalTextPosition(JLabel.RIGHT);
        playerLabel.setVerticalTextPosition(JLabel.CENTER);
        playerLabel.setIconTextGap(10);

        add(
                playerLabel, new GridBagConstraints(
                        0, 0, 1, 1, 1, 1,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 15, 0, 0), 0, 0
                )
        );

        add(
                btnClass, new GridBagConstraints(
                        3, 0, 1, 1, 1, 1,
                        GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0
                )
        );

//        add(
//                new JLabel("Water Level: " + niveauEau), new GridBagConstraints(
//                        0, 1, 3, 1, 1, 1,
//                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
//                        new Insets(0, 15, 0, 0), 0, 0
//                )
//        );

        for (int i = 0; i < niveauEau; i++)
            waterPanel.add(new JLabel(WaterIcon.getIcon()));
        for (int i = niveauEau; i < 6; i++)
            waterPanel.add(new JLabel(WaterIcon.getEmpty()));

        add(
                waterPanel, new GridBagConstraints(
                        0, 2, 4, 1, 1, 1,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0
                )
        );

        for (int i = 0; i < equipements.size(); i++)
            equipmentPanel.add(new JLabel(equipements.get(i)));

        for (int i = equipements.size(); i < 4; i++)
            equipmentPanel.add(new JLabel(CarteEquipement.getIcon("empty")));

        add(
                equipmentPanel, new GridBagConstraints(
                        0, 3, 4, 1, 1, 1,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0
                )
        );
    }

    public void setBorder(String playerClass) {
        if (playerClass.equals(this.playerClass))
            setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, ClassIcon.getColor(playerClass)));
        else
            setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, ClassIcon.getColor(this.playerClass)));
    }

    @Override
    public void update(Observable o, Object arg) {
        new CarteEquipement(35, 50);
        // Update the water level in the JPanel
        niveauEau = (int) arg;
        waterPanel.removeAll();
        for (int i = 0; i < niveauEau; i++)
            waterPanel.add(new JLabel(WaterIcon.getIcon()));
        for (int i = niveauEau; i < 6; i++)
            waterPanel.add(new JLabel(WaterIcon.getEmpty()));
        waterPanel.revalidate();
        waterPanel.repaint();
        setBorder(((cModel) o).getCurrentPlayer().getPlayerClass().toSting());

        if (!Objects.equals(((cModel) o).getCurrentPlayer().getPlayerClass().toSting(), this.playerClass))
            return;
        ArrayList<Equipement> temp = ((cModel) o).getCurrentPlayer().getEquipements();
        equipements.clear();
        for (int i = 0; i < temp.size(); i++)
            equipements.add(temp.get(i).toString());
        equipmentPanel.removeAll();
        for (int i = 0; i < temp.size(); i++)
            equipmentPanel.add(new JLabel(CarteEquipement.getIcon(temp.get(i).toString())));
        for (int i = temp.size(); i < 4; i++)
            equipmentPanel.add(new JLabel(CarteEquipement.getIcon("empty")));
        equipmentPanel.revalidate();
        equipmentPanel.repaint();
    }
}
