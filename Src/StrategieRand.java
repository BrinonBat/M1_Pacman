public class StrategieRand implements Strategie {

    @Override
    public AgentAction getAction(Maze labyrinthe, Agent agent) {
        int i = 0 + (int)(Math.random() * ((3 - 0) + 1));
        return new AgentAction(i);
    }

}
