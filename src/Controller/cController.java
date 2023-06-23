package Controller;

import Model.Player;
import Model.PlayerClass;
import Model.cModel;
import View.CaseView;
import View.PlayerView;
import View.cView;

import java.util.ArrayList;
import java.util.Collections;

public class cController {
    private cView theView;
    private cModel theModel;

    public cController(cView theView, cModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        this.theModel.addObserver(this.theView);
        this.theModel.addObserver(this.theView.getSideView());

        this.theView.addStartListener(e -> { this.theView.getInitView().setVisible(true); });
        this.theView.addExitListener(e -> { System.exit(0); });

        this.theView.addTourListener(e -> { theModel.progress(); });

        ArrayList<PlayerClass> playerClass = PlayerClass.getClasses();
        Collections.shuffle(playerClass);

        this.theView.addBeginListener(e -> {
            this.theView.getInitView().dispose();
            for (int i = 0; i < this.theView.getInitView().getNumPlayers(); i++) {
                Player player = new Player(this.theView.getInitView().getPlayerName(i), playerClass.get(i));
                player.setCurrentCase(this.theModel.getTerrain().getCase(0, 2));
                player.setActionsTempete(this.theModel.getNiveauTempete());
                player.setActionsEquipement(0);
                this.theView.getDesertView().getCard(player.getCurrentCase().getY(), player.getCurrentCase().getX()).addPlayer(player.getPlayerClass().toSting());
                this.theModel.addPlayer(player);
                PlayerView playerView = new PlayerView(this.theModel.getPlayer(i).getName(), player.getNiveauEau(), player.getPlayerClass().toSting());
                this.theView.getSideView().setPlayer(playerView);
            }
            this.theView.getSideView().addPlayers();
            this.theView.update(this.theModel, null);
        });


        this.theView.addNextListener(e -> {
            ArrayList<String> playerNames = new ArrayList<>();
            for (int i = 0; i < this.theView.getInitView().getNumPlayers(); i++)
                playerNames.add(playerClass.get(i).toSting());
            this.theView.getInitView().getNext(playerNames);
        });

        this.theView.addDesensablerListener(e -> {
            CaseView clickedCase = theView.getDesertView().getClicked();
            assert (clickedCase != null);
            this.theModel.removeSable(clickedCase.getXCase(), clickedCase.getYCase());
            this.theView.getCaseInfoView().setDesensabler(false);
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 5; j++)
                    this.theView.getDesertView().getCard(i, j).setAll(false);
            this.theView.update(this.theModel, null);
        });

        this.theView.addExplorerListener(e -> {
            CaseView clickedCase = theView.getDesertView().getClicked();
            assert (clickedCase != null);
            this.theModel.explorer(clickedCase.getXCase(), clickedCase.getYCase());
            this.theView.getCaseInfoView().setExplorer(false);
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 5; j++)
                    this.theView.getDesertView().getCard(i, j).setAll(false);
            clickedCase.setExplored(true);
            this.theView.update(this.theModel, null);
        });

        new DeckMouseListener(this.theView, this.theModel);
        new EquipMouseListener(this.theView, this.theModel);

        for (int y = 0; y < 5; y++)
            for (int x = 0; x < 5; x++)
                new CaseMouseListener(this.theView, this.theModel, x, y);
    }

    public void start() {
        theView.setVisible(true);
//        System.out.println(theModel.getTerrain());
    }
}
