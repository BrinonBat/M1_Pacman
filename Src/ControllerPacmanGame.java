import javax.swing.JFrame;

public class ControllerPacmanGame implements InterfaceControleur {
   
    private PacmanGame game;

    //constructeur
    public ControllerPacmanGame (PacmanGame game){
        this.game = game;
    }

    // initialise et affiche le jeu sans le démarrer
    public void start(){
        game.initialiseGame();  
        ViewPacmanGame pacman = new ViewPacmanGame(game.getMap(),this);
    } 

    // lance la partie
    public void run(){
        game.lauch();
    }

    public void pause(){
        game.pause();
    }
    public void setTime(long time){
        game.setTime(time);
    }
    public PacmanGame getGame(){
        return game;
    }
    public void setGame(PacmanGame game) {
        this.game = game;
    } 
}
