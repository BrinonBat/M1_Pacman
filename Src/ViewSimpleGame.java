import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ViewSimpleGame {

	public ViewSimpleGame() {
            JFrame window = new JFrame();
            window.setTitle("Game");

            Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
            int height = tailleEcran.height;
            int width = tailleEcran.width;

            window.setSize(width/2 , height/2);
            window.setLocationRelativeTo(null);

            window.setVisible(true);
        
	}
    
}
