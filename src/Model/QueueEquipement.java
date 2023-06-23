package Model;

import java.util.*;

public class QueueEquipement {
    private Queue<Equipement> queue;

    public QueueEquipement() {
        queue= new LinkedList<>();
        init(); shuffle();
    }

    public void init() {
        for (int i = 1; i < 4; i++) {
            queue.add(Equipement.BLASTER); queue.add(Equipement.JETPACK);
        }
        for (int i = 0; i < 2; i++) {
            queue.add(Equipement.BOUCLIER); queue.add(Equipement.APPAREILVUE);
        }
        queue.add(Equipement.ACCELERATEURTEMPS);
        queue.add(Equipement.RESERVE_EAU);
    }

    public void shuffle() {
        List<Equipement> list = new ArrayList<>(queue);
        Collections.shuffle(list);
        queue.clear(); queue.addAll(list);
    }

    public Equipement withdraw() {
        Equipement returnCarte = queue.poll();
        queue.add(returnCarte); return returnCarte;
    }
}
