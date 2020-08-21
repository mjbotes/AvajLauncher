package src.Aircraft;

import src.AvajException;
import src.WeatherTower;

public interface Flyable {

    public void updateConditions() throws AvajException;

    public void registerTower(WeatherTower WeatherTower);

    
}