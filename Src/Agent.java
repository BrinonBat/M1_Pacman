
public abstract class Agent {
    private AgentAction action; // déplacement de l'agent
    private PositionAgent position; // position actuelle de l'agent
    private Strategie strategie; // stratégie appellée pour calculer l'action à effectuer
    private boolean scared ;
    //getters & setters
    Agent(PositionAgent pos,boolean scared) {
        position = pos;
        this.scared = scared;
        action = new AgentAction(4);
    }

    public AgentAction getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action.set_direction(action);
    }

    public PositionAgent getPosition() {
        return position;
    }

    public void setPosition(PositionAgent position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

     public Strategie getStrategie() {
         return strategie;
    }

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    } 

    public boolean isScared() {
        return scared;
    }

    public void setScared(boolean scared) {
        this.scared = scared;
    }


    // changement de stratégie si la capsule à été mangée
    public abstract void changecomportement(boolean CapsuleBehaviour);
      
       
}
