public class StrategieGhost implements Strategie {

    @Override
    public AgentAction getAction(Maze labyrinthe, Agent agent) {
      return new AgentAction(2);
    }   
}
