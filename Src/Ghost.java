public class Ghost extends Agent {
    private boolean scared = false;
    
    //constructeur
    public Ghost(PositionAgent pos) {
        super(pos);
        setStrategie(new StrategieGhost());
    }

    @Override
    public void changecomportement(boolean CapsuleBehaviour) {
        scared  = CapsuleBehaviour;
        if(CapsuleBehaviour){
            System.out.println("J'ai peur du pacman") ;
            setStrategie(new StrategieGhostAffraid());
        }
        else{ 
             System.out.println("Je n'ai plus peur du pacman") ;
             setStrategie(new StrategieGhost());
        }
    }

    public boolean isScared() {
        return scared;
    }

    public void setScared(boolean scared) {
        this.scared = scared;
    }

    
}
