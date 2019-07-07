package simulation;
import simulation.Coordinates;
import java.util.ArrayList;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates = new Coordinates();
    private long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {};
    private long nextId() {};
}