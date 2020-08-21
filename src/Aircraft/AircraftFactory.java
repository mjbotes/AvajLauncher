package src.Aircraft;

import src.Coordinates;
import src.AvajException;

public abstract class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AvajException {
        switch(type){
            case "Helicopter":
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            case "JetPlane":
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            case "Baloon":
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            default:
                throw new AvajException(
                        "ERROR. is it a bird? is it a plane? Whatever it is I dont know: '" + type + "'");
        }
    }
    
}