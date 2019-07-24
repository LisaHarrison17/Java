package simulation;
import java.util.Random;

import simulation.Coordinates;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"}; // = new String[*size*];
    private WeatherProvider()
    {
        
    }
    public static WeatherProvider getProvider()
    {
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates)
    {
        Random r = new Random();
        int coord = (coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude());
        int n = (r.nextInt(coord) % 4);
        return (weather[n]);
    }
}