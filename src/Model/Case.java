package Model;

import utils.TypeCase;

public class Case {
    int sable, x, y;
    boolean isExplored = false;
    TypeCase type;


    public Case(int x, int y, TypeCase type) {
        this.sable = 0;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getSable() {
        return sable;
    }
    public void explore() { isExplored = true; }

    public String toString() {
        return "#";
    }

    public void setSable(int sable) {
        this.sable = sable;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void addSable(int sable) { if (isExplored) return; this.sable += sable; }
    public void removeSable(int sable) { this.sable -= sable; }

    public Direction getDirectionOf(Case c) {
        if (c == null) return null;
        if (Math.abs(c.getX() - x) > 1 || Math.abs(c.getY() - y) > 1) return null;
        if (c.getX() - x == 1) {
            if (c.getY() - y == 1) return Direction.SUD_EST;
            if (c.getY() - y == -1) return Direction.NORD_EST;
            if (c.getY() - y == 0) return Direction.EST;
        }
        if (c.getX() - x == -1) {
            if (c.getY() - y == 1) return Direction.SUD_OUEST;
            if (c.getY() - y == -1) return Direction.NORD_OUEST;
            if (c.getY() - y == 0) return Direction.OUEST;
        }
        if (c.getX() - x == 0) {
            if (c.getY() - y == 1) return Direction.SUD;
            if (c.getY() - y == -1) return Direction.NORD;
            if (c.getY() - y == 0) return null;
        }
        return null;
    }

    public TypeCase getTypeCase() { return type; }

    public void setExplored(boolean b) { isExplored = b; }

    public boolean isExplored() { return isExplored; }
}
