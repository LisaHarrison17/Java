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
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
        }
        //JetPlane#J1(2):
    }
    public void registerTower(WeatherTower weatherTower)
    {
        
    }
}