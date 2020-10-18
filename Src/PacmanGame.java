
import java.util.ArrayList;

public class PacmanGame extends Game {

    private Maze map;
    // le prof à dit qu'il valait mieux faire deux listes
    private ArrayList<Pacman> pacmans;
    private ArrayList<Ghost> ghosts;

    // Initalise les données du PacmanGame
    public PacmanGame() {
        pacmans = new ArrayList<Pacman>();
        ghosts = new ArrayList<Ghost>();
        try {
            map = new Maze("Layouts/bigCorners.lay");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }

    // Place les pacmans et les fontomes sur le terrain
    public void initialiseGame() {
        this.setTurn(0);
        this.setRunning(true);

        for (int i = 0; i < map.getInitNumberOfPacmans(); i++) {
            pacmans.add(new Pacman(map.getPacman_start().get(i)));
        }
        for (int i = 0; i < map.getInitNumberOfGhosts(); i++) {
            ghosts.add(new Ghost(map.getGhosts_start().get(i)));
        }
        ViewPacmanGame pacman = new ViewPacmanGame(map);
        this.addObserver(pacman);
    }

    public void takeTurn() {
        System.out.println("Tours " + getTurn() + " en cours ...");
    }

    public boolean gameContinue() {
        return false;
    }

    public void gameOver() {
        System.out.println("Le jeu est fini !!! ");
    }

    public Maze getMaze() {
        return map;
    }
    //Methode qui fait bouge l'Agent
    @Override
    public void Agentmove() {
        for( Pacman p : pacmans){
            PositionAgent position = p.getPosition();
            if( !map.isWall(position.getX()+1 , position.getY()))
            {
                position.setX(position.getX()+1);
                p.setPosition(position);
                p.getAction().set_direction(AgentAction.WEST);
            }
            else if( !map.isWall(position.getX()-1 , position.getY())){
                position.setX(position.getX()-1);
                p.setPosition(position);
                p.getAction().set_direction(AgentAction.SOUTH);
            }
            else if( !map.isWall(position.getX() , position.getY()+1)){
                position.setY(position.getY()+1);
                p.setPosition(position);
                p.getAction().set_direction(AgentAction.NORTH);

            }
            else if( !map.isWall(position.getX() , position.getY()-1)){
                position.setY(position.getY()-1);
                p.setPosition(position);
                p.getAction().set_direction(AgentAction.EAST);
            }
        }
        setTurn(getTurn()+1);
    }

    //Getter and Setter

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

    public String toString()
    {
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
