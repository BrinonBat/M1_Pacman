import javax.swing.JFrame;

public class ControllerPacmanGame implements InterfaceControleur {
   
    private PacmanGame game;
    //private Strategie strategie;

    public ControllerPacmanGame (PacmanGame game){
        this.game = game;
        //strategie = new StrategieRandom(game);
    }

    public void start(){
        game.initialiseGame();  
        ViewPacmanGame pacman = new ViewPacmanGame(game.getMap(),this);
        game.addObserver(pacman);
    }
    
    public void run(){
        game.run();
        //strategie.run();
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
