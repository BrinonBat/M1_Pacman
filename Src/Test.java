
public class Test {

    public static void main(String[] args) {
      PacmanGame game = new PacmanGame();
      new ViewCommand(new ControllerPacmanGame(game));
      
    }
}