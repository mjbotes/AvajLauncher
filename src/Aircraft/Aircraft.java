package src.Aircraft;

import src.Coordinates;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    static private long idCounter = 1;

    public Aircraft(String name, Coordinates coordinates) {
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return Aircraft.idCounter++;
    }

    public String toString(String type){
        return type + '#' + this.name + '(' + this.id + ')';
    }

    public String toString(){
        return "DefaultAircraft#" + this.name + '(' + this.id + ')';
    }

    
}