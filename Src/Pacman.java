import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Pacman extends Agent {

    public Pacman(PositionAgent pos) {
        super(pos,true);
        setStrategie(new StrategiePacmanAstars());
    }

    @Override
    public void changecomportement(boolean CapsuleBehaviour) {
        setScared(!isScared());
        if(isScared()){
            System.out.println("J'ai peur des fantomes");
        }
        else{ 
            System.out.println("J'ai pas peur des fantomes");
        }
    }    
    
}
