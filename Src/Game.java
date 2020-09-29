public abstract class Game {
    private int turn ;
    private int maxturn;
    private boolean isRunning;

    //Methode Abstraite
    public abstract void initialiseGame();
    public abstract void takeTurn();
    public abstract boolean gameContinue();
    public abstract void gameOver();

    //Methode concrète
    public void init() {
        this.turn = 0;
        this.isRunning = true;
        initialiseGame();
    }

    public void step()
    {
        if(gameContinue() == true)
        {
            isRunning = false;
            gameOver();
        } 
        else
        {
            this.turn = this.turn + 1;
            takeTurn();
        }
    }

    public void run()
    {
        while( isRunning != false )
            step();
    }

    public void pause(){ isRunning = false ; }

    public int getTurn() {
        return turn;
    }


    //Getter et Setter
    
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

}
