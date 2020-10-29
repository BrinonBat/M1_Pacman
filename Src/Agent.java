public abstract class Agent {
    private AgentAction action;
    private PositionAgent position;
   
    Agent(PositionAgent pos){
        position = pos;
        action = new AgentAction(3);
    }

    public AgentAction getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action.set_direction(action);;
    }

    public PositionAgent getPosition() {
        return position;
    }

    public void setPosition(PositionAgent position) {
        this.position = position;
    }

   
}
