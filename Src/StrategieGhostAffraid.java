import java.util.ArrayList;

public class StrategieGhostAffraid implements Strategie {

    @Override
    public AgentAction getAction(Maze labyrinthe, Agent agent) {
        PanelPacmanGame panelPacman = new PanelPacmanGame(labyrinthe);
        ArrayList<PositionAgent> pos_pacmans = panelPacman.getPacmans_pos();
        PositionAgent currentPacman = pos_pacmans.get(0);
  
        int i = 1 + (int)(Math.random() * ((2 - 1) + 1));
  
        switch(i){
          case 1:{
            if( currentPacman.getX() > agent.getPosition().getX())
              return new AgentAction(AgentAction.WEST);
            else
              return new AgentAction(AgentAction.EAST);
          }
          case 2:{
            if( currentPacman.getY() > agent.getPosition().getY())
                return new AgentAction(AgentAction.SOUTH);
            else
                return new AgentAction(AgentAction.NORTH);
          }
        }
        return null;
    }
    
}
