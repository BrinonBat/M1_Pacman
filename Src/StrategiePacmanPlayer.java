public class StrategiePacmanPlayer implements Strategie{

    @Override
    public AgentAction getAction(PacmanGame game, Agent agent) {
        return new AgentAction(agent.getPosition().getDir());
    }
}
