package simulation;
import simulation.WeatherTower;

interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}