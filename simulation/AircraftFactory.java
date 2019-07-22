package simulation;

import simulation.Flyable;

public class AircraftFactory
{
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type.toLowerCase())
        {
            case "baloon":
                return new Baloon(name, coordinates);
            case "helicopter":
                return new Helicopter(name, coordinates);
            case "jetplane":
                return new JetPlane(name, coordinates);
            default:
                System.out.println("Unknown aircaft type:" + type + ". See scenario file.");
                return null;
        }
    };
}