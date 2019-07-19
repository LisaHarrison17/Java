package simulation;
import simulation.Coordinates;

public class WeatherProvider
{
    private WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"}; // = new String[*size*];
    private WeatherProvider()
    {
        
    };
    public WeatherProvider getProvider()
    {
        return weatherProvider;
    };
    public String getCurrentWeather(Coordinates coordinates)
    {

    };
}