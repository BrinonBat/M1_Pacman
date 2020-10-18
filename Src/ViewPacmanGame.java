import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class ViewPacmanGame implements Observer {

    private JFrame window ;
    private ControllerPacmanGame controller;
    private PanelPacmanGame view;


    ViewPacmanGame(Maze maze)
    {
        /**********Creation de l'interface graphique  ***********/
        window = new JFrame();
        window.setTitle("Pacman");
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int height = tailleEcran.height;
        int width = tailleEcran.width;

        window.setSize(width/2 , height/2);
        window.setLocationRelativeTo(null);

        view = new PanelPacmanGame(maze);
        window.add(view);

        window.setVisible(true);
        /**********Fin Creation de l'interface graphique  ***********/

        System.out.println(maze.toString());

    }
    
    public void update(Observable obs){
        System.out.println("Refreshing page...");
        PacmanGame currentGame = (PacmanGame)obs;
        Maze map = currentGame.getMaze();
        ArrayList<PositionAgent> positionPacmans = new ArrayList<PositionAgent>();
        for( Pacman p : currentGame.getPacmans())
        {
            positionPacmans.add(p.getPosition());
        }
        map.setPacman_start(positionPacmans);
        System.out.println(map.toString());
        view = new PanelPacmanGame(map);
        window.add(view);
        window.setVisible(true);


    }

    
}
