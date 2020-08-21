package src.Aircraft;

import src.FileW;
import src.Coordinates;
import src.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void updateConditions() {
        String w = weatherTower.getWeather(this.coordinates);
        switch (w) {
            case "SUN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 10,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + 2
                );
                FileW.print(this.coordinates.toString()+": I should've stayed home");
            case "RAIN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 5,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight()
                );
                FileW.print(this.coordinates.toString()+": Well at least I'm not in a bloon");
            case "FOG":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 1,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight()
                );
                FileW.print(this.coordinates.toString()+": What a FROG!!");
            default:
            case "SNOW":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 12
                );
                FileW.print(this.coordinates.toString()+": I should've become a doctor likr my dad wanted.");
        }
        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            FileW.print("Tower sas: " + this.toString() + " registered to weather tower.");
        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        if (weatherTower != null) {
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
            FileW.print("Tower sas: " + this.toString() + " registered to weather tower.");
        }
    }
}