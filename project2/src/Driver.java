import java.io.IOException;

/**
 * Driver class
 * 
 * Prints information from a CSV file
 * 
 * @author Kevin Languasco
 * @version 2017-12-19
 *
 */
public class Driver
{
    public static void main(String[] args) throws IOException
    {
        Trial trial = new Trial("data", "k1", 3);
        for(int i = 0; i < trial.getSize(); ++i) {
            System.out.println(trial.getState(i).toString());
        }
    }
}
