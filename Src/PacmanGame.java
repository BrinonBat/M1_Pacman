
import java.util.ArrayList;

public class PacmanGame extends Game{

    private Maze map;
    //le prof à dit qu'il valait mieux faire deux listes
    private ArrayList<Pacman> pacmans;
    private ArrayList<Ghost> ghosts;
    
    //Initalise les données du PacmanGame
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

    //Place les pacmans et les fontomes sur le terrain
    public void initialiseGame() {
      
        this.setTurn(0);
        this.setRunning(true);

        for(int i = 0; i< map.getInitNumberOfPacmans(); i++){
        pacmans.add(new Pacman(map.getPacman_start().get(i)));
        }
        for(int i = 0; i< map.getInitNumberOfGhosts(); i++){
        ghosts.add(new Ghost(map.getGhosts_start().get(i)));
        }
        System.out.println("Je vais creer ViewPacman");
        ViewPacmanGame pacman = new ViewPacmanGame(map);
        this.addObserver(pacman);            

    }

    public void takeTurn() {
        System.out.println("Tours " + getTurn() + " en cours ...");
    }

    public boolean gameContinue() {
        return false; // Pourquoi tu retournes falses ?
    }

    public void gameOver() {
        System.out.println("Le jeu est fini !!! ");
    }

    public Maze getMaze(){
        return map;
    }
}
