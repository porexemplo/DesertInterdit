package Model;

import utils.TypeCase;

import java.util.ArrayList;
import java.util.Collections;

public class Terrain {
    private Case[][] plateau;
    private int taille = 5;
    private int emptyX = 2, emptyY = 2;

    public Terrain() {
        this.plateau = new Case[taille][taille];

        ArrayList<int[]> pos = new ArrayList<>();
        for (int y = 0; y < taille; y++)
            for (int x = 0; x < taille; x++)
                pos.add(new int[]{x, y});

        pos.remove(12);

        Collections.shuffle(pos);

        // On place les cases
        this.plateau[pos.get(0)[1]][pos.get(0)[0]] = new Case(pos.get(0)[0], pos.get(0)[1], TypeCase.LAUNCHER_H);
        this.plateau[pos.get(1)[1]][pos.get(1)[0]] = new Case(pos.get(1)[0], pos.get(1)[1], TypeCase.LAUNCHER_V);
        this.plateau[pos.get(2)[1]][pos.get(2)[0]] = new Case(pos.get(2)[0], pos.get(2)[1], TypeCase.WHEEL_H);
        this.plateau[pos.get(3)[1]][pos.get(3)[0]] = new Case(pos.get(3)[0], pos.get(3)[1], TypeCase.WHEEL_V);
        this.plateau[pos.get(4)[1]][pos.get(4)[0]] = new Case(pos.get(4)[0], pos.get(4)[1], TypeCase.MOTEUR_H);
        this.plateau[pos.get(5)[1]][pos.get(5)[0]] = new Case(pos.get(5)[0], pos.get(5)[1], TypeCase.MOTEUR_V);
        this.plateau[pos.get(6)[1]][pos.get(6)[0]] = new Case(pos.get(6)[0], pos.get(6)[1], TypeCase.TURBINE_H);
        this.plateau[pos.get(7)[1]][pos.get(7)[0]] = new Case(pos.get(7)[0], pos.get(7)[1], TypeCase.TURBINE_V);

        for (int i = 0; i < 3; i++)
            this.plateau[pos.get(8 + i)[1]][pos.get(8 + i)[0]] = new Case(pos.get(8 + i)[0], pos.get(8 + i)[1], TypeCase.OASIS);

        for (int i = 0; i < 3; i++)
            this.plateau[pos.get(11 + i)[1]][pos.get(11 + i)[0]] = new Case(pos.get(11 + i)[0], pos.get(11 + i)[1], TypeCase.TUNNEL);

        for (int i = 0; i < 9; i++)
            this.plateau[pos.get(14 + i)[1]][pos.get(14 + i)[0]] = new Case(pos.get(14 + i)[0], pos.get(14 + i)[1], TypeCase.ENGRENNAGE);

        this.plateau[pos.get(23)[1]][pos.get(23)[0]] = new Case(pos.get(23)[0], pos.get(23)[1], TypeCase.PISTE);
        
        this.plateau[emptyX][emptyY] = null;
        this.initSable();
    }

    private void initSable() {
        getCase(0, 2).setSable(1);
        getCase(1, 1).setSable(1);
        getCase(1, 3).setSable(1);
        getCase(2, 0).setSable(1);
        getCase(2, 4).setSable(1);
        getCase(3, 1).setSable(1);
        getCase(3, 3).setSable(1);
        getCase(4, 2).setSable(1);
    }

    public Case getCase(int x, int y) {
        return this.plateau[y][x];
    }

    public Case[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(Case[][] plateau) {
        this.plateau = plateau;
    }

    public int[] getVoisin(Direction dir, int x, int y) {
        return switch (dir) {
            case NORD -> y - 1 >= 0 ? new int[]{x, y - 1} : null;
            case SUD -> y + 1 < taille ? new int[]{x, y + 1} : null;
            case EST -> x + 1 < taille ? new int[]{x + 1, y} : null;
            case OUEST -> x - 1 >= 0 ? new int[]{x - 1, y} : null;
            case NORD_EST -> y - 1 >= 0 && x + 1 < taille ? new int[]{x + 1, y - 1} : null;
            case NORD_OUEST -> y - 1 >= 0 && x - 1 >= 0 ? new int[]{x - 1, y - 1} : null;
            case SUD_EST -> y + 1 < taille && x + 1 < taille ? new int[]{x + 1, y + 1} : null;
            case SUD_OUEST -> y + 1 < taille && x - 1 >= 0 ? new int[]{x - 1, y + 1} : null;
        };
    }

    // Getter for emptyX, emptyY
    public int[] getEmpty() { return new int[] {emptyX, emptyY}; }

    public void setCase(int x, int y, Case c) {
        if (c == null) { emptyX = x; emptyY = y; }
//        if (x == emptyX && y == emptyY) { emptyX = -1; emptyY = -1; }
        else { c.x = x; c.y = y; }
        this.plateau[y][x] = c;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int x = 0; x < taille; x++) {
            for (int y = 0; y < taille; y++) {
                if (this.plateau[y][x] == null)
                    s.append(" ");
                else
                    s.append(this.plateau[y][x].toString());
            }
            s.append("\n");
        }
        return s.toString();
    }

}
