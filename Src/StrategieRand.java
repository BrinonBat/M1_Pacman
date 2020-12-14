public class StrategieRand implements Strategie {

    @Override
    public AgentAction getAction(PacmanGame game, Agent agent) {
        while(true){ // et oui, on aime les prises de risque par ici
            int i = 0 + (int)(Math.random() * ((3 - 0) + 1));
            if(game.isLegalMove(agent,new AgentAction(i))) return new AgentAction(i);
        }
        
    }

}
