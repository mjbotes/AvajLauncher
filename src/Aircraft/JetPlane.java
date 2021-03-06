package src.Aircraft;

import src.Coordinates;
import src.FileW;
import src.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void updateConditions() {
        String w = weatherTower.getWeather(this.coordinates);
        switch (w) {
            case "SUN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 10,
                    this.coordinates.getHeight() + 2
                );
                FileW.print(this.toString("JetPlane")+": WEEEE!!");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 5,
                    this.coordinates.getHeight()
                );
                FileW.print(this.toString("JetPlane")+": Shhhhh!!");
                break;   
            case "FOG":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 1,
                    this.coordinates.getHeight()
                );
                FileW.print(this.toString("JetPlane")+": Mom look at me Im flying with my eyes closed");
                break;
            default:
            case "SNOW":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 7
                );
                FileW.print(this.toString("JetPlane")+": Its a good thing I have a JET engine");
        }
        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            FileW.print(this.toString("JetPlane")+": landing.");
            FileW.print("Tower says: " + this.toString("JetPlane") + " unregistered to weather tower.");
        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        if (weatherTower != null) {
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
            FileW.print("Tower says: " + this.toString("JetPlane") + " registered to weather tower.");
        }
    }
    
}