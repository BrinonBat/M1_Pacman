import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ViewCommand extends JFrame {

    public ViewCommand(){
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Command");
        jFrame.setSize(new Dimension(700, 700));
        

        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int height = tailleEcran.height;
        int width = tailleEcran.width;

        jFrame.setSize(width/2 , height/2);
        jFrame.setLocationRelativeTo(null);
      

        jFrame.setVisible(true);
    }

}
