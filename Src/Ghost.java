public class Ghost extends Agent {
    
    public Ghost(PositionAgent pos) {
        super(pos,false);
        setStrategie(new StrategieGhost2());
    }

    @Override
    public void changecomportement(boolean CapsuleBehaviour) {
        setScared(!isScared());
        if(isScared()){
            setStrategie(new StrategieRand());
        }
        else{ 
             setStrategie(new StrategieRand());
        }
    }

    
    
}
