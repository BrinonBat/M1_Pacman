
public abstract class Agent {
    private AgentAction action; // déplacement de l'agent
    private PositionAgent position; // position actuelle de l'agent
    private Strategie strategie; // stratégie appellée pour calculer l'action à effectuer


    //getters & setters
    Agent(PositionAgent pos) {
        position = pos;
        action = new AgentAction(4);
    }

    public AgentAction getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action.set_direction(action);
        ;
    }

    public PositionAgent getPosition() {
        return position;
    }

    public void setPosition(PositionAgent position) {
        this.position = position;
    }

     public Strategie getStrategie() {
         return strategie;
    }

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    } 

    // changement de stratégie si la capsule à été mangée
    public abstract void changecomportement(boolean CapsuleBehaviour);
      
       
}
