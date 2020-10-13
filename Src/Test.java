
public class Test {

    public static void main(String[] args) {
     
      ViewSimpleGame game = new ViewSimpleGame();
      ViewCommand command = new ViewCommand();
      try{
        Maze labyrinthe = new Maze("Layouts/bigCorners.lay");
        ViewPacmanGame pacman = new ViewPacmanGame(labyrinthe);

      }
      catch(Exception e){
          System.out.println("Il y'a une erreur du type : "+ e.getMessage());
      }
    }
}
