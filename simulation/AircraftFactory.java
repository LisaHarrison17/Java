package simulation;
import simulation.Flyable;

public class AircraftFactory
{
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height);
}