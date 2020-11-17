import java.util.ArrayList;

public class StrategieGhost implements Strategie {

  @Override
  public AgentAction getAction(PacmanGame jeu, Agent agent) {
    //PanelPacmanGame panelPacman = new PanelPacmanGame(labyrinthe);
    //ArrayList<PositionAgent> pos_pacmans = jeu.getMap().getPacmans_pos();
    //PositionAgent currentPacman = pos_pacmans.get(0);

    // int posHorizontal = currentPacman.getX() - agent.getPosition().getX() ;
    //int posVertical = currentPacman.getY() - agent.getPosition().getY();

    int i = 1 + (int)(Math.random() * ((2 - 1) + 1));
    AgentAction move = new AgentAction(5);

  
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
