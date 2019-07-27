package simulation;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FlightLog {
    private static File log = new File("simulation.txt");

    public static void Log(String text)
    {
        try
        {
            FileWriter write = new FileWriter(log, true);
            PrintWriter writeLine = new PrintWriter(write);
            writeLine.printf("%s" + "%n", text);
            writeLine.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
    }
}