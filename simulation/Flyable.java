package simulation;
import simulation.WeatherTower;

public interface Flyable
{
    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}