
public class Test {

    public static void main(String[] args) {
     
<<<<<<< HEAD

    //ViewSimpleGame game = new ViewSimpleGame();
    ViewCommand command = new ViewCommand();
   
    try{
      Maze labyrinthe = new Maze("../Layouts/bigCorners.lay");
      PanelPacmanGame pacmanGame = new PanelPacmanGame(labyrinthe);
     }
     catch(Exception e)
     {
         System.out.println("Il y'a une erreur du type : "+ e.getMessage());
     }
}
=======
      ViewSimpleGame game = new ViewSimpleGame();
      ViewCommand command = new ViewCommand();
      try{
        Maze labyrinthe = new Maze("../Layouts/bigCorners.lay");
        PanelPacmanGame pacmanGame = new PanelPacmanGame(labyrinthe);
      }
      catch(Exception e){
          System.out.println("Il y'a une erreur du type : "+ e.getMessage());
      }
    }
>>>>>>> b759844f710172caf44b645f4d625440467c54ff
}
