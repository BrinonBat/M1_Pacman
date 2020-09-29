
public class Test {

    public static void main(String[] args) {
     try{
      Maze labyrinthe = new Maze("../Layouts/bigConers.lay");
      PanelPacmanGame pacmanGame = new PanelPacmanGame(labyrinthe);
     }
     catch(Exception e)
     {
         System.out.println("Il y'a une erreur du type : "+ e.getMessage());
     }
    }
}
