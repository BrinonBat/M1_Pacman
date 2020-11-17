import java.util.ArrayList;

public class StrategieGhost implements Strategie {

    @Override
    public AgentAction getAction(PacmanGame game, Agent agent) {
      ArrayList<Pacman> pacmans = game.getPacmans();
      ArrayList<Ghost> ghosts = game.getGhosts();
      Pacman currentPacman = pacmans.get(0);
      AgentAction action = new AgentAction(4);

      return action; 
    }


    protected int shortestway(Agent p,Agent pacmanPos,Maze labyrinthe)
    {/*
      int x = labyrinthe.getSizeX();
      int y = labyrinthe.getSizeY();
      double[][] possibleMove = new double[x][y];
      for(int i=0; i < labyrinthe.getSizeY() ; i++)
       {
         for(int j=0;j < labyrinthe.getSizeX() ; j++)
         {
           if(!labyrinthe.isWall(i, j))
           {
             possibleMove[x][y] = -99999;
           }
         }
       }*/
       return 1;
    }

  
    return move;
  }

  // sortie : int compris entre 1 et 4 en fonction du numero du coup à faire.
  protected int shortestway(Agent ghost,Agent pacman,Maze labyrinthe)
  { /*
    int x = labyrinthe.getSizeX();
    int y = labyrinthe.getSizeY();
    double[][] possibleMove = new double[x][y];
    for(int i=0; i < labyrinthe.getSizeY() ; i++){
      for(int j=0;j < labyrinthe.getSizeX() ; j++)
      {
        if(!labyrinthe.isWall(i, j))
        {
          possibleMove[x][y] = -99999;
        }
      }
    }*/

      /* rappel :
        NORTH = 0;
        SOUTH = 1;
        EAST = 2;
        WEST = 3; */
    return 1;
           
  }  

}
