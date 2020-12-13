import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Pacman extends Agent {

    public Pacman(PositionAgent pos,String strat) {
        super(pos,true);
        switch(strat){
            case("A*"): setStrategie(new StrategiePacmanAstars()); break;
            case("random"): setStrategie(new StrategieRand()); break;
            default: {
                System.out.println(" erreur lors de la saisie de la stratégie");
                setStrategie(new StrategieRand()); 
                break;
            }
        }
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
