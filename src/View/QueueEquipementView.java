package View;

import Model.cModel;
import utils.CarteEquipement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class QueueEquipementView extends JPanel implements Observer {
    private JLabel flippedCard = new JLabel();
    private JLabel unflippedCard = new JLabel();

    public QueueEquipementView() {
        new CarteEquipement(110, 150); // Loading images for CarteEquipement

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(102*2*10, 132));

        unflippedCard.setIcon(CarteEquipement.getUnflippedIcon());
        flippedCard.setIcon(CarteEquipement.getIcon("JETPACK"));
        flippedCard.setVisible(false);

        add(unflippedCard, new GridBagConstraints(
                1, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 10, 0, 0), 0, 0));

        add(flippedCard, new GridBagConstraints(
                0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
    }

    public void addUnflippedCardListener(MouseListener listener) {
        unflippedCard.addMouseListener(listener);
    }

    @Override
    public void update(Observable o, Object arg) {
        new CarteEquipement(110, 150); // Loading images for CarteEquipement
        if (((cModel) o).getCurrEquipement() == null) return;
        flippedCard.setVisible(true);
        switch (((cModel) o).getCurrEquipement()) {
            case JETPACK -> flippedCard.setIcon(CarteEquipement.getIcon("JETPACK"));
            case BOUCLIER -> flippedCard.setIcon(CarteEquipement.getIcon("BOUCLIER"));
            case BLASTER -> flippedCard.setIcon(CarteEquipement.getIcon("BLASTER"));
            case APPAREILVUE -> flippedCard.setIcon(CarteEquipement.getIcon("APPAREILVUE"));
            case ACCELERATEURTEMPS -> flippedCard.setIcon(CarteEquipement.getIcon("ACCELERATEURTEMPS"));
            case RESERVE_EAU -> flippedCard.setIcon(CarteEquipement.getIcon("RESERVE_EAU"));
        }
        repaint(); revalidate();
    }
}
