public class StrategieRandom implements Strategie {
    private PacmanGame game;
    
    public StrategieRandom(PacmanGame game) {
        this.game = game;
    }
    @Override
    public void run() {
        Maze map = game.getMap();
        for (Ghost g : game.getGhosts()) {
                PositionAgent position = g.getPosition();
                if (!map.isWall(position.getX() + 1, position.getY())) {
                    position.setX(position.getX() + 1);
                    g.setPosition(position);
                    g.setAction(AgentAction.EAST);
                } 
                if (!map.isWall(position.getX() - 1, position.getY())) {
                    position.setX(position.getX() - 1);
                    g.setPosition(position);
                    g.setAction(AgentAction.EAST);
                }
                if (!map.isWall(position.getX(), position.getY() + 1)) {
                    position.setY(position.getY() + 1);
                    g.setPosition(position);
                    g.setAction(AgentAction.NORTH);
                }
                if (!map.isWall(position.getX(), position.getY() - 1)) {
                    position.setY(position.getY() - 1);
                    g.setPosition(position);
                    g.setAction(AgentAction.SOUTH);
                }
            }
        }

    
}
