package simulation;
import simulation.WeatherTower;
import simulation.Coordinates;
import simulation.Aircraft;
import simulation.Flyable;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower weatherTower = new WeatherTower();
    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    public void updateConditions()
    {
        String weather = weatherTower.getWeather(coordinates);
        switch(weather)
        {
            case "SUN":
                FlightLog.Log("Helicopter#" + this.name + "(" + this.id + "): sun...");
                this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                break;
            case "RAIN":
                FlightLog.Log("Helicopter#" + this.name + "(" + this.id + "): rain...");
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "FOG":
                FlightLog.Log("Helicopter#" + this.name + "(" + this.id + "): fog...");
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "SNOW":
                FlightLog.Log("Helicopter#" + this.name + "(" + this.id + "): snow...");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                break;
        }
    }
    public void registerTower(WeatherTower weatherTower)
    {
        weatherTower.register(this);
        FlightLog.Log("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}