package simulation;
import simulation.WeatherTower;
import simulation.Coordinates;
import simulation.Aircraft;

public class Baloon extends Aircraft
{
    private WeatherTower weatherTower = new WeatherTower();
    Baloon(String name, Coordinates coordinates) {};
    public void updateConditions() {};

}