import javax.swing.JFrame;

public class ControllerPacmanGame implements InterfaceControleur {
   
    private PacmanGame game;

    public ControllerPacmanGame (PacmanGame game){
        this.game = game;
    }

    public void start(){
        game.initialiseGame();  
    }
    
    public void run(){
        game.Agentmove();
        game.notifyObservers();
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
