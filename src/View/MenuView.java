package View;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JMenuBar {
    private JMenu menu = new JMenu("Menu");
    private JMenuItem menuItem = new JMenuItem("Exit");
    private JMenu menu2 = new JMenu("Help");
    private JMenuItem menuItem2 = new JMenuItem("About");
    private JMenuItem menuItem3 = new JMenuItem("How to play");

    public MenuView() {
        menu.add(menuItem);
        menu2.add(menuItem2);
        menu2.add(menuItem3);
        this.add(menu);
        this.add(menu2);
        menu.setMnemonic('M');
        menu2.setMnemonic('H');
        this.setOpaque(true); this.setBackground(Color.WHITE);
    }

    public JMenu getMenu() {
        return menu;
    }

    public JMenuItem getMenuItem() {
        return menuItem;
    }

    public JMenu getMenu2() {
        return menu2;
    }

    public JMenuItem getMenuItem2() {
        return menuItem2;
    }

    public JMenuItem getMenuItem3() {
        return menuItem3;
    }
}
