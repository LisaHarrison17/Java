import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;

public class Simulation
{
    public static void main(String args[])
    {
        if(args.length != 1)
        {
            System.out.println("Supply ONE scenario txt file pls");
        }
        else
        {
            try
            {
                BufferedReader filereader = new BufferedReader(new FileReader(args[0]));
                String line = filereader.readLine();
                int loop = 0;
                String name;
                String type;
                int longitude = 0, latitude = 0, height = 0;
                String splitLine[];
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
//                    while((line = filereader.readLine()) != null)
//                    {
//                        name =
//                    }
                }
            }

            catch(Exception e)
            {
                System.out.println("Failed");
            }
        }
    }

    public static boolean isNum(String line)
    {
        int num =  0;
        try
        {
            num = Integer.parseInt(line);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


}