package View;

import utils.ClassIcon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InitView extends JDialog {

    private int numPlayers;

    JButton btnBeginGame = new JButton("Begin Game");
    JButton btnNext = new JButton("Next");
    JSlider slider = new JSlider(2, 5);
    private JTextField[] textFields;
    private JLabel[] playerClassLabels;

    public InitView() {
        new ClassIcon(95, 25);
        numPlayers = 2;
        setTitle("Choose number of players");
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(300, 300));
        setMinimumSize(new Dimension(300, 300));
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(false);

        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setValue(2);
        slider.addChangeListener(e -> {
            numPlayers = slider.getValue();
        });


        // Add the slider but this time make it smaller in the center
        add(
                slider, new GridBagConstraints(
                        0, 0, 1, 1, 1, 1,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 20, 0, 20), 0, 0
                )
        );

        add(
                btnNext, new GridBagConstraints(
                        0, 2, 1, 1, 1, 1,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 80, 0, 80), 0, 0
                )
        );

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void setNumPlayers(int numPlayers) { this.numPlayers = numPlayers; }

    public int getNumPlayers() { return numPlayers; }

    public JButton getBtnBeginGame() { return btnBeginGame; }
    public JButton getBtnNext() { return btnNext; }

    public void getNext(ArrayList<String> playerClass) {
        this.remove(btnNext);
        this.remove(slider);
        textFields = new JTextField[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            textFields[i] = new JTextField("Player " + (i + 1));
            textFields[i].setPreferredSize(new Dimension(100, 25));
            add(
                    textFields[i], new GridBagConstraints(
                            0, i, 1, 1, 1, 1,
                            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 50, 0, 5), 0, 0
                    )
            );
            add(
                    new JLabel(ClassIcon.getIcon(playerClass.get(i))), new GridBagConstraints(
                            1, i, 1, 1, 1, 1,
                            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 0, 15), 0, 0
                    )
            );
        }
        this.add(
                btnBeginGame, new GridBagConstraints(
                0, numPlayers, 2, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 80, 0, 80), 0, 0
        ));
        this.revalidate(); // Revalidate the panel
        this.repaint(); // Repaint the panel
    }

    public String getPlayerName(int i) {
        return textFields[i].getText();
    }
}