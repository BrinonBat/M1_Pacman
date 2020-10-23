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
        this.controller = (ControllerPacmanGame) controller;
        /********** Creation de l'interface graphique ***********/
        window = new JFrame();
        window.setTitle("Pacman");
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int height = tailleEcran.height;
        int width = tailleEcran.width;

        window.setSize(width / 2, height / 2);
        window.setLocationRelativeTo(null);

        view = new PanelPacmanGame(maze);
        window.add(view);
        window.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        getController().getGame().Agentmove(4);
                        break;
                    case KeyEvent.VK_RIGHT:
                         getController().getGame().Agentmove(1);
                        break;
                    case KeyEvent.VK_DOWN:
                         getController().getGame().Agentmove(3);
                        break;
                    case KeyEvent.VK_LEFT:
                        getController().getGame().Agentmove(2);
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }
            
        });

        window.setVisible(true);
        /********** Fin Creation de l'interface graphique ***********/

        System.out.println(maze.toString());

    }

    public ControllerPacmanGame getController(){
        return controller;
    }

    public void update(Observable obs) {
        PacmanGame currentGame = (PacmanGame) obs;
        Maze map = currentGame.getMaze();
        ArrayList<PositionAgent> positionPacmans = new ArrayList<PositionAgent>();
        for (Pacman p : currentGame.getPacmans()) {
            positionPacmans.add(p.getPosition());
        }
        map.setPacman_start(positionPacmans);
        System.out.println(map.toString());
        view = new PanelPacmanGame(map);
        window.add(view);
        window.setVisible(true);

    }

    
}
