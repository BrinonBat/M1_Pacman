
public class ControllerSimpleGame implements InterfaceController{
   
    private Game game;

    public ControllerSimpleGame (Game game){
        this.game = game;
        ViewPacmanGame gameView = new ViewPacmanGame(maze);
        ViewCommand commandView = new ViewCommand();
    }

    public void start(){
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
}
