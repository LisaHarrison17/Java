package simulation;
import simulation.WeatherTower;
import simulation.Coordinates;
import simulation.Aircraft;
import simulation.Flyable;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower = new WeatherTower();
    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    };
    public void updateConditions()
    {
        String weather = weatherTower.getWeather(coordinates);
        switch(weather)
        {
            case "SUN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
        }
        //Baloon#B1(1):
    };
    public void registerTower(WeatherTower weatherTower)
    {

    };
}