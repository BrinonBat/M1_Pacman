import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.awt.GridLayout;

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

        GridLayout conteneur = new GridLayout(2,2);
        jFrame.setLayout(conteneur);


        JPanel buttonHaut = new JPanel(new GridLayout(1,4));
        JPanel buttonBas = new JPanel(new GridLayout(1,2));


        buttonHaut.add(new JButton("", new ImageIcon("icones/icon_restart.png")));
        buttonHaut.add(new JButton("", new ImageIcon("icones/icon_run.png")));
        buttonHaut.add(new JButton("", new ImageIcon("icones/icon_step.png")));
        buttonHaut.add(new JButton("", new ImageIcon("icones/icon_pause.png")));

        buttonBas.add(new JSlider(0,10,10));
        buttonBas.add(new JButton("bonjour"));

        jFrame.add(buttonHaut);

        jFrame.add(buttonBas);


        jFrame.setVisible(true);
    }

}
