
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import java.awt.event.ActionListener;
import javax.swing.Timer;

//import jdk.internal.agent.resources.agent;

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
            map = new Maze("Layouts/" + nomFichier);
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
        for (Ghost g : ghosts) {
            boolean move = false;
            while (!move) {
                AgentAction action = g.getStrategie().getAction(this.map, g);
                if (isLegalMove(g, action)) {
                    moveAgent(g, action);
                    move = true;
                }
            }
        }
    }

    public boolean gameContinue() {
        return nbVie >= 1 && isRunning() && ghosts.size() >=1 ? true : false;
    }

    public void gameOver() {
        if(!gameContinue()) {
            System.out.println("Game fini !!");
        }
    }

    public Maze getMaze() {
        return map;
    }

    // verifie si le mouvement est possible pour l'agent pris en paramètre
    public boolean isLegalMove(Agent agent, AgentAction action) {
        PositionAgent position = agent.getPosition();
        return !map.isWall(position.getX() + action.get_vx(), position.getY() + action.get_vy())
                || map.isFood(position.getX() + action.get_vx(), position.getY() + action.get_vy())
                || map.isCapsule(position.getX() + action.get_vx(), position.getY() + action.get_vy()) ? true : false;
    }

    // déplace l'agent pris en paramètre
    public void moveAgent(Agent agent, AgentAction action) {
        if (isLegalMove(agent, action)) { // vérifie que le mouvement est légal
            agent.getPosition().setX(agent.getPosition().getX() + action.get_vx());
            agent.getPosition().setY(agent.getPosition().getY() + action.get_vy());

            // s'il s'agit d'un pacman
            if (agent instanceof Pacman) { 
                agent.getPosition().setDir(action.get_direction());

                //s'il mange une food
                if (map.isFood(agent.getPosition().getX(), agent.getPosition().getY())) {
                    map.setFood(agent.getPosition().getX(), agent.getPosition().getY(), false); // retire la food du terrain
                
                //s'il mange une capsule
                } else if (map.isCapsule(agent.getPosition().getX(), agent.getPosition().getY())) {
                    map.setCapsule(agent.getPosition().getX(), agent.getPosition().getY(), false); // retire la capsule du terrain

                    // lance le timer d'invulnerabilité
                    Timer timer = new Timer(1000,new ActionListener(){ 
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
            
                // cas où le Pacman est sur un fantôme
                ghostDead();
                }
            }
            // s'il s'agit d'un fantôme
            else{
                ghostDead();   
            }
            setTurn(getTurn() + 1); // incrémente le nombre de tour
            this.notifyObservers(); // mets à jour l'affichage
    }

    public boolean ghostDead()
    {
        ArrayList<Ghost> delGhost = new ArrayList<>();
        for(Ghost g : ghosts){
            if(g.getPosition().equals(pacmans.get(0).getPosition())){
                if(g.isScared()){
                    delGhost.add(g);
                }else
                {
                    nbVie--;
                    return false;
                }
            }
        }
        ghosts.removeAll(delGhost);
        return true;
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
