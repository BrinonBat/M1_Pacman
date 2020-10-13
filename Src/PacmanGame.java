
import java.util.ArrayList;

public class PacmanGame extends Game{

    private Maze map;
    private ArrayList<Agent> agents;

    public void initialiseGame() {
        for(int i = 0; i< map.getInitNumberOfPacmans(); i++){
            agents.add(new Agent(map.getPacman_start().get(i),true));
        }
        for(int i = 0; i< map.getInitNumberOfGhosts(); i++){
            agents.add(new Agent(map.getGhosts_start().get(i),false));
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
