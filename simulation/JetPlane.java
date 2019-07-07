package simulation;
import simulation.WeatherTower;
import simulation.Coordinates;

public class JetPlane {
    private WeatherTower weatherTower = new WeatherTower();
    JetPlane(String name, Coordinates coordinates) {};
    public void updateConditions() {};
    public void registerTower(WeatherTower weatherTower) {};
}