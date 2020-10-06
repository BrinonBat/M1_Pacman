public interface Observable {
    public abstract void addObserver(Observer observer);
    public abstract void deleteObserver(Observer observer);
    public abstract void notifyObservers();
}
