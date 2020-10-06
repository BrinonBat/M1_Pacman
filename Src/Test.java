
public class Test {

    public static void main(String[] args) {
      
      try{
        Maze labyrinthe = new Maze("Layouts/bigCorners.lay");
        PanelPacmanGame pacmanGame = new PanelPacmanGame(labyrinthe);
        SimpleGame pacman = new SimpleGame();
        ControllerSimpleGame control = new ControllerSimpleGame(pacman);
      }
      catch(Exception e){
          System.out.println("Il y'a une erreur du type : "+ e.getMessage());
      }
    }
}
