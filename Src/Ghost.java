public class Ghost extends Agent {
    
    public Ghost(PositionAgent pos) {
        super(pos,false);
        setStrategie(new StrategieGhost2());
    }

    @Override
    public void changecomportement(boolean CapsuleBehaviour) {
        setScared(CapsuleBehaviour);
        if(isScared()){
            setStrategie(new StrategieGhostAffraid());
        }
        else{ 
             setStrategie(new StrategieGhost2());
        }
    }

    
    
}
