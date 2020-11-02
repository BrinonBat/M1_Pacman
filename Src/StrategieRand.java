public class StrategieRand implements Strategie {

    public StrategieRand() {
    }

    @Override
    public AgentAction getAction(Maze Labyrinthe, Agent agent) {
       
        return new AgentAction(AgentAction.EAST);
    }
    
}
