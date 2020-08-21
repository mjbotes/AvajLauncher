package src;

import src.Aircraft.Flyable;

import java.util.ArrayList;

public abstract class Tower {
    private ArrayList<Flyable> Observers = new ArrayList<Flyable>();

    public Tower() {

    }

    public void register(Flyable flyable) {
        Observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        Observers.remove(flyable);
    }

    public void conditionsChanged() {
        
    }
}