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

    // Methode concrète

    public void init() {
        this.turn = 0;
        this.isRunning = true;
        this.observers= new ArrayList<Observer>();
        initialiseGame();
    }

    public void step() {
        if (gameContinue() == true) {
            isRunning = false;
            gameOver();
        } else {
            this.turn = this.turn + 1;
            takeTurn();
        }
        this.notifyObservers();
    }

    public void run() {
        while (isRunning != false) {
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
			observer.actualise();
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
        thread.run();
    }

    public long getTime(){
        return time;
    }

    public void setTime(long time){
        this.time=time;
    }

}
