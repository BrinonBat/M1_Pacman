import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Pacman extends Agent {

    public Pacman(PositionAgent pos) {
        super(pos);
    }

    @Override
    public void changecomportement(boolean CapsuleBehaviour) {
        if(CapsuleBehaviour)
        System.out.println("Je vais manger des fantomes") ;
        else 
        System.out.println("Je peur des fantomes ") ;
    }
    
    
}
