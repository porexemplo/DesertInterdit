package View;

import utils.TuileMachine;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class GameSideView extends JPanel implements Observer {

    private BorderLayout layout = new BorderLayout();
    private JPanel mainPanel = new JPanel();

    private ProgressBar progressBar = new ProgressBar();
    private QueueTempeteView queueTempeteView = new QueueTempeteView();
    private QueueEquipementView queueEquipementView = new QueueEquipementView();
    private JPanel equipementPanel = new JPanel();

    public GameSideView() {
        new TuileMachine(50, 50);
        setLayout(layout);
//        layout.setConstraints(this, new GridBagConstraints());

        setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));

        mainPanel.setPreferredSize(new Dimension(300, 800));
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));

        equipementPanel.setLayout(new GridLayout(2, 4, 10, 10));
        for (int i = 1; i <= 4; i++)
            equipementPanel.add(new JLabel(TuileMachine.getIcon(i)));
        for (int i = 5; i < 9; i++)
            equipementPanel.add(new JLabel(TuileMachine.getIcon(i)));

        mainPanel.add(progressBar);
        mainPanel.add(queueTempeteView);
        mainPanel.add(queueEquipementView);
        mainPanel.add(equipementPanel);

        add(mainPanel, BorderLayout.CENTER);
    }

    public QueueTempeteView getQueueTempeteView() { return queueTempeteView; }
    public QueueEquipementView getQueueEquipementView() { return queueEquipementView; }

    @Override
    public void update(java.util.Observable o, Object arg) {
        queueTempeteView.update(o, arg);
        queueEquipementView.update(o, arg);
        progressBar.update(o, arg);
    }

    public void setCaseInfoView(CaseInfoView caseInfoView) {
        caseInfoView.setVisibility(true);
        add(caseInfoView, BorderLayout.SOUTH);
        repaint(); revalidate();
    }
}
