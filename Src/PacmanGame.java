
import java.util.ArrayList;
import java.util.Random;

public class PacmanGame extends Game {
    private Maze map;
    // le prof à dit qu'il valait mieux faire deux listes
    private ArrayList<Pacman> pacmans;
    private ArrayList<Ghost> ghosts;
    private int nbVie;

    // Initalise les données du PacmanGame
    public PacmanGame() {
        pacmans = new ArrayList<Pacman>();
        ghosts = new ArrayList<Ghost>();
        try {
            String nomFichier = "originalCLassic_food_fivePAcman.lay";
            map = new Maze("Layouts/"+nomFichier);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    // Place les pacmans et les fantomes sur le terrain
    public void initialiseGame() {
        for (int i = 0; i < map.getInitNumberOfPacmans(); i++) 
            pacmans.add(new Pacman(map.getPacman_start().get(i)));
        
        for (int i = 0; i < map.getInitNumberOfGhosts(); i++) 
            ghosts.add(new Ghost(map.getGhosts_start().get(i)));
        


        this.setTurn(0);
        this.setRunning(true);
        this.setTime(800);
        nbVie = pacmans.size();
    }
    public void takeTurn() {
            System.out.println("Tours " + getTurn() + " en cours ...");  
            for(Ghost g : ghosts){
                boolean move = false;
                while(!move){
                    AgentAction action = g.getStrategie().getAction(this.map, g);
                    if(isLegalMove(g,action )){
                        moveAgent(g, action);
                        move = true;
                    }
                }
            }  
    }
    public boolean gameContinue() {
        return nbVie >= 1 && isRunning() ? true:false;
    }
    public void gameOver() {
        System.out.println("Le jeu est fini !!! ");
    }
    public Maze getMaze() {
        return map;
    }
    public boolean isLegalMove(Agent agent,AgentAction action){
        PositionAgent position = agent.getPosition();
        return !map.isWall(position.getX()+action.get_vx(),position.getY()+action.get_vy()) 
        || map.isFood(position.getX()+action.get_vx() ,position.getY()+action.get_vy()) 
        || map.isCapsule(position.getX()+action.get_vx() ,position.getY()+action.get_vy()) ? true:false; 
    }
    public void moveAgent(Agent agent,AgentAction action){
        if(isLegalMove(agent, action)){
            agent.getPosition().setX(agent.getPosition().getX()+action.get_vx());
            agent.getPosition().setY(agent.getPosition().getY()+action.get_vy());
            agent.getPosition().setDir(action.get_direction());
            if(map.isFood(agent.getPosition().getX(),agent.getPosition().getY()) && agent instanceof Pacman)
            {
                map.setFood(agent.getPosition().getX(), agent.getPosition().getY(), false);
            }
            else if(map.isCapsule(agent.getPosition().getX(),agent.getPosition().getY()) && agent instanceof Pacman)
            {
                System.out.println("J'ai mangé une capsule");
            }
            else if(agent instanceof Ghost){

            }
            setTurn(getTurn() + 1);
            this.notifyObservers();
        }
    }
    // Getter and Setter
    public Maze getMap() {
        return map;
    }
    public void setMap(Maze map) {
        this.map = map;
    }
    public ArrayList<Pacman> getPacmans() {
        return pacmans;
    }
    public void setPacmans(ArrayList<Pacman> pacmans) {
        this.pacmans = pacmans;
    }
    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }
    public void setGhosts(ArrayList<Ghost> ghosts) {
        this.ghosts = ghosts;
    }
    public int getVie() { return nbVie ;} 
    public void setVie(int v) { nbVie = v;}   
    public String toString() {
        String s = "Maze\n";
        s += "\nPosition agents pacman :";
        for (Pacman pa : pacmans) {
            s += pa.getPosition() + " ";
        }
        for (Ghost gs : ghosts) {
            s += gs.getPosition() + " ";
        }
        return s;
    }

}
