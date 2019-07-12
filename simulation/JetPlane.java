package simulation;
import simulation.WeatherTower;
import simulation.Coordinates;
import simulation.Aircraft;
import simulation.Flyable;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower = new WeatherTower();
    JetPlane(String name, Coordinates coordinates) {};
    public void updateConditions() {};
    public void registerTower(WeatherTower weatherTower) {};
}