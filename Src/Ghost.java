public class Ghost extends Agent {

    public Ghost(PositionAgent pos) {
        super(pos);
        setStrategie(new StrategieRand());
    }

    @Override
    public void changecomportement(boolean CapsuleBehaviour) {
        if(CapsuleBehaviour){
            System.out.println("J'ai peur du pacman") ;
            setStrategie(new StrategieGhostAffraid());
        }
        else{ 
             System.out.println("Je n'ai plus peur du pacman") ;
             setStrategie(new StrategieGhost());
        }
    }

    
}
