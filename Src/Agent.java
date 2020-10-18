public abstract class Agent {
    private AgentAction action;
    private PositionAgent position;
   
    Agent(PositionAgent pos){
        position = pos;
        action = new AgentAction(4);
    }

    public AgentAction getAction() {
        return action;
    }

    public void setAction(AgentAction action) {
        this.action = action;
    }

    public PositionAgent getPosition() {
        return position;
    }

    public void setPosition(PositionAgent position) {
        this.position = position;
    }

   
}
