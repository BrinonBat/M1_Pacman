public class Ghost extends Agent {
    
    public Ghost(PositionAgent pos,String strat) {
        super(pos,false);
        switch(strat){
            case("A*"): setStrategie(new StrategieGhost2()); break;
            case("random"): setStrategie(new StrategieRand()); break;
            default: {
                System.out.println(" erreur lors de la saisie de la stratégie "+strat);
                setStrategie(new StrategieRand()); 
            }
        }
        
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
