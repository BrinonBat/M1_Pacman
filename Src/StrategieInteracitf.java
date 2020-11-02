public class StrategieInteracitf implements Strategie {

    @Override
    public AgentAction getAction(Maze Labyrinthe, Agent agent) {
      return new AgentAction(2);
    }   
}
