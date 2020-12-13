import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.GridLayout;

public class ViewCommand extends JFrame implements ActionListener,ChangeListener, Observer {
    /**
     *
     */
    // components for First panel
    private static final long serialVersionUID = 1L;
    private JButton restart;
    private JButton run;
    private JButton step;
    private JButton pause;
    private JLabel turn;
    private JSlider slider;
    private ControllerPacmanGame controller;

    //components for settings panel
    private JButton mapButton;
    private JPopupMenu maps;
    private JRadioButton radio1G;
    private JRadioButton radio2G;
    private JRadioButton radio1P;
    private JRadioButton radio2P;
    private JButton accept;
    private String strategyGhosts;
    private String strategyPacmans;
    private String mapSelected;
    private JFrame jFrame;

    ///constructeur
    public ViewCommand(ControllerPacmanGame controller) {
        this.controller = controller;
        this.controller.getGame().addObserver(this);
        createUserFrame();
    }

    ///ActionListener permettant d'executer les algo correspondant aux différentes actions
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        //restart
        if (source == restart) {
            System.out.println("Restart pushed");
        } 
        // lancement (du choix des options)
        else if (source == run) {
            try {
                createSettingsFrame();
                //controller.run(); //run à la fin du viewPacmanGame
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        } 
        // avancée d'un tour
        else if (source == step) {
            System.out.println("step pushed");
        } 
        //mets le jeu en pause
        else if (source == pause) {
            controller.getGame().setRunning(false);
            System.out.println("pause pushed");
        } 
        //accepte les paramètres
        else if( source == accept) {
            try{
                this.controller.getGame().setMaze(mapSelected);
                this.controller.getGame().setGhostStrategy(strategyGhosts);
                this.controller.getGame().setPacmanStrategy(strategyPacmans);
                jFrame.dispose();
                controller.start();
                run.setEnabled(false);
            } catch(Exception e2){
                System.out.println(e2.getMessage());
            }
            System.out.println("accept pushed");
        }
        // sinon, on vérifie les boutons radio
        else {
            if (radio1G.isSelected()){
                strategyGhosts=radio1G.getText();
                System.out.println("1G");
            } else if (radio2G.isSelected()) {
                strategyGhosts=radio2G.getText();
                System.out.println("2G");
            }
    
            if (radio1P.isSelected()){
                strategyPacmans=radio1P.getText();
                System.out.println("1P");
            } else if (radio2P.isSelected()){
                strategyPacmans=radio2P.getText();
                System.out.println("2P");
            }
            //cas d'erreur
            else System.out.println(" error occured in settings selection");
        }
        
    }

    public void stateChanged(ChangeEvent event) {
        controller.getGame().setTime(slider.getValue());
    }

    public void update(Observable obs) {
        PacmanGame game = controller.getGame();// (PacmanGame) obs;
        turn.setText("Turn :" + game.getTurn());
    }

    private void createUserFrame() {

        //création de la fenêtre
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fin du processus à la fermeture de la fenêtre
        jFrame.setTitle("Command");
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int height = tailleEcran.height;
        int width = tailleEcran.width;
        jFrame.setSize(width / 2, height / 3);
        jFrame.setLocation(width/4,height-(height/7));
        

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
        turn = new JLabel("Turn  :" + controller.getGame().getTurn(), JLabel.CENTER);

        restart.addActionListener(this);
        run.addActionListener(this);
        step.addActionListener(this);
        pause.addActionListener(this);

        buttonHaut.add(restart);
        buttonHaut.add(run);
        buttonHaut.add(step);
        buttonHaut.add(pause);

        //création du slider
        JLabel titreSlide = new JLabel("Number of turn per secondes ");
        titreSlide.setHorizontalAlignment(JLabel.CENTER);
        slider = new JSlider(1, 10, 5);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        //gestion des valeurs du slider avec un changeListener   
        slider.addChangeListener(this);

        //ajout des éléments au JFrame
        contbuttonBas.add(titreSlide);
        contbuttonBas.add(slider);

        buttonBas.add(contbuttonBas);
        buttonBas.add(turn);

        jFrame.add(buttonHaut);
        jFrame.add(buttonBas);

        jFrame.setVisible(true);
    }

    private void createSettingsFrame(){
        /** création de la fenêtre */
        mapSelected="originalCLassic_food_fivePAcman.lay"; //carte par défaut
        jFrame = new JFrame();
        jFrame.setTitle("Settings");
        jFrame.setSize(new Dimension(700, 700));
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        jFrame.setSize(width/3, height /5);
        jFrame.setLocation(width/3, height/4);
        System.out.println("test");

        /*** Composants de la window */

        GridLayout conteneur = new GridLayout(1, 4);
        jFrame.setLayout(conteneur);

        //création de la liste des cartes possibles
        maps = new JScrollPopupMenu();
        //actionListener pour le menu
        ActionListener menuListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mapSelected=event.getActionCommand().toString();
                System.out.println("tostring:"+mapSelected);
                System.out.println("Elément de menu [" + event.getActionCommand()+ "] utilisé.");
            }
        };

        //récupération de la liste de fichiers et ajout dans le JMenu
        FReader dirReader = new FReader("Layouts/");
        ArrayList<String> files = dirReader.getTitles();
        for(String title : files){
            JMenuItem item=new JMenuItem(title);
            item.addActionListener(menuListener);
            maps.add(item);
        }

        //ajout d'un bouton pour ouvrir le menu
        mapButton = new JButton("select a map");
        mapButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                maps.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        //création de la liste de stratégies des ghosts
        JPanel panelGhosts = new JPanel(new GridLayout(0,1));
        Border borderG = BorderFactory.createTitledBorder("Ghost Strategy");
        panelGhosts.setBorder(borderG);
        ButtonGroup strategyGhosts = new ButtonGroup();
        radio1G = new JRadioButton("Random");
        radio2G = new JRadioButton("A*",true);
        strategyGhosts.add(radio1G);
        panelGhosts.add(radio1G);
        strategyGhosts.add(radio2G);
        panelGhosts.add(radio2G);

        //création de la liste de stratégies des pacman
        JPanel panelPacman = new JPanel(new GridLayout(0,1));
        Border borderP = BorderFactory.createTitledBorder("Ghost Strategy");
        panelPacman.setBorder(borderP);
        ButtonGroup strategyPacmans = new ButtonGroup();
        radio1P = new JRadioButton("Random");
        radio2P = new JRadioButton("A*",true);
        strategyPacmans.add(radio1P);
        panelPacman.add(radio1P);
        strategyPacmans.add(radio2P);
        panelPacman.add(radio2P);


        //création du bouton de validation
        accept = new JButton(" OK ");

        //ajout des écouteurs d'action
        accept.addActionListener(this);
        radio1G.addActionListener(this);
        radio2G.addActionListener(this);
        radio1P.addActionListener(this);
        radio2P.addActionListener(this);

        //placement sur le JFrame
        jFrame.add(panelGhosts);
        jFrame.add(panelPacman);
        jFrame.add(mapButton);
        jFrame.add(accept);
        jFrame.setVisible(true);

        System.out.println(" OK ");

    }

}
