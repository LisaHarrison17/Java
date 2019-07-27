package simulation;
import simulation.Coordinates;
import simulation.Tower;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    void changeWeather()
    {
        this.conditionsChanged();
    }
}