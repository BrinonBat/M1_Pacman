import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;


public class Ghost extends Agent {

    public Ghost(PositionAgent pos) {
        super(pos);
        setStrategie(new StrategieRand());
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
