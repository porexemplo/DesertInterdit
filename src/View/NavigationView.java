package View;

import javax.swing.*;
import java.awt.*;

public class NavigationView extends JPanel {
    private JButton btnStart = new JButton("Start");
    private JButton btnExit = new JButton("Exit");
    private JButton btnTour = new JButton("Fin de Tour");

    public NavigationView() {
        this.add(btnStart);
        this.add(btnExit);
        this.add(btnTour);
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public JButton getBtnExit() {
        return btnExit;
    }

    public JButton getBtnTour() { return btnTour; }
}
