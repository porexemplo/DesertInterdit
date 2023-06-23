package Model;

import java.util.ArrayList;
import java.util.Observable;

public class Player extends Observable {
    private String name;
    private PlayerClass playerClass;
    private int nbActions = 0;
    private int nbActionsEquipement = 0;
    private int nbActionsTempete = 0;
    private int niveauEau;
    private Case currentCase = null;

    private ArrayList<Equipement> equipements;

    public Player(String playerName, PlayerClass playerClass) {
        this.playerClass = playerClass;
        name = playerName;
        nbActions = 4;
        niveauEau = playerClass.getNiveauEau();
        equipements = new ArrayList<>();
    }

    public int getNbActions() { return nbActions; }
    public int getNbActionsEquipement() { return nbActionsEquipement; }
    public int getNbActionsTempete() { return nbActionsTempete; }

    public void setNbActions(int nbActions) { this.nbActions = nbActions; }

    public void drink() { niveauEau--; }
    public void act() { nbActions--; }
    public void actTempete() { nbActionsTempete--; }
    public void actEquipement() { nbActionsEquipement--; }
    public boolean cannotAct() { return nbActions <= 0 && nbActionsTempete <= 0 && nbActionsEquipement <= 0; }

    public int getNiveauEau() { return niveauEau; }
    public int setNiveauEau(int i) { return niveauEau = i; }

    public void addEquipement(Equipement equipement) { equipements.add(equipement); }

    public void removeEquipement(Equipement equipement) { equipements.remove(equipement); }

    public void setCurrentCase(Case currentCase) { this.currentCase = currentCase; }

    public Case getCurrentCase() { return currentCase; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public PlayerClass getPlayerClass() { return playerClass; }

    public void setActions(int i) { this.nbActions = i; }
    public void setActionsTempete(float i) { this.nbActionsTempete = (int) Math.floor(i); }
    public void setActionsEquipement(int i) { this.nbActionsEquipement = i; }

    public ArrayList<Equipement> getEquipements() { return equipements; }

    public int getMaxEau() { return playerClass.getNiveauEau(); }
}
