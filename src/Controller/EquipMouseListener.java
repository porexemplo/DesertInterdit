package Controller;

import Model.cModel;
import View.cView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EquipMouseListener implements MouseListener {
    cModel theModel; cView theView;

    public EquipMouseListener(cView view, cModel model) {
        view.getGameSideView().getQueueEquipementView().addUnflippedCardListener(this);
        this.theModel = model;
        this.theView = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (theModel.getCurrentPlayer().getNbActionsEquipement() <= 0) return;
        theModel.getNextEquipement();
        theModel.getCurrentPlayer().setActionsEquipement(0);
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
