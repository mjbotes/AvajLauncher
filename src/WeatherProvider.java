package src;

import java.util.Random;

public class WeatherProvider {

    static private WeatherProvider weatherProvider;
    
    private WeatherProvider() {
    }

    static public WeatherProvider getProvider() {
        if(weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int n = coordinates.getHeight() * (new Random().nextInt(5)) + coordinates.getLatitude() * (new Random().nextInt(5));
        n += coordinates.getLongitude() * (new Random().nextInt(5));

        switch ((int)((n%4))){
            case 0:
                return "SUN";
            case 1:
                return "RAIN";
            case 2:
                return "FOG";
            case 3:
            default:
                return "SNOW";
        }
    }
    
}