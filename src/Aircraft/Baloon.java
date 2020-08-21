package src.Aircraft;

import src.Coordinates;
import src.FileW;
import src.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String w = weatherTower.getWeather(this.coordinates);
        switch (w) {
            case "SUN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude() + 2,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + 4
                );
                FileW.print(this.coordinates.toString()+": HEY GOOGLE can baloons melt");
            case "RAIN":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 5
                );
                FileW.print(this.coordinates.toString()+": Alexa can rain break my baloon");
            case "FOG":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 3
                );
                FileW.print(this.coordinates.toString()+": Amazon where am I.");
            default:
            case "SNOW":
                this.coordinates = new Coordinates(
                    this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 15
                );
                FileW.print(this.toString()+": Calculator what is Baloon + snow");
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