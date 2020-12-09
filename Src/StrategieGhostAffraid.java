import java.util.ArrayList;

public class StrategieGhostAffraid implements Strategie {

    @Override
    public AgentAction getAction(PacmanGame game, Agent agent) {
      return new AgentAction(longestway(game, agent));
    }

    public int longestway(PacmanGame game , Agent agent){
      PositionAgent pacman = game.getPacmans().get(0).getPosition();
      ArrayList<PositionAgent> posPosible = new ArrayList<>();
      
      

      return 1;
    }

}
