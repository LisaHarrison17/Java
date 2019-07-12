package simulation;
import simulation.WeatherTower;
import simulation.Coordinates;
import simulation.Aircraft;
import simulation.Flyable;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower weatherTower = new WeatherTower();
    Helicopter(String name, Coordinates coordinates) {};
    public void updateConditions() {};
    public void registerTower(WeatherTower weatherTower) {};
}