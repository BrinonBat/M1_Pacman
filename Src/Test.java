
public class Test {

    public static void main(String[] args) {
      PacmanGame game = new PacmanGame();
      ViewCommand view = new ViewCommand(new ControllerPacmanGame(game));
      
    }
}
