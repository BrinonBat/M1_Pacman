import java.util.ArrayList;

public class StrategieGhost implements Strategie {

    @Override
    public AgentAction getAction(Maze labyrinthe, Agent agent) {
      PanelPacmanGame panelPacman = new PanelPacmanGame(labyrinthe);
      ArrayList<PositionAgent> pos_pacmans = panelPacman.getPacmans_pos();
      PositionAgent currentPacman = pos_pacmans.get(0);

     // int posHorizontal = currentPacman.getX() - agent.getPosition().getX() ;
      //int posVertical = currentPacman.getY() - agent.getPosition().getY();

      int i = 1 + (int)(Math.random() * ((2 - 1) + 1));
      AgentAction move = new AgentAction(5);

      switch(i)
      {
        case 1 :{
          if(currentPacman.getX() < agent.getPosition().getX())
            move.set_direction(AgentAction.WEST);
          else 
            move.set_direction(AgentAction.EAST);
          }
        case 2:{
          if(currentPacman.getY() < agent.getPosition().getY())
           move.set_direction(AgentAction.SOUTH);
          else
            move.set_direction(AgentAction.NORTH);
        }
      }
      return move;
    }


    protected int shortestway(Agent p,Agent pacmanPos,Maze labyrinthe)
    {
        if(p.getPosition().equals(pacmanPos.getPosition()))
          return shortestway(p, pacmanPos, labyrinthe);
        else{


          return shortestway(p, pacmanPos, labyrinthe);
        }
        
    }

  
}
