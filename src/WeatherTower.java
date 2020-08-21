package src;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void ChangeWeather(){
        this.conditionsChanged();
    }
}