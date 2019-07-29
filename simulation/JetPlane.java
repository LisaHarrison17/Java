package simulation;
import simulation.WeatherTower;
import simulation.Coordinates;
import simulation.Aircraft;
import simulation.Flyable;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower = new WeatherTower();
    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    public void updateConditions()
    {
        String weather = weatherTower.getWeather(coordinates);
        switch(weather)
        {
            case "SUN":
                FlightLog.Log("JetPlane#" + this.name + "(" + this.id + "): This is hot.");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                break;
            case "RAIN":
                FlightLog.Log("JetPlane#" + this.name + "(" + this.id + "):  It's raining. Better watch out for lightings.");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                break;
            case "FOG":
                FlightLog.Log("JetPlane#" + this.name + "(" + this.id + "): Can't see.");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                break;
            case "SNOW":
                FlightLog.Log("JetPlane#" + this.name + "(" + this.id + "): OMG! Winter is coming!");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                break;
        }
        if (this.coordinates.getHeight() == 0)
        {
            FlightLog.Log("JetPlane#" + this.name + "(" + this.id + "): Landing. Longitude: " + this.coordinates.getLongitude() + ". Latitude: " + this.coordinates.getLatitude() + ".");
            unregisterTower(this.weatherTower);
        }
    }
    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        FlightLog.Log("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
    public void unregisterTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        weatherTower.unregister(this);
        FlightLog.Log("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
    }
}