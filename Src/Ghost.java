public class Ghost extends Agent{
    
    public Ghost(PositionAgent pos)
    {
        super(pos);
        setStrategie(new StrategieRand());
    }
}
