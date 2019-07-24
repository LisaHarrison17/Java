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
                this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
            case "RAIN":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
            case "SNOW":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
        }
        //Helicopter#H1(3):
    }
    public void registerTower(WeatherTower weatherTower)
    {
        
    }
}