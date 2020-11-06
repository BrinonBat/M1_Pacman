public class Ghost extends Agent {

    
    //constructeur
    public Ghost(PositionAgent pos) {
        super(pos);
        setStrategie(new StrategieRand());
    }

    @Override
    public void changecomportement(boolean CapsuleBehaviour) {
        if(CapsuleBehaviour){
            System.out.println("J'ai peur du pacman") ;
        }
        else 
             System.out.println("Je n'ai plus peur du pacman") ;
    }


    
}
