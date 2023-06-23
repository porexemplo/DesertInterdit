package View;

import Model.cModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class cView extends JFrame implements Observer {
    private DesertView desertView = new DesertView();
    private NavigationView navigationView = new NavigationView();
    private SideView sideView = new SideView();
    private GameSideView gameSideView = new GameSideView();
    private InitView initView = new InitView();

    private CaseInfoView caseInfoView = new CaseInfoView(desertView.getCard(0, 0));

    public cView() {
        setTitle("Desert Interdit");
        setPreferredSize(new Dimension(1000, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        // Setting the layout for the frame
        setLayout(new BorderLayout(2, 2));

        // Setting up the player view
        initView.setVisible(false);
        gameSideView.setCaseInfoView(caseInfoView);
        // TODO: Add the player view to the frame

        // Add the panels to the frame
        add(desertView, BorderLayout.CENTER);
        add(navigationView, BorderLayout.SOUTH);
        add(new MenuView(), BorderLayout.NORTH);
        add(sideView, BorderLayout.WEST);
        add(gameSideView, BorderLayout.EAST);
        pack();
    }

//    public DesertView getDesertView() {
//        return desertView;
//    }

    public InitView getInitView() { return initView; }
    public SideView getSideView() { return sideView; }

    public GameSideView getGameSideView() { return gameSideView; }
    public DesertView getDesertView() { return desertView; }
    public CaseInfoView getCaseInfoView() { return caseInfoView; }

    public void addStartListener(ActionListener listener) {
        navigationView.getBtnStart().addActionListener(listener);
    }

    public void addExitListener(ActionListener listener) { navigationView.getBtnExit().addActionListener(listener); }

    public void addTourListener(ActionListener listener) { navigationView.getBtnTour().addActionListener(listener); }

    public void addBeginListener(ActionListener listener) { initView.getBtnBeginGame().addActionListener(listener); }

    public void addNextListener(ActionListener listener) { initView.getBtnNext().addActionListener(listener); }

    public void addDesensablerListener(ActionListener listener) {caseInfoView.getBtnSable().addActionListener(listener);}

    public void addExplorerListener(ActionListener listener) {caseInfoView.getBtnExplorer().addActionListener(listener);}

    @Override
    public void update(Observable o, Object arg) {
        desertView.update(o, arg);
        gameSideView.update(o, arg);
        sideView.update(o, arg);
    }

}
