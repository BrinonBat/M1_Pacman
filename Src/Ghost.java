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
            setStrategie(new StrategieGhostAffraid());
        }
        else{ 
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
