package simulation;
import simulation.WeatherTower;
import simulation.Coordinates;
import simulation.Aircraft;
import simulation.Flyable;
import simulation.FlightLog;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower = new WeatherTower();
    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        switch(weather)
        {
            case "SUN":
                FlightLog.Log("Baloon#" + this.name + "(" + this.id + "): sun...");
                this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                break;
            case "RAIN":
                FlightLog.Log("Baloon#" + this.name + "(" + this.id + "): rain...");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                break;
            case "FOG":
                FlightLog.Log("Baloon#" + this.name + "(" + this.id + "): fog...");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            case "SNOW":
                FlightLog.Log("Baloon#" + this.name + "(" + this.id + "): snow...");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                break;
        }
    }
    public void registerTower(WeatherTower weatherTower)
    {
        weatherTower.register(this);
        FlightLog.Log("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}