package simulation;
import simulation.Coordinates;

public class WeatherProvider
{
    private WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather; // = new String[*size*];
    private WeatherProvider() {};
    public WeatherProvider getProvider() {};
    public String getCurrentWeather(Coordinates coordinates) {};
}