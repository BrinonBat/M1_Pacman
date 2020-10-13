public class Agent {
    private AgentAction action;
    private PositionAgent position;

    Agent(PositionAgent pos){
        position=pos;
        action=new AgentAction(4);
    }

}
