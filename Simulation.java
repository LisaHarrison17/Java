import java.io.BufferedReader;

import java.io.FileReader;
import simulation.*;
//import com.sun.java.util.jar.pack.Package.File;
//import java.io.PrintWriter;

public class Simulation
{
    public static void main(String args[])
    {
        if(args.length != 1)
        {
            System.out.println("Supply ONE scenario text file.");
        }
        else
        {
            try
            {
                
                FileReader file = new FileReader(args[0]);
                BufferedReader filereader = new BufferedReader(file);
                String line = filereader.readLine();
                int loop = 0;
                String name;
                String type;
                int longitude = 0, latitude = 0, height = 0;
                String[] splitLine;
                WeatherTower weatherTower = new WeatherTower();
                if(line != null)
                {
                    if(isNum(line))
                    {
                        loop = Integer.parseInt(line);
                    }
                    else
                    {
                        throw new CustomException("First Line needs to be an int!");
                        
                    }
                }
                while((line = filereader.readLine()) != null)
                {
                    splitLine = line.split(" ");
                    if (splitLine.length == 5)
                    {
                        type = splitLine[0];
                        name = splitLine[1];
                        if (isNum(splitLine[2]))
                        {
                            longitude = Integer.parseInt(splitLine[2]);
                        }
                        else
                        {
                            throw new CustomException("Longitude needs to be a positive integer.");
                        }
                        if (isNum(splitLine[3]))
                        {
                            latitude = Integer.parseInt(splitLine[3]);
                        }
                        else
                        {
                            throw new CustomException("Latitude needs to be a positive integer.");
                        }
                        if (isNum(splitLine[4]))
                        {
                            height = Integer.parseInt(splitLine[4]);
                        }
                        else
                        {
                            throw new CustomException("Height needs to be a positive integer.");
                        }
                        Flyable newAircraft = new AircraftFactory().newAircraft(type, name, longitude, latitude, height);
                        newAircraft.registerTower(weatherTower);
                    }
                    else
                    {
                        throw new CustomException("Incorrect scenario structure.");
                    }
                }
                for(int i = 0; i < loop; i++){
                    weatherTower.changeWeather();
                }
                filereader.close();
            }
            catch(Exception e)
            {
                System.out.print("Failed");
                filereader.close();
            }
        }
    }

    public static boolean isNum(String line)
    {
        int num =  0;
        try
        {
            num = Integer.parseInt(line);
            if (num >= 0){
                return true;
            }
            else {
                throw new CustomException("Invalid value");
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }
}