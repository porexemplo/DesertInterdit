package View;

import Model.Direction;
import Model.cModel;
import utils.CarteTempete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class QueueTempeteView extends JPanel implements Observer {

    private JLabel flippedCard = new JLabel();
    private JLabel unflippedCard = new JLabel();

    public QueueTempeteView() {
        new CarteTempete(110, 150); // Loading images for CarteTempete
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(102*2+10, 132));

        unflippedCard.setIcon(CarteTempete.getUnflippedIcon());
        flippedCard.setIcon(CarteTempete.getIcon(Direction.NORD, 2));
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
        if (((cModel) o).getCurrCard() == null) return;
        flippedCard.setVisible(true);
        switch (((cModel) o).getCurrCard().getType()) {
            case VAGUE_CHALEUR -> flippedCard.setIcon(CarteTempete.getVagueChaleurIcon());
            case TEMPETE -> flippedCard.setIcon(
                    CarteTempete.getIcon(
                            ((cModel) o).getCurrCard().getDir(),
                            ((cModel) o).getCurrCard().getForce()
                    )
            );
            case DECHENEMENT -> flippedCard.setIcon(CarteTempete.getUnleashIcon());
        }
        repaint(); revalidate();
    }
}
