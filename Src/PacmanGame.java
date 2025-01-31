
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import java.awt.event.ActionListener;
import javax.swing.Timer;

//import jdk.internal.agent.resources.agent;

public class PacmanGame extends Game {
    private Maze map;

    private ArrayList<Pacman> pacmans;
    private ArrayList<Ghost> ghosts;
    private String pacmanStrategy;
    private String ghostStrategy;
    private int nbVie;
    private ArrayList<PositionAgent> startPacmans ;
    private ArrayList<PositionAgent> startGhosts ;


    public PacmanGame() {
        pacmans = new ArrayList<Pacman>();
        ghosts = new ArrayList<Ghost>();
        startPacmans = new ArrayList<PositionAgent>();
        startGhosts = new ArrayList<PositionAgent>();

        try {
            String fileName = "originalCLassic_food_fivePAcman.lay";
            map = new Maze("Layouts/" + fileName);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void setMaze(String fileName){
        try {
            map = new Maze("Layouts/" + fileName);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    public void setPacmanStrategy(String strat){
        pacmanStrategy=strat;
    }
    public void setGhostStrategy(String strat){
        ghostStrategy=strat;
    }
    public void initialiseGame() {
        for (int i = 0; i < map.getInitNumberOfPacmans(); i++){
            pacmans.add(new Pacman(map.getPacman_start().get(i),pacmanStrategy));
            startPacmans.add(new PositionAgent(pacmans.get(i).getPosition().getX(),pacmans.get(i).getPosition().getY()));
        }
        
        for (int i = 0; i < map.getInitNumberOfGhosts(); i++){
            ghosts.add(new Ghost(map.getGhosts_start().get(i),ghostStrategy));
            startGhosts.add(new PositionAgent(ghosts.get(i).getPosition().getX(),ghosts.get(i).getPosition().getY()));
        }
        
        this.setTurn(0);
        this.setRunning(true);
        this.setTime(800);
        nbVie = pacmans.size();
    }


    public void takeTurn() {
        for (Ghost g : ghosts) {
            boolean move = false;
            while (!move) {
                AgentAction action = g.getStrategie().getAction(this, g);
                if (isLegalMove(g, action)) {
                    moveAgent(g, action);
                    move = true;
                }
            }
        }
        //affichage pour débugger les fantômes 
        System.out.println("ghosts: "+getGhosts());
        System.out.println("pacmans: "+getPacmans());

        Agent pacman = getPacmans().get(0);
        AgentAction action = pacman.getStrategie().getAction(this, pacman);
        if (isLegalMove(pacman, action)) {
            moveAgent(pacman, action);
        }
        setTurn(getTurn()+1);
        this.notifyObservers();
    }

    public boolean gameContinue() {
       // return nbVie >= 1 && isRunning() && ghosts.size() >=1 ? true : false;
       return nbVie >= 1 && ghosts.size() >=1 ? true : false;
    }

    public void gameOver() {
        if(!gameContinue()) {
            System.out.println("Game fini !!");
        }
    }

    public Maze getMaze() {
        return map;
    }

    public boolean isLegalMove(Agent agent, AgentAction action) {
        PositionAgent position = agent.getPosition();
        return !map.isWall(position.getX() + action.get_vx(), position.getY() + action.get_vy())
                || map.isFood(position.getX() + action.get_vx(), position.getY() + action.get_vy())
                || map.isCapsule(position.getX() + action.get_vx(), position.getY() + action.get_vy()) ? true : false;
    }

    public void moveAgent(Agent agent, AgentAction action) {
        if (isLegalMove(agent, action)) { 
            agent.getPosition().setX(agent.getPosition().getX() + action.get_vx());
            agent.getPosition().setY(agent.getPosition().getY() + action.get_vy());
            
            if (agent instanceof Pacman) { 
                agent.getPosition().setDir(action.get_direction());

                if (map.isFood(agent.getPosition().getX(), agent.getPosition().getY())) {
                    map.setFood(agent.getPosition().getX(), agent.getPosition().getY(), false); 
                } else if (map.isCapsule(agent.getPosition().getX(), agent.getPosition().getY())) {
                    map.setCapsule(agent.getPosition().getX(), agent.getPosition().getY(), false); 
                    Timer timer = new Timer(2000,new ActionListener(){ 
                        int i = 5;
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(i < 1){
                                changementAgentsComportement(false);
                               ((Timer)e.getSource()).stop();
                            }
                            i--;
                        }
                    });
                    changementAgentsComportement(true);
                    timer.start();
                }
                agentDead();
            }
            else{
                agentDead(); 
            }
        }
            //setTurn(getTurn() + 1); // réalisé 1 fois pour chaque fantôme, donc un tour augmenterait de 4 le nombre de tours.
            this.notifyObservers(); 
    }

    protected void restartGame(){
        // si le nombre de vies est supérieur à 0, on re-place TOUS les pacmans et les ghosts à leurs points de départ.
        if(nbVie>0){
            for(int i=0; i < startPacmans.size() ; i++)
            {
                pacmans.get(i).setPosition(startPacmans.get(i));

            }
            for(int i=0; i < startGhosts.size() ; i++)
            {
                ghosts.get(i).setPosition(startGhosts.get(i));
            }
        }
        //sinon, la partie est terminée.
        else gameOver();
 
    }

    public void agentDead()
    {
            ArrayList<Ghost> delGhost = new ArrayList<>();
            for(Ghost g : ghosts){
                if(g.getPosition().equals(pacmans.get(0).getPosition())){
                    if(g.isScared()){
                        delGhost.add(g);
                    }
                    else {
                        nbVie--;
                        restartGame();
                    }
                }
            }
                ghosts.removeAll(delGhost);

    }
    
    public void changementAgentsComportement(boolean b)
    {
        for(Ghost g : ghosts){
            g.changecomportement(b);
        }
        for(Pacman p : pacmans){
            p.changecomportement(b);
        }
    }

    // Getters and Setters
    public Maze getMap() { return map;}
    public void setMap(Maze map) { this.map = map; }
    public ArrayList<Pacman> getPacmans() { return pacmans; }
    public void setPacmans(ArrayList<Pacman> pacmans) {  this.pacmans = pacmans; }
    public ArrayList<Ghost> getGhosts() { return ghosts; }
    public void setGhosts(ArrayList<Ghost> ghosts) { this.ghosts = ghosts;}
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
