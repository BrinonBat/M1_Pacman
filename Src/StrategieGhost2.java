import java.io.Console;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.text.StyledEditorKit.BoldAction;


public class StrategieGhost2 implements Strategie {

    static class node{
        protected double cout;
        protected double coutEstime ;        
        protected PositionAgent position;
        protected node parent;
    }

    @Override
    public AgentAction getAction(PacmanGame game, Agent agent) {
        PositionAgent pacmanpos = game.getPacmans().get(0).getPosition();
        node start = new node();
        start.cout = 0;
        start.coutEstime = heuristique(agent.getPosition(), pacmanpos);
        start.position = agent.getPosition();
        start.parent = null;
        ArrayList<node> liste= Astars(game, agent, pacmanpos ,start);
    
        int fin = liste.size()-1;
        PositionAgent pos = new PositionAgent(liste.get(fin).position.getX(), liste.get(fin).position.getY());
        int coupajouer= 0;

        for(int i=0; i < 4;i++){
                AgentAction action = new AgentAction(i);
                PositionAgent nextpos = new PositionAgent(agent.getPosition().getX() + action.get_vx(), agent.getPosition().getY() + action.get_vy());
                if( nextpos.equals(pos)) coupajouer =  i;
        }
                
            
        return new AgentAction(coupajouer);
        
    }


    public ArrayList<node> Astars(PacmanGame game, Agent agent,PositionAgent pacmanpos, node start){
        ArrayList<node> close = new ArrayList<node>();
        ArrayList<node> open = new ArrayList<node>();
        open.add(start);

        while(open.size() > 0){
            node node = open.get(0);
            open.remove(0);

            if(node.position.equals(pacmanpos) ){
                return pathToGoal(node);
            }

            ArrayList<node> childs = getSuccessors(game, agent, node);
            for(int i=0 ; i < childs.size() ; i++){
                node child = childs.get(i);

                boolean isOpen = contains(open,child);
                boolean isClosed = contains(close,child);


                double costFromStart = node.cout + getCost(node,child);
                
                if( (!isOpen && !isClosed) || costFromStart < child.cout){
                    child.cout = costFromStart;
                    child.coutEstime = heuristique(child.position,game.getPacmans().get(0).getPosition());
                    open.add(child);
                }
            }
            close.add(node);
        }
        

        return null;
    }

    public boolean contains(ArrayList<node> liste,node n)
    {
        for(int i=0; i < liste.size() ; i++){
            if(liste.get(i).position.equals(n.position) )
                return true;
        }
        return false;
    }

    public ArrayList<node> getSuccessors(PacmanGame game,Agent agent,node n)
    {
       ArrayList<node> successors = new ArrayList<node>();
       for(int i = 0 ; i < 4 ; i++){
            AgentAction action = new AgentAction(i);
            Ghost ghost = new Ghost(n.position,"A*");
            if( game.isLegalMove(ghost, action) ) {
                PositionAgent position = new PositionAgent(ghost.getPosition().getX() + action.get_vx(), ghost.getPosition().getY() + action.get_vy());
                node child = new node();
                child.position = position;
                child.parent = n;
                successors.add(child);
            }
        }
        return successors;
    }


    public ArrayList<node> pathToGoal(node node)
    {
        ArrayList<node> path = new ArrayList<node>();
        while(node.parent != null){
            path.add(node);
            node = node.parent;
        }
        return path;
    }

    public double getCost(node n){
        return n.cout + n.coutEstime ; 
    }

    public double getCost(node n1,node n2){
        return Math.sqrt(Math.pow((n2.position.getX() - n1.position.getX()),2)  + Math.pow((n2.position.getY() - n1.position.getY()),2)) ;    }


    public double heuristique(PositionAgent ghost, PositionAgent pacman){

        return Math.sqrt(Math.pow((pacman.getX() - ghost.getX()),2)   + Math.pow(pacman.getY() - ghost.getY(),2)) ;
    }


    
}
