package src;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    
    public Coordinates(int longitude, int latitude, int height) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }
}