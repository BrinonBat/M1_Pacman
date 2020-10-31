import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.awt.event.*;
import javax.swing.JLabel;

import java.awt.GridLayout;

public class ViewCommand extends JFrame implements ActionListener,Observer {
    private JButton restart;
    private JButton run;
    private JButton step;
    private JButton pause;
    private JLabel turn;
    private ControllerPacmanGame controller;

    public ViewCommand(ControllerPacmanGame controller) {

        JFrame jFrame = new JFrame();
        jFrame.setTitle("Command");
        jFrame.setSize(new Dimension(700, 700));
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int height = tailleEcran.height;
        int width = tailleEcran.width;
        jFrame.setSize(width / 2, height / 2);
        jFrame.setLocationRelativeTo(null);

        /*** Composant de la window */

        GridLayout conteneur = new GridLayout(2, 2);
        jFrame.setLayout(conteneur);

        JPanel buttonHaut = new JPanel(new GridLayout(1, 4));
        JPanel buttonBas = new JPanel(new GridLayout(1, 2));
        JPanel contbuttonBas = new JPanel(new GridLayout(2, 1));

        restart = new JButton("", new ImageIcon("icones/icon_restart.png"));
        run = new JButton("", new ImageIcon("icones/icon_run.png"));
        step = new JButton("", new ImageIcon("icones/icon_step.png"));
        pause = new JButton("", new ImageIcon("icones/icon_pause.png"));
        turn = new JLabel("Turn  :"+controller.getGame().getTurn(), JLabel.CENTER);

        restart.addActionListener(this);
        run.addActionListener(this);
        step.addActionListener(this);
        pause.addActionListener(this);

        buttonHaut.add(restart);
        buttonHaut.add(run);
        buttonHaut.add(step);
        buttonHaut.add(pause);

        JLabel titreSlide = new JLabel("Number of turn per secondes ");
        titreSlide.setHorizontalAlignment(JLabel.CENTER);
        JSlider slider = new JSlider(1, 10, 5);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        contbuttonBas.add(titreSlide);
        contbuttonBas.add(slider);

        buttonBas.add(contbuttonBas);
        buttonBas.add(turn);

        jFrame.add(buttonHaut);
        jFrame.add(buttonBas);

        jFrame.setVisible(true);

        this.controller = controller;
        this.controller.getGame().addObserver(this);

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == restart){
            System.out.println("Restart pushed");
        }
        else if (source == run) {
            try {
                controller.start();
                run.setEnabled(false);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }
        else if( source == step) {
            controller.run();       
            System.out.println("step pushed");    
        }
        else if ( source == pause ){
            controller.getGame().setRunning(false);
            System.out.println("pause pushed");
        }
      
    }

    public void update(Observable obs){
        PacmanGame game = (PacmanGame) obs;
        turn.setText("Turn :"+game.getTurn());
    }

}
