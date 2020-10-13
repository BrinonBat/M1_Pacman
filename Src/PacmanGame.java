
import java.util.ArrayList;

public class PacmanGame extends Game{

    private Maze map;
    private ArrayList<Agent> agents;

    public PacmanGame()
    {
        agents = new ArrayList<Agent>();
        try{
            map = new Maze("Layouts/bigCorners.lay");
            
        }catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        
    }

    public void initialiseGame() {
      
       for(int i = 0; i< map.getInitNumberOfPacmans(); i++){
        agents.add(new Pacman(map.getPacman_start().get(i)));
        }
        for(int i = 0; i< map.getInitNumberOfGhosts(); i++){
        agents.add(new Fantome(map.getGhosts_start().get(i)));
        }
        ViewPacmanGame pacman = new ViewPacmanGame(map);
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
