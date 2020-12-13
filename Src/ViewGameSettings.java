import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.GridLayout;

public class ViewGameSettings extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton mapButton;
    private JPopupMenu maps;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JButton accept;

    public ViewGameSettings(){
        
        /** création de la fenêtre */
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Settings");
        jFrame.setSize(new Dimension(700, 700));
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        jFrame.setSize(width / 2, height / 2);
        jFrame.setLocation(width/4, height/4);
        System.out.println("test");

        /*** Composants de la window */

        GridLayout conteneur = new GridLayout(2, 2);
        jFrame.setLayout(conteneur);

        JPanel topSide = new JPanel(new GridLayout(1,2));

        //création de la liste des cartes possibles
        maps = new JPopupMenu();
        //actionListener pour le menu
        ActionListener menuListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              System.out.println("Elément de menu [" + event.getActionCommand()
                  + "] utilisé.");
            }
        };

        //récupération de la liste de fichiers et ajout dans le JMenu
        FReader dirReader = new FReader("Layouts/");
        ArrayList<String> files = dirReader.getTitles();
        for(String title : files){
            JMenuItem item=new JMenuItem(title);
            item.addActionListener(menuListener);
            maps.add(item);
        }

        //ajout d'un bouton pour ouvrir le menu
        mapButton = new JButton("select a map");
        mapButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                maps.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        //création de la liste de stratégies
        JPanel panel = new JPanel(new GridLayout(0,1));
        Border border = BorderFactory.createTitledBorder("Ghost Strategy");
        panel.setBorder(border);
        ButtonGroup strategy = new ButtonGroup();
        JRadioButton radio1 = new JRadioButton("Random");
        JRadioButton radio2 = new JRadioButton("A*",true);
        strategy.add(radio1);
        panel.add(radio1);
        strategy.add(radio2);
        panel.add(radio2);

        //création du bouton de validation
        accept = new JButton(" OK ");

        //ajout des écouteurs d'action
        accept.addActionListener(this);
        radio1.addActionListener(this);
        radio2.addActionListener(this);

        //placement sur le JFrame
        topSide.add(panel);
        topSide.add(mapButton);
        jFrame.add(topSide);
        jFrame.add(accept);
        jFrame.setVisible(true);



    }

    

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        System.out.println(source);
        if (source == radio1){
            
        }
        else if (source == radio2) {
            
        }
        else if (source == maps) {
            System.out.println("maps pushed");
        }
        else if( source == accept) {
            System.out.println("accept pushed");
        }
        else System.out.println(" error occured in settings selection");
      
    }
    
}
