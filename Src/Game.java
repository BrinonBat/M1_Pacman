import java.util.ArrayList;

public abstract class Game implements Runnable, Observable {
    private int turn;
    private int maxturn;
    private long time;
    private boolean isRunning;
    private Thread thread;
    private ArrayList<Observer> observers;

    // Methode Abstraite
    public abstract void initialiseGame();
    public abstract void takeTurn();
    public abstract boolean gameContinue();
    public abstract void gameOver();

   // public abstract void MovePacman(int code);

    // Methode concrète

    public Game(){
        this.observers=new ArrayList<Observer>();
    }

    public void step() {
        if (!this.gameContinue()) {
            isRunning = false;
            gameOver();
        } 
        takeTurn();
        this.turn = this.turn + 1;
        this.notifyObservers();
    }

    public void run() {
        while (gameContinue()) {
            step();
            try {
                Thread.sleep(time);
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }

    public void notifyObservers(){
        for(int i = 0; i< observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update(this);
        }
    }

    public void pause() {
        isRunning = false;
    }

    public int getTurn() {
        return turn;
    }

    // Getter et Setter

    public void addObserver(Observer obs){
        observers.add(obs);
    }

    public void deleteObserver(Observer obs){
        observers.remove(obs);
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getMaxturn() {
        return maxturn;
    }

    public void setMaxturn(int maxturn) {
        this.maxturn = maxturn;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void lauch() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public long getTime(){
        return time;
    }

    public void setTime(long time){
        this.time=time;
    }

}
