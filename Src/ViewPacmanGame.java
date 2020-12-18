import javax.swing.*;

//import sun.awt.AWTAccessor.KeyEventAccessor;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ViewPacmanGame implements Observer {
    private JFrame window;
    private ControllerPacmanGame controller;
    private PanelPacmanGame view;
    private int nvie;
    private static boolean instancied = false;

    public static boolean isInstancied(){return instancied;}

    ViewPacmanGame(Maze maze, InterfaceControleur controller) {
        instancied=true;
        /**Instanciation du controller  */
        this.controller = (ControllerPacmanGame) controller;
        this.controller.getGame().addObserver(this);
        createUserFrame(maze);

        nvie = this.controller.getGame().getVie();

        System.out.println(this.controller.getGame().toString());

    }

    public ControllerPacmanGame getController(){
        return controller;
    }

    public void update(Observable obs) {
        // Les deux notations sont equivalentes PacmanGame currentGame = controller.getGame(); 
        PacmanGame currentGame = (PacmanGame) obs;
        ArrayList<PositionAgent> positionGhost = new ArrayList<PositionAgent>();
        ArrayList<PositionAgent> positionPacmans = new ArrayList<PositionAgent>();
        
        if( currentGame.getVie() < nvie)
        {   
            this.nvie =  currentGame.getVie();
            currentGame.setVie(this.nvie);
        }
        else{
            positionPacmans.add(currentGame.getPacmans().get(0).getPosition());
        
            if(currentGame.getGhosts().size() >= 0)
            {
                for (Ghost g : currentGame.getGhosts()) {
                    positionGhost.add(g.getPosition());
                    if(g.isScared())
                        view.setGhostsScarred(true);
                    else
                        view.setGhostsScarred(false);
                }
                view.setGhosts_pos(positionGhost);
                view.setPacmans_pos(positionPacmans);
            }
            else {
                createWinFrame();
            }
        }
       
        view.repaint();
    }

    public void createWinFrame(){
    }


    public void createUserFrame(Maze maze)
    {

        ArrayList<PositionAgent> positionPacmans = new ArrayList<PositionAgent>();
        Pacman currentPacman =  this.controller.getGame().getPacmans().get(0);
        positionPacmans.add(currentPacman.getPosition());
        maze.setPacman_start(positionPacmans);
        /********** Creation de l'interface graphique ***********/

        window = new JFrame();
        window.setTitle("Pacman");
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int height = tailleEcran.height;
        int width = tailleEcran.width;

        window.setSize(width / 2, height / 2);
        window.setLocation(width/4,height/7-6);
        window.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        getController().getGame().moveAgent(currentPacman, new AgentAction(AgentAction.NORTH));;
                        break;
                    case KeyEvent.VK_RIGHT:
                        getController().getGame().moveAgent(currentPacman,new AgentAction(AgentAction.EAST));
                        break;
                    case KeyEvent.VK_DOWN:
                        getController().getGame().moveAgent(currentPacman,new AgentAction(AgentAction.SOUTH));
                        break;
                    case KeyEvent.VK_LEFT:
                        getController().getGame().moveAgent(currentPacman,new AgentAction(AgentAction.WEST));
                        break;
                }
            }
            

            @Override
            public void keyReleased(KeyEvent e) {
                return;
            }

            @Override
            public void keyTyped(KeyEvent e) {
                return;
            }
            
        });
        view = PanelPacmanGame.getInstance();
        view.setMaze(maze);
        window.add(view);
        window.setVisible(true);
        getController().run();

        /********** Fin Creation de l'interface graphique ***********/

    }

    
}
