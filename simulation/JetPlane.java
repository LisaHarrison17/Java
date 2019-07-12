package simulation;
import simulation.WeatherTower;
import simulation.Coordinates;
import simulation.Aircraft;

public class JetPlane extends Aircraft
{
    private WeatherTower weatherTower = new WeatherTower();
    JetPlane(String name, Coordinates coordinates) {};
    public void updateConditions() {};
    public void registerTower(WeatherTower weatherTower) {};
}