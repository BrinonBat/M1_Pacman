import javax.swing.JFrame;

public class ControllerPacmanGame implements InterfaceController {
   
    private Game game;

    public ControllerPacmanGame (Game game){
        this.game = game;
    }

    public void start(){

        try
        {
            game.init();
        }
        catch(Exception e)
        {
            System.out.println("Problème dans la methode start ");
        }
        
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
