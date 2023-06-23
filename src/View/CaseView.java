package View;

import Model.cModel;
import utils.CarteTempete;
import utils.CarteTerrain;
import utils.PlayerIcon;
import utils.TypeCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class CaseView extends JPanel implements Observer {
    private int nbSables = 0;
    private int xCase, yCase;
    private boolean explored = false;
    private TypeCase typeCase;
    private boolean clicked = false, highlighted = false;
    ImageIcon tuile = new ImageIcon(CarteTerrain.getScaledImage((
            new ImageIcon("assets/tuile.png").getImage()),
            100, 100
            ));
    ImageIcon transparent = new ImageIcon(CarteTerrain.getScaledImage((
            new ImageIcon("assets/transparent.png").getImage()),
            100, 100
            ));
    JLabel sableLabel = new JLabel();
    JLabel background = new JLabel();
    private ArrayList<JLabel> playerLabels = new ArrayList<>();
    public CaseView(int x, int y) {
        new CarteTerrain(110, 150);
        new PlayerIcon(15, 30);

        xCase = x; yCase = y;

        setOpaque(true);
        setPreferredSize(new Dimension(110, 150));
        setMinimumSize(new Dimension(11*5, 15*5));
        setMaximumSize(new Dimension(110, 130));
        setLayout(new BorderLayout());

        sableLabel.setLayout(new GridBagLayout());
        sableLabel.setOpaque(false);
        addSable();
//        sableLabel.setPreferredSize(new Dimension(110, 150));

        background.setOpaque(false);
        background.setIcon(CarteTerrain.getDesert());
        background.setLayout(new GridBagLayout());
        background.add(sableLabel);
//        sableLabel.setBounds(0, 0, this.getWidth(), this.getHeight()/3);

        add(background, BorderLayout.CENTER);
//        add(sableLabel, BorderLayout.NORTH);
        setVisible(true);
    }

    public int getXCase() { return this.xCase; }
    public int getYCase() { return this.yCase; }
    public int getNbSables() { return nbSables; }
    public void setSable(int sable) { nbSables = sable; addSable(); }
    public void setImageIcon(ImageIcon icon) { background.setIcon(icon); }
    public boolean isExplored() { return explored; }

    public void setTypeCase(TypeCase typeCase) { this.typeCase = typeCase; }
    public TypeCase getTypeCase() { return typeCase; }
    public void explore() { explored = true; }

    public void addPlayer(String playerClass) {
        new PlayerIcon(15, 30);
        JLabel playerLabel = new JLabel();
        playerLabel.setIcon(PlayerIcon.getIcon(playerClass));
        playerLabels.add(playerLabel);
        addPlayers();
        repaint(); revalidate();
    }

    void addSable() {
        if (nbSables <= 0) sableLabel.setIcon(transparent);
        else sableLabel.setIcon(tuile);
        repaint(); revalidate();
    }

    public void setClicked(boolean clicked) {
//        new CarteTerrain(110, 150);
        this.clicked = clicked;
//        if (clicked) background.setIcon(CarteTerrain.getClicked());
//        else background.setIcon(CarteTerrain.getDesert());
//        repaint(); revalidate();
    }

    public void removePlayer(String playerClass) {
        for (int i = 0; i < playerLabels.size(); i++)
            if (playerLabels.get(i).getIcon().equals(PlayerIcon.getIcon(playerClass))) {
                sableLabel.remove(playerLabels.get(i));
                playerLabels.remove(i);
                break;
            }
        repaint(); revalidate();
    }

    public void removeAllPlayers() {
        for (JLabel playerLabel : playerLabels) sableLabel.remove(playerLabel);
        playerLabels.clear();
        repaint(); revalidate();
    }

    public void addPlayers() {
        for (int i = 0; i < playerLabels.size(); i++) {
            sableLabel.add(playerLabels.get(i), new GridBagConstraints(
                    i/2, i%2, 1, 1, 1, 1,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0)
            );
        }
    }

    public boolean hasPlayers() { return playerLabels.size() > 0; }

    public ArrayList<JLabel> getPlayerLabels() { return playerLabels; }

    public void removeSable() { remove(0); }

    @Override
    public void update(Observable o, Object arg) {
        // TODO: Update the view

    }

    public void setAll(boolean b) {
        setClicked(b);
        setHighlighted(b);
    }

    public void setHighlighted(boolean b) {
//        new CarteTerrain(110, 150);
        highlighted = b;
//        if (highlighted) background.setIcon(CarteTerrain.getHighlighted());
//        else background.setIcon(CarteTerrain.getDesert());
//        repaint(); revalidate();
    }

    public boolean isClicked() { return clicked; }

    public boolean isHighlighted() { return highlighted; }

    public ArrayList<JLabel> getPlayers() { return playerLabels; }

    public void setExplored(boolean b) { explored = b; }
}
