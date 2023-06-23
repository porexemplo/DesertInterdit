package View;

import Model.cModel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ProgressBar extends JPanel implements Observer {

    private int niveauSable = 0;
    final int MAX_VALUE = 70;

    private JProgressBar progressBar = new JProgressBar();
    private JLabel label = new JLabel("Niveau de Tempête: " + niveauSable);

    public ProgressBar() {
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();
        gbc.gridx = 0; gbc.gridy = 0;
        gbl.setConstraints(label, gbc);
        setLayout(gbl);
        setVisible(true);


        add(label);

        gbc.gridy = 1;
        gbl.setConstraints(progressBar, gbc);
        progressBar.setValue(niveauSable);
        progressBar.setStringPainted(true);
        progressBar.setPreferredSize(new Dimension(270, 20));
        progressBar.setMinimumSize(new Dimension(270, 20));
        progressBar.setMaximum(MAX_VALUE);
        progressBar.setString((niveauSable/10.) + "/" + (MAX_VALUE/10.));

        add(progressBar);
    }

    public void increment() { niveauSable += 5; progressBar.setValue(niveauSable); }

    // Setter
    public void setNiveauSable(int niveauSable) { this.niveauSable = niveauSable; }

    @Override
    public void update(Observable o, Object arg) {
        setNiveauSable((int) (10*((cModel) o).getNiveauTempete()));
        progressBar.setValue(niveauSable);
        progressBar.setString((niveauSable/10.) + "/" + (MAX_VALUE/10.));
        label.setText("Niveau de Sable: " + niveauSable/10.);
    }
}
