import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ViewPacmanGame implements Observer {

    private JFrame window ;
    private ControllerPacmanGame controller;
    //private JPanel controlePanel;


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

        PanelPacmanGame view = new PanelPacmanGame(maze);
        window.add(view);

        window.setVisible(true);
        /**********Fin Creation de l'interface graphique  ***********/

    }
    
    public void update(Observable obs){
        PacmanGame game = (PacmanGame)obs;
        //Update du game
        controller.setGame(game);
    }

    
}
