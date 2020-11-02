import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Pacman extends Agent {

    public Pacman(PositionAgent pos) {
        super(pos);
    }

    @Override
    public ActionListener changecomportement() {
        return new ActionListener(){
            int i = 5;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i < 1){
                    System.out.println("Le pacman ne peut plus manger les fantomes");
                   ((Timer)e.getSource()).stop();
                }
                i--;
            }
        };
    }
    
}
