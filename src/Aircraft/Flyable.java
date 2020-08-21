package src.Aircraft;

import src.WeatherTower;

public interface Flyable {

    public void updateConditions();

    public void registerTower(WeatherTower WeatherTower);

    
}