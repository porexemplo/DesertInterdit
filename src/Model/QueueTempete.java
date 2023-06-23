package Model;

import java.util.*;

public class QueueTempete {
    private Queue<Carte> queue;

    public QueueTempete() {
        queue = new LinkedList<>();
        init(); shuffle();
    }
    public class Carte {
        public enum CType { TEMPETE, DECHENEMENT, VAGUE_CHALEUR;}
        private int force = 0;
        private Direction dir = null;
        private CType type = null;

        public Carte(CType t) { this.type = t; }
        public Carte(CType t, Direction dir, int force) {
            this.type = t; this.dir = dir; this.force = force;
        }

        // Getters & Setters
        public CType getType() { return this.type; }
        public int getForce() { return this.force; }
        public void setForce(int force) { this.force = force; }

        public Direction getDir() { return this.dir; }
        public void setDir(Direction dir) { this.dir = dir; }
    }

    private void init() {
        for (int i = 0; i < 4; i++)
            queue.add(new Carte(Carte.CType.VAGUE_CHALEUR));

        for (Direction dir : new Direction[] {Direction.NORD, Direction.SUD, Direction.EST, Direction.OUEST}) {
            for (int i = 1; i <= 3; i++)
                queue.add(new Carte(Carte.CType.TEMPETE, dir, 1));

            for (int i = 1; i <= 2; i++)
                queue.add(new Carte(Carte.CType.TEMPETE, dir, 2));

            queue.add(new Carte(Carte.CType.TEMPETE, dir, 3));
        }

        for (int i = 0; i < 3; i++)
            queue.add(new Carte(Carte.CType.DECHENEMENT));
    }

    public void shuffle() {
        List<Carte> list = new ArrayList<>(queue);
        Collections.shuffle(list);
        queue.clear(); queue.addAll(list);
    }

    public Carte withdraw() {
        Carte returnCarte = queue.poll();
        queue.add(returnCarte); return returnCarte;
    }
}