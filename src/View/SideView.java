package View;

import Model.cModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SideView extends JPanel implements Observer {
    private ArrayList<PlayerView> players = new ArrayList<>();
    public SideView() {
        setLayout(new GridBagLayout());
//        setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        setPreferredSize(new Dimension(200, 800));
//        setMinimumSize(new Dimension(300, 800));
        setMaximumSize(new Dimension(200, 800));
    }

    public void addPlayers() {
        removeAll();
        for (int i = 0; i < players.size(); i++) {
            add(
                    players.get(i), new GridBagConstraints(
                            0, i, 1, 1, 1, 1,
                            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 10, 0, 0), 0, 0
                    )
            );
        }
        revalidate();
        repaint();
    }

    public void setPlayer(PlayerView player) { players.add(player); }

    @Override
    public void update(Observable o, Object arg) {
        for (int i = 0; i < players.size(); i++)
            players.get(i).update(o, ((cModel) o).getPlayer(i).getNiveauEau());
        repaint(); revalidate();
    }
}
