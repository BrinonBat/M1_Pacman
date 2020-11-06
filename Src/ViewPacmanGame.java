import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ViewPacmanGame implements Observer {
    private JFrame window;
    private ControllerPacmanGame controller;
    private PanelPacmanGame view;

    ViewPacmanGame(Maze maze, InterfaceControleur controller) {
        /**Instanciation du controller  */
        this.controller = (ControllerPacmanGame) controller;
        this.controller.getGame().addObserver(this);    
        createUserFrame(maze);
    }

    public ControllerPacmanGame getController(){
        return controller;
    }

    public void update(Observable obs) {
        // Les deux notations sont equivalentes PacmanGame currentGame = (PacmanGame) obs;
        PacmanGame currentGame = controller.getGame();
        ArrayList<PositionAgent> positionGhost = new ArrayList<PositionAgent>();
        ArrayList<PositionAgent> positionPacmans = new ArrayList<PositionAgent>();
               
        positionPacmans.add(currentGame.getPacmans().get(0).getPosition());
        for (Ghost g : currentGame.getGhosts()) positionGhost.add(g.getPosition());
        
        view.setGhosts_pos(positionGhost);
        view.setPacmans_pos(positionPacmans);

        view.repaint();
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
        window.setLocationRelativeTo(null);
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
        view = new PanelPacmanGame(maze);
        window.add(view);
        window.setVisible(true);

        /********** Fin Creation de l'interface graphique ***********/

    }

    
}
