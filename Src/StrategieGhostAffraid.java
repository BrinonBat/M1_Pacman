import java.util.ArrayList;

public class StrategieGhostAffraid implements Strategie {

    @Override
    public AgentAction getAction(PacmanGame game, Agent agent) {
      return new AgentAction(2);
    }
}
