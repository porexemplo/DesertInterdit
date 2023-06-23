package Controller;

import Model.QueueTempete;
import Model.cModel;
import View.cView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DeckMouseListener implements MouseListener {

    cModel theModel;

    public DeckMouseListener(cView view, cModel model) {
        view.getGameSideView().getQueueTempeteView().addUnflippedCardListener(this);
        this.theModel = model;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (
                theModel.getCurrentPlayer().getNbActionsTempete() <= 0
                || theModel.getCurrentPlayer().getNbActions() > 0
        ) return;
        theModel.progress();
        theModel.getCurrentPlayer().actTempete();
        if (theModel.getCurrentPlayer().cannotAct()) theModel.finTour();
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
