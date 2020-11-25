import java.util.ArrayList;

public class StrategieGhost implements Strategie {

    @Override
    public AgentAction getAction(PacmanGame game, Agent agent) {
      ArrayList<Pacman> pacmans = game.getPacmans();
      ArrayList<Ghost> ghosts = game.getGhosts();
      Pacman currentPacman = pacmans.get(0);
      AgentAction action = new AgentAction(shortestway((Agent)ghosts.get(0),(Agent)currentPacman,game.getMap()));

      return action; 
    }
  
  //algorithme A*
  // sortie : int compris entre 0 et 4 en fonction du numero du coup à faire.
  protected int shortestway(Agent ghost,Agent pacman,Maze labyrinthe)
  { 
    int move=0;
    PositionAgent nouvPos;
    ArrayList<PositionAgent> disponibles=labyrinthe.getForkList();
    ArrayList<PositionAgent> Chemin=new ArrayList<PositionAgent>();
    ArrayList<PositionAgent> liPos=new ArrayList<PositionAgent>();

    // ajout du pacman à la liste des noeuds s'il n'y est pas déjà
    if(!disponibles.contains(pacman.getPosition())) disponibles.add(pacman.getPosition());
    // ajout du départ
    liPos.add(ghost.getPosition());

    while(!liPos.isEmpty()){

      //on cherche la position enregistrée la plus proche du pacman
      nouvPos=liPos.get(0);
      for(int i=0;i<liPos.size();i++){
        if(nouvPos.distanceWith(pacman.getPosition())>liPos.get(i).distanceWith(pacman.getPosition())) nouvPos=liPos.get(i);
      };
       // on arrête une fois qu'on a trouvé le chemin le plus court
      if(nouvPos.equals(pacman.getPosition())){
        // vu qu'on a testé de 0 à 4 les directions de la racine, alors celle qui est la plus élevée est la dernière testée, donc la plus proche.
        if(!labyrinthe.isWall(ghost.getPosition().getX(), ghost.getPosition().getY()+1)){
          if(Chemin.contains(nextPosition(disponibles, ghost.getPosition() , (byte)1))) 
            move=1;
        }
        if(!labyrinthe.isWall(ghost.getPosition().getX()+1, ghost.getPosition().getY())){
          if(Chemin.contains(nextPosition(disponibles, ghost.getPosition() , (byte)2))) 
            move=2;
        }
        if(!labyrinthe.isWall(ghost.getPosition().getX()-1, ghost.getPosition().getY())){
          if(Chemin.contains(nextPosition(disponibles, ghost.getPosition() , (byte)3)))
            move=3;
        }
        System.out.println("choix de la direction"+move);
        return move;
      }
      
      // ajout des voisins de nouvPos qui n'ont pas déjà été traités
      if(!labyrinthe.isWall(nouvPos.getX(), nouvPos.getY()-1)){
        if(!Chemin.contains(nextPosition(disponibles, nouvPos , (byte)0)))
          liPos.add(nextPosition(disponibles, nouvPos , (byte)0));
      }
      if(!labyrinthe.isWall(nouvPos.getX(), nouvPos.getY()+1)){
        if(!Chemin.contains(nextPosition(disponibles, nouvPos , (byte)1))) 
          liPos.add(nextPosition(disponibles, nouvPos , (byte)1));
      }
      if(!labyrinthe.isWall(nouvPos.getX()+1, nouvPos.getY())){
        if(!Chemin.contains(nextPosition(disponibles, nouvPos , (byte)2))) 
          liPos.add(nextPosition(disponibles, nouvPos , (byte)2));
      }
      if(!labyrinthe.isWall(nouvPos.getX()-1, nouvPos.getY())){
        if(!Chemin.contains(nextPosition(disponibles, nouvPos , (byte)3))) 
          liPos.add(nextPosition(disponibles, nouvPos , (byte)3));
      }

      // nouvPos traité, on le retire des noeuds à parcourir
      liPos.remove(nouvPos);
      Chemin.add(nouvPos);
    }
    System.out.println(" Erreur lors de la recherche du plus court chemin de"+ghost);
    return 4;
  }  

  //retourne la position du noeud se trouvant dans la direction prise en paramètre
  private PositionAgent nextPosition(ArrayList<PositionAgent> freePos, PositionAgent currentPos, byte direction){
    PositionAgent result=currentPos;
    switch(direction){
      case(0):{ // north
        do{
          result.setY(result.getY()-1);
          if(freePos.contains(result)) break;
        }while(Math.abs(result.getY())!=1000);
       break; 
      }
      case(1):{ // south
        do{
          result.setY(result.getY()+1);
          if(freePos.contains(result)) break;
        }while(Math.abs(result.getY())!=1000);
       break; 
      } 
      case(2):{ // east
        do{
          result.setX(result.getX()+1);
          if(freePos.contains(result)) break;
        }while(Math.abs(result.getX())!=1000);
       break; 
      } 
      case(3):{ // west
        do{
          result.setX(result.getX()-1);
          if(freePos.contains(result)) break;
        }while(Math.abs(result.getX())!=1000);
       break; 
      } 
    }
    return result;
  }

}
