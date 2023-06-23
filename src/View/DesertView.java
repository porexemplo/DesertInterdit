package View;

import Model.Player;
import Model.cModel;
import utils.CarteFlipped;
import utils.CarteTerrain;
import utils.TypeCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class DesertView extends JPanel implements Observer {
    private GridBagLayout centerLayout = new GridBagLayout();
    private CaseView[][] panels = new CaseView[5][5];
    private int emptyX = 2, emptyY = 2;
    CarteTerrain ct = new CarteTerrain(110, 150);
    CarteFlipped cf = new CarteFlipped(110, 150);

    public DesertView() {
        setLayout(centerLayout);

        for (int x = 0; x < 5; x++)
            for (int y = 0; y < 5; y++) {
                panels[y][x] = new CaseView(x, y);
                add(panels[y][x], new GridBagConstraints(
                        x, y, 1, 1, .0, .0,
                        GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                        new Insets(3, 3, 3, 3), 0, 0));
            }
    }

    public void setEmptyCard(int x, int y) {
        getCard(emptyX, emptyY).setVisible(true);
        emptyX = x;
        emptyY = y;
        getCard(emptyX, emptyY).setVisible(false);
    }

    public int[] getEmptyCard() {
        return new int[]{emptyX, emptyY};
    }

    public void setCard(int x, int y, int sable) {
//        @Important: In case I want to remove all the components of the card
//        getCard(x, y).removeAll();
            getCard(x, y).setSable(sable);
    }

    public CaseView getCard(int x, int y) { return panels[y][x]; }

    public CaseView getClicked() {
        for (CaseView[] panel : panels)
            for (CaseView p : panel)
                if (p.isClicked())
                    return p;
        return null;
    }

    public void resetClick() {
        for (int x = 0; x < 5; x++)
            for (int y = 0; y < 5; y++) {
                panels[y][x].setClicked(false);
                panels[y][x].repaint();
                panels[y][x].revalidate();
            }
    }

    @Override
    public void update(Observable o, Object arg) {
//        System.out.println("Log: DesertView updated");
        int[] empty = ((cModel) o).getTerrain().getEmpty();
        setEmptyCard(empty[1], empty[0]);
        for (int x = 0; x < 5; x++)
            for (int y = 0; y < 5; y++)
                if (((cModel) o).getTerrain().getCase(x, y) != null) {
                    setCard(x, y, ((cModel) o).getTerrain().getCase(x, y).getSable());
                    getCard(x, y).setTypeCase(((cModel) o).getTerrain().getCase(x, y).getTypeCase());
                    if (getCard(x, y).isExplored())
                        if (getCard(x, y).isClicked())
                            getCard(x, y).setImageIcon(cf.getIconClicked(getCard(x, y).getTypeCase()));
                        else if (getCard(x, y).isHighlighted())
                            getCard(x, y).setImageIcon(cf.getIconHighlighted(getCard(x, y).getTypeCase()));
                        else
                            getCard(x, y).setImageIcon(cf.getIcon(getCard(x, y).getTypeCase()));
                    else
                        if (getCard(x, y).isClicked())
                            getCard(x, y).setImageIcon(ct.getIconClicked(getCard(x, y).getTypeCase()));
                        else if (getCard(x, y).isHighlighted())
                            getCard(x, y).setImageIcon(ct.getIconHighlighted(getCard(x, y).getTypeCase()));
                        else
                            getCard(x, y).setImageIcon(ct.getIcon(getCard(x, y).getTypeCase()));
                    getCard(x, y).removeAllPlayers();
                    for (Player p : ((cModel) o).getPlayers(((cModel) o).getTerrain().getCase(x, y)))
                        getCard(x, y).addPlayer(p.getPlayerClass().toSting());
                    getCard(x, y).repaint(); getCard(x, y).revalidate();
                }
                else
                    setEmptyCard(x, y);
        repaint(); revalidate();
    }
}
