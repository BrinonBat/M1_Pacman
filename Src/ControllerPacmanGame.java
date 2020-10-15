import javax.swing.JFrame;

public class ControllerPacmanGame implements InterfaceControleur {
   
    private Game game;

    public ControllerPacmanGame (Game game){
        this.game = game;
    }

    public void start(){
        System.out.println("je suis dans start");
        game.init();  
    }
    
    public void run(){
        game.run();
    }
    public void pause(){
        game.pause();
    }
    public void setTime(long time){
        game.setTime(time);
    }

    public Game getGame(){
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
