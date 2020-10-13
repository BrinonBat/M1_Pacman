
import java.util.ArrayList;

public class PacmanGame extends Game implements Observable{

    private Maze map;
    private ArrayList<Agent> agents;

    public void initialiseGame() {
        for(int i = 0; i< map.getInitNumberOfPacmans(); i++){
            agents.add(map.getPacman_start().get(i));
            addObserver(agents.get(i));
        }
    }

    public void takeTurn() {
        System.out.println("Tours " + getTurn() + " en cours ...");
    }

    public boolean gameContinue() {
        return true;
    }

    public void gameOver() {
        System.out.println("Le jeu est fini !!! ");
    }
}
