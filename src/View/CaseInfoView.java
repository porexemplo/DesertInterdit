package View;

import utils.CarteTerrain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CaseInfoView extends JPanel {
    private CaseView caseView;
    private JPanel sableLabel = new JPanel();
    private JButton desensabler, explorer;
    public CaseInfoView(CaseView caseView) {
        new CarteTerrain(110, 150);
        this.caseView = caseView;

        desensabler = new JButton(new ImageIcon(CarteTerrain.getScaledImage(
                new ImageIcon("assets/desensabler.png").getImage(),
                114, 30)));
        desensabler.setBorderPainted(false);
        desensabler.setContentAreaFilled(false);
        desensabler.setFocusPainted(false);

        explorer = new JButton("Explorer");
        explorer.setEnabled(false);

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(30, 100));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
//        add(new JLabel("Tuiles"), new GridBagConstraints(
//                0, 0, 1, 1, 0, 0,
//                GridBagConstraints.CENTER, GridBagConstraints.NONE,
//                new Insets(0, 0, 0, 0), 0, 0));

        setVisible(false);
    }

    public void setVisibility(boolean visibility) { setVisible(visibility); }
    public void setDesensabler(boolean bool) { desensabler.setEnabled(bool); }


    public void setCaseView(CaseView caseView) {
        new CarteTerrain(110, 150);
        sableLabel.removeAll();
        sableLabel.setLayout(new GridLayout(1, caseView.getNbSables()));

        for (int i = 0; i < caseView.getNbSables(); i++)
            sableLabel.add(new JLabel(CarteTerrain.getSable()));

        add(sableLabel, new GridBagConstraints(
                0, 1, 2, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        add(desensabler, new GridBagConstraints(
                0, 2, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        add(explorer, new GridBagConstraints(
                1, 2, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        this.caseView = caseView; repaint(); revalidate();
    }

    public JButton getBtnSable() { return desensabler; }
    public JButton getBtnExplorer() { return explorer; }

    public void setExplorer(boolean b) { explorer.setEnabled(b); }
}
