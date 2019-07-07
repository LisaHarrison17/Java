package simulation;
import simulation.WeatherTower;
import simulation.Coordinates;

public class Helicopter {
    private WeatherTower weatherTower = new WeatherTower();
    Helicopter(String name, Coordinates coordinates) {};
    public void updateConditions() {};
    public void registerTower(WeatherTower weatherTower) {};
}