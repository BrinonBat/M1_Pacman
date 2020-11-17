import java.util.ArrayList;

public class StrategieGhost implements Strategie {

    @Override
    public AgentAction getAction(Maze labyrinthe, Agent agent) {
      PanelPacmanGame panelPacman = new PanelPacmanGame(labyrinthe);
      ArrayList<PositionAgent> pos_pacmans = panelPacman.getPacmans_pos();
      PositionAgent currentPacman = pos_pacmans.get(0);

     // int posHorizontal = currentPacman.getX() - agent.getPosition().getX() ;
      //int posVertical = currentPacman.getY() - agent.getPosition().getY();

      int i = 1 + (int)(Math.random() * ((2 - 1) + 1));
      AgentAction move = new AgentAction(5);

    
      return move;
    }

    // sortie : int compris entre 1 et 4 en fonction du numero du coup à faire.
    protected int shortestway(Agent ghost,Agent pacmanPos,Maze labyrinthe)
    { /*
      int x = labyrinthe.getSizeX();
      int y = labyrinthe.getSizeY();
      double[][] possibleMove = new double[x][y];
      for(int i=0; i < labyrinthe.getSizeY() ; i++)
       {
         for(int j=0;j < labyrinthe.getSizeX() ; j++)
         {
           if(!labyrinthe.isWall(i, j))
           {
             possibleMove[x][y] = -99999;
           }
         }
       }*/

       /* rappel :
          NORTH = 0;
          SOUTH = 1;
          EAST = 2;
          WEST = 3; */
          int nMov;
       int diffX=ghost.getPosition().getX()-pacmanPos.getPosition().getX();
       int diffY=ghost.getPosition().getY()-pacmanPos.getPosition().getY();
       int direction;
       if (Math.abs(diffX)>Math.abs(diffY) and){
          if(diffX>0){ nMov=cherche_chemin(3,ghost.getPosition(),pacmanPos.getPosition(),labyrinthe,0); }
          else {nMov=cherche_chemin(2,ghost.getPosition(),pacmanPos.getPosition(),labyrinthe,0);}
       } else {
        if(diffX>0){ cherche_chemin(3,ghost.getPosition(),pacmanPos.getPosition(),labyrinthe,0); }
        else {cherche_chemin(2,ghost.getPosition(),pacmanPos.getPosition(),labyrinthe,0);}
       }
       //parcours les 4 coups possibles
              for(int actuel=1; actuel<4; i++){
         if(cherche_chemin(actuel,ghost.getPosition(),pacmanPos.getPosition(),labyrinthe,0)<nMov)
       }
       return 1;
        
    }
    private int cherche_chemin(int dir,PositionAgent ghostPos, PositionAgent pacmanPos,Maze labyrinthe, int taille){
      switch(dir){
        case(0):{
          
        }
      }
      for(int actuel=1; actuel<4; i++){
        if(cherche_chemin(actuel,ghostPos,pacmanPos,labyrinthe,0))
      }
    }
    
}
