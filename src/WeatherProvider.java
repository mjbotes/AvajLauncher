package src;

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
        int n = coordinates.getHeight() * 3 + coordinates.getLatitude() * 2;
        n += coordinates.getLongitude();

        switch ((int)((n%4)-0.1)){
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