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
                FlightLog.Log("JetPlane#" + this.name + "(" + this.id + "): sun...");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                break;
            case "RAIN":
                FlightLog.Log("JetPlane#" + this.name + "(" + this.id + "): rain...");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                break;
            case "FOG":
                FlightLog.Log("JetPlane#" + this.name + "(" + this.id + "): rog...");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                break;
            case "SNOW":
                FlightLog.Log("JetPlane#" + this.name + "(" + this.id + "): snow...");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                break;
        }
    }
    public void registerTower(WeatherTower weatherTower)
    {
        weatherTower.register(this);
        FlightLog.Log("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}