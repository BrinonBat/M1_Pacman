public class StrategieRand implements Strategie {
  
    public StrategieRand() {
    }

    @Override
    public AgentAction getAction(Maze Labyrinthe, Agent agent) {
        int i = 0 + (int)(Math.random() * ((3 - 0) + 1));
        return new AgentAction(i);
    }

 
}
