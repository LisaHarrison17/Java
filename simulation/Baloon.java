package simulation;
import simulation.WeatherTower;
import simulation.Coordinates;
import simulation.Aircraft;
import simulation.Flyable;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower = new WeatherTower();
    Baloon(String name, Coordinates coordinates) {};
    public void updateConditions() {};

}