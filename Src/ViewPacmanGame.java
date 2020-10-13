import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ViewPacmanGame implements Observer {

    ViewPacmanGame(Maze maze)
    {
        PanelPacmanGame pacmangame = new PanelPacmanGame(maze);

        JFrame window = new JFrame();
        window.setTitle("Pacman");

        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int height = tailleEcran.height;
        int width = tailleEcran.width;

        window.setSize(width/2 , height/2);
        window.setLocationRelativeTo(null);

        window.add(pacmangame);

        window.setVisible(true);
    }

    public void actualise(){
        
    }

    
}
