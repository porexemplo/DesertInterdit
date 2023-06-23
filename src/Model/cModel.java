package Model;

import utils.TypeCase;

import java.util.ArrayList;
import java.util.Observable;

public class cModel extends Observable {
    private final Terrain terrain;
    private QueueTempete queueTempete;
    private QueueEquipement queueEquipement;
    QueueTempete.Carte currentTempeteCard = null;
    Equipement currentEquipementCard = null;
    private float niveauTempete = 1;
    private int currentPlayer = 0;
    final int MAX_SABLE = 7;

    private ArrayList<Player> players;
    public cModel() {
        this.terrain = new Terrain();
        this.players = new ArrayList<>();
        this.queueTempete = new QueueTempete();
        this.queueEquipement = new QueueEquipement();
    }

    public void addPlayer(Player p) { players.add(p); }

    public Player getPlayer(int index) { return players.get(index); }

    public Terrain getTerrain() {
        return terrain;
    }

    public float getNiveauTempete() { return niveauTempete; }

    public QueueTempete.Carte getCurrCard() { return currentTempeteCard; }

    public Equipement getCurrEquipement() { return currentEquipementCard; }

    public void getNextEquipement() {
        currentEquipementCard = queueEquipement.withdraw();
        getCurrentPlayer().addEquipement(currentEquipementCard);
        setChanged();
        notifyObservers();
    }

    public void progress() { // Piocher une carte tempête
        currentTempeteCard = queueTempete.withdraw();
        switch (currentTempeteCard.getType()) {
            case TEMPETE -> {
                blow(currentTempeteCard.getDir(), currentTempeteCard.getForce());
            }
            case VAGUE_CHALEUR -> {
                for (Player p : players) {
                    p.drink();
                    if (p.getNiveauEau() <= 0) {
                        System.out.println("YOU LOSE");
                        System.exit(0);
                    }
                }
            }
            case DECHENEMENT -> unleash();
        }
        setChanged();
        notifyObservers();
    }

    public void blow(Direction dir, int force) { // Souffler
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < force; i++) {
            int[] empty = terrain.getEmpty();
            int xEmpty = empty[0], yEmpty = empty[1];
            int[] voisin = terrain.getVoisin(dir, xEmpty, yEmpty);

            if (voisin == null) return;

            int xVoisin = voisin[0], yVoisin = voisin[1];

            Case tempCase = terrain.getCase(xVoisin, yVoisin);
            // FIXME: Literally. Spent 5 hours trying to debug this part, finally it's fixed. I'm leaving this comment here to remind myself of the pain I went through. - Redwane 1:37 AM 2023-04-22
//            if (hasPlayers(tempCase)) {
//                players = getPlayers(tempCase);
//                for (Player p : players)
//                    movePlayer(p, Direction.getOpposite(dir));
//            }
            tempCase.addSable(1); // tempCase.x = xEmpty; tempCase.y = yEmpty;
            terrain.setCase(xEmpty, yEmpty, tempCase);
            terrain.setCase(xVoisin, yVoisin, null);
        }
        notifyObservers();
    }

    public void unleash() { // Déchaîner
        niveauTempete += .5;
        if (niveauTempete >= MAX_SABLE) {
            System.out.println("YOU LOSE !");
            System.exit(0);
        }
        setChanged();
        notifyObservers();
    }

    public void removeSable(int x, int y) { // désensabler une case
        if (players.get(currentPlayer).getNbActions() <= 0) throw new IllegalStateException("Vous n'avez plus d'actions");
        Case currentCase = players.get(currentPlayer).getCurrentCase();
        boolean canRemove = false;
        for (Direction dir : Direction.values()) {
            int[] voisin = terrain.getVoisin(dir, x, y);
            if (voisin == null) continue;
            if (
                    voisin[0] == players.get(currentPlayer).getCurrentCase().getX()
                    && voisin[1] == players.get(currentPlayer).getCurrentCase().getY()
            ) { canRemove = true; break; }
        }
        canRemove = canRemove || (currentCase.getX() == x && currentCase.getY() == y);
        canRemove = canRemove && terrain.getCase(x, y).getSable() > 0;

        if (!canRemove) return;
        terrain.getCase(x, y).removeSable(1);

        players.get(currentPlayer).act();

        setChanged();
        notifyObservers();
    }

    public void movePlayer(Player p, Direction dir) {
        // TODO: Check if player can move
        // TODO: If player can move, move him
        int [] curr;
        curr = new int[]{p.getCurrentCase().getX(), p.getCurrentCase().getY()};
        int[] voisin = terrain.getVoisin(dir, curr[0], curr[1]);
        if (voisin == null) return;
        p.setCurrentCase(terrain.getCase(voisin[0], voisin[1]));

        setChanged();
        notifyObservers();
    }

    public boolean hasPlayers(Case c) {
        for (Player p : players)
            if (p.getCurrentCase() == c) return true;
        return false;
    }

    public ArrayList<Player> getPlayers(Case c) {
        ArrayList<Player> players = new ArrayList<>();
        for (Player p : this.players)
            if (p.getCurrentCase() == c) players.add(p);
        return players;
    }

    public void finTour() {
        players.get(currentPlayer).setActions(4);
        currentPlayer = (currentPlayer + 1) % players.size();
        players.get(currentPlayer).setActionsTempete(niveauTempete);
        players.get(currentPlayer).setActionsEquipement(0);
        setChanged();
        notifyObservers();
    }

    public Player getCurrentPlayer() { return players.get(currentPlayer); }

    public String toString() {
        return terrain.toString();
    }

    public void explorer(int xCase, int yCase) {
        if (players.get(currentPlayer).getNbActions() <= 0) throw new IllegalStateException("Vous n'avez plus d'actions");
        Case currentCase = players.get(currentPlayer).getCurrentCase();
        boolean canExplore = (currentCase == terrain.getCase(xCase, yCase));
        if (!canExplore) return;
        getTerrain().getCase(xCase, yCase).setExplored(true);
        if (currentCase.getTypeCase() == TypeCase.ENGRENNAGE)
            players.get(currentPlayer).setActionsEquipement(1);
        else if (currentCase.getTypeCase() == TypeCase.OASIS) {
                for (Player p : players)
                    if (p.getCurrentCase() == currentCase)
                        p.setNiveauEau(Math.min(p.getNiveauEau() + 2, p.getMaxEau()));
        }
        players.get(currentPlayer).act(); if (getCurrentPlayer().cannotAct()) finTour();
        setChanged();
        notifyObservers();
    }
}
