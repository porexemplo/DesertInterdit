package Controller;

import Model.Case;
import Model.Direction;
import Model.Player;
import Model.cModel;
import View.PlayerView;
import View.cView;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CaseMouseListener implements MouseListener {
    cModel theModel; cView theView; int x, y;
    public CaseMouseListener(cView theView, cModel theModel, int x, int y) {
        this.theModel = theModel; this.theView = theView;
        this.x = x; this.y = y;

        theView.getDesertView().getCard(x, y).addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean secondClick = theView.getDesertView().getCard(x, y).isClicked();
        boolean movePrompt = theView.getDesertView().getCard(x, y).isHighlighted();

        Case c = null;

        // Displaying the card info
        theView.getCaseInfoView().setCaseView(theView.getDesertView().getCard(x, y));
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                if (theView.getDesertView().getCard(i, j).isClicked() && !theView.getDesertView().getCard(i, j).isHighlighted())
                    c = theModel.getTerrain().getCase(i, j);
                theView.getDesertView().getCard(i, j).setAll(false);
                theView.getCaseInfoView().setDesensabler(false);
                theView.getCaseInfoView().setExplorer(false);
            }

        theView.getDesertView().update(theModel, null);

        if (secondClick) return;

        // Cas d'un clic normal
        if (!movePrompt) {
            theView.getDesertView().getCard(x, y).setClicked(true);
            // Check if the card's voisins have Nbsables > 0 and if so, enable the button to desensable
            for (Direction dir : Direction.values()) {
                int[] voisins = theModel.getTerrain().getVoisin(
                        dir,
                        theModel.getCurrentPlayer().getCurrentCase().getX(),
                        theModel.getCurrentPlayer().getCurrentCase().getY()
                );
                if (voisins == null) continue;
                if (
                        (voisins[0] != x || voisins[1] != y)
                        && !(theModel.getCurrentPlayer().getCurrentCase() == theModel.getTerrain().getCase(x, y))
                ) continue;
                if (theView.getDesertView().getCard(voisins[0], voisins[1]).getNbSables() > 0) {
                    theView.getCaseInfoView().setDesensabler(
                            theView.getDesertView().getCard(x, y).getNbSables() > 0
                            && theModel.getCurrentPlayer().getNbActions() > 0
                    ); break;
                }
            }
            theView.getCaseInfoView().setExplorer(
                    theModel.getCurrentPlayer().getCurrentCase() == theModel.getTerrain().getCase(x, y)
                    && theModel.getCurrentPlayer().getNbActions() > 0
                    && theModel.getTerrain().getCase(x, y).getSable() <= 0
                    && !theModel.getTerrain().getCase(x, y).isExplored()
            );
            theView.update(theModel, null);


            if (! theView.getDesertView().getCard(x, y).hasPlayers()) return;

            boolean hasCurrentPlayer = false;
            for (Player p : theModel.getPlayers(theModel.getTerrain().getCase(x, y)))
                if (p == theModel.getCurrentPlayer()) hasCurrentPlayer = true;

            if (!hasCurrentPlayer) return;
            if (theModel.getCurrentPlayer().getNbActions() <= 0) return;

            // Highlight des cases voisines
            for (Direction dir : Direction.values()) {
                int[] voisins = theModel.getTerrain().getVoisin(dir, x, y);
                if (voisins == null) continue;
//                System.out.println(theView.getDesertView().getCard(voisins[0], voisins[1]).getNbSables());
                if (theView.getDesertView().getCard(voisins[0], voisins[1]).getNbSables() < 2 &&
                theView.getDesertView().getCard(x, y).getNbSables() < 2)
                    theView.getDesertView().getCard(voisins[0], voisins[1]).setHighlighted(true);
            }
            theView.update(theModel, null);
            return;
        }

        // Cas du mouvement du joueur
        assert c != null;
//        for (Player p : theModel.getPlayers(theModel.getTerrain().getCase(c.getX(), c.getY()))) {
            // Move Player in the Model
            theModel.movePlayer(theModel.getCurrentPlayer(), c.getDirectionOf(theModel.getTerrain().getCase(x, y)));
            theView.update(theModel, null);
            // Move Player in the View
//            theView.getDesertView().getCard(c.getX(), c.getY()).removePlayer(theModel.getCurrentPlayer().getPlayerClass().toSting());
//            theView.getDesertView().getCard(x, y).addPlayer(theModel.getCurrentPlayer().getPlayerClass().toSting());
            theModel.getCurrentPlayer().act();
            if (theModel.getCurrentPlayer().cannotAct()) theModel.finTour();
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
