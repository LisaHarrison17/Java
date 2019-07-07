package simulation;
import simulation.Flyable;

public class Tower {
    private Flyable* observers;
    public void register(flyable: Flyable){};
    public void unregister(flyable: Flyable){};
    protected void conditionsChanged(){};
}