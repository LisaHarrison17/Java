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
                FlightLog.Log("Baloon#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics.");
                this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                break;
            case "RAIN":
                FlightLog.Log("Baloon#" + this.name + "(" + this.id + "): Damn you rain! You messed up my baloon.");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                break;
            case "FOG":
                FlightLog.Log("Baloon#" + this.name + "(" + this.id + "): Can't see.");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            case "SNOW":
                FlightLog.Log("Baloon#" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                break;
        }
        if (this.coordinates.getHeight() == 0)
        {
            FlightLog.Log("Baloon#" + this.name + "(" + this.id + "): Landing. Longitude: " + this.coordinates.getLongitude() + ". Latitude: " + this.coordinates.getLatitude() + ".");
            unregisterTower(this.weatherTower);
        }
    }
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        FlightLog.Log("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
    public void unregisterTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.unregister(this);
        FlightLog.Log("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
    }
}