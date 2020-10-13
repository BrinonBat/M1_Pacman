public class Agent {
    private AgentAction action;
    private PositionAgent position;
    private boolean isPacman;
    Agent(PositionAgent pos,boolean isPac){
        position=pos;
        action=new AgentAction(4);
        isPacman=isPac;
    }

    public boolean isPacman(){
        return this.isPacman;
    }

}
