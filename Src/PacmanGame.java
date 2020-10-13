
import java.util.ArrayList;

public class PacmanGame extends Game{

    private Maze map;
    //le prof à dit qu'il valait mieux faire deux listes
    private ArrayList<Pacman> pacmans;
    private ArrayList<Ghost> ghosts;
    public PacmanGame()
    {
        pacmans= new ArrayList<Pacman>();
        ghosts= new ArrayList<Ghost>();
        try{
            map = new Maze("Layouts/bigCorners.lay");
            
        }catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        
    }

    public void initialiseGame() {
      
       for(int i = 0; i< map.getInitNumberOfPacmans(); i++){
        pacmans.add(new Pacman(map.getPacman_start().get(i)));
        }
        for(int i = 0; i< map.getInitNumberOfGhosts(); i++){
        ghosts.add(new Ghost(map.getGhosts_start().get(i)));
        }
        ViewPacmanGame pacman = new ViewPacmanGame(map);
        addObserver(pacman);
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
