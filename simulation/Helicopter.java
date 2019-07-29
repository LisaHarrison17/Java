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
                FlightLog.Log("Helicopter#" + this.name + "(" + this.id + "): This is hot.");
                this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                break;
            case "RAIN":
                FlightLog.Log("Helicopter#" + this.name + "(" + this.id + "):  It's raining. Better watch out for lightings.");
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "FOG":
                FlightLog.Log("Helicopter#" + this.name + "(" + this.id + "): Can't see.");
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                break;
            case "SNOW":
                FlightLog.Log("Helicopter#" + this.name + "(" + this.id + "): My rotor is going to freeze!");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                break;
        }
        if (this.coordinates.getHeight() == 0)
        {
            FlightLog.Log("Helicopter#" + this.name + "(" + this.id + "): Landing. Longitude: " + this.coordinates.getLongitude() + ". Latitude: " + this.coordinates.getLatitude() + ".");
            unregisterTower(this.weatherTower);
        }
    }
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        FlightLog.Log("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
    public void unregisterTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.unregister(this);
        FlightLog.Log("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
    }
}