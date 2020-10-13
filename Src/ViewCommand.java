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
import javax.swing.JLabel;

import java.awt.GridLayout;

public class ViewCommand extends JFrame implements Observer {

    public ViewCommand(){
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Command");
        jFrame.setSize(new Dimension(700, 700));
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int height = tailleEcran.height;
        int width = tailleEcran.width;
        jFrame.setSize(width/2 , height/2);
        jFrame.setLocationRelativeTo(null);


        /***Composant de la window */

        GridLayout conteneur = new GridLayout(2,2);
        jFrame.setLayout(conteneur);


        JPanel buttonHaut = new JPanel(new GridLayout(1,4));
        JPanel buttonBas = new JPanel(new GridLayout(1,2));
        JPanel contbuttonBas = new JPanel(new GridLayout(2,1));


        buttonHaut.add(new JButton("", new ImageIcon("icones/icon_restart.png")));
        buttonHaut.add(new JButton("", new ImageIcon("icones/icon_run.png")));
        buttonHaut.add(new JButton("", new ImageIcon("icones/icon_step.png")));
        buttonHaut.add(new JButton("", new ImageIcon("icones/icon_pause.png")));

        JLabel titreSlide = new JLabel("Number of turn per secondes ");
        titreSlide.setHorizontalAlignment(JLabel.CENTER);
        JSlider slider = new JSlider(1,10,5);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        contbuttonBas.add(titreSlide);
        contbuttonBas.add(slider);

        buttonBas.add(contbuttonBas);
        buttonBas.add(new JLabel("Turn  :", JLabel.CENTER));

        jFrame.add(buttonHaut);
        jFrame.add(buttonBas);


        jFrame.setVisible(true);
    }

    public void actualise(){
        
    }

}
