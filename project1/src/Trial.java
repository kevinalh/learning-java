import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Representation of a single trial
 * 
 * @author Kevin Languasco
 * @version 2017-12-19
 *
 */
public class Trial
{
    /** Sequence of states. */
    private ArrayList<State> stateList;
    /** ID for the infant */
    private String infantID;
    /** Week index. */
    private int week;
    /** File name that was loaded. */
    private String fileName;

    /**
     * Trial constructor
     * 
     * @param directory
     *            String representing the directory containing the data files
     * @param infantID
     *            String representing the infant ID
     * @param week
     *            int week for the data file.
     * 
     * @throws IOException
     *             If there is an error finding or loading the data file.
     */
    public Trial(String directory, String infantID, int week) throws IOException
    {
        this.infantID = infantID;
        this.week = week;
        this.fileName = String.format("%s/subject_%s_w%02d.csv", directory, infantID, week);

        this.stateList = new ArrayList<State>();

        // Open the file
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        String strg;

        // throw out header
        strg = br.readLine();

        while((strg = br.readLine()) != null)
        {
            stateList.add(new State(strg));
        }

        br.close();
    }

    /**
     * A particular State, given an index
     * 
     * @param index
     *            Index of the State in the list
     * @return The State
     */
    public State getState(int index)
    {
        return stateList.get(index);
    }

    /**
     * How many States are recorded in this Trial
     * 
     * @return Size of the list of States
     */
    public int getSize()
    {
        return stateList.size();
    }

    /**
     * The ID of the Infant recorded in this Trial
     * 
     * @return ID of the Infant
     */
    public String getInfantID()
    {
        return infantID;
    }

    /**
     * Week in which this Trial was recorded
     * 
     * @return Week of the Trial
     */
    public int getWeek()
    {
        return week;
    }

    /**
     * Filename where the data is
     * 
     * @return Filename with the data
     */
    public String getFileName()
    {
        return fileName;
    }

    /**
     * Maximum recorded value of the left wrist for a given dimension
     * 
     * @param dimension
     *            The dimension of interest
     * @return Maximum value of left wrist for the dimension
     */
    public double getMaxLeftWrist(int dimension)
    {
        double maxSoFar = Double.MIN_VALUE;
        GeneralValue currentValue;
        for (State current : stateList)
        {
            currentValue = current.getLeftWrist().getDimValue(dimension);
            if (currentValue.isValid() && currentValue.getDoubleValue() > maxSoFar)
            {
                maxSoFar = currentValue.getDoubleValue();
            }
        }
        return maxSoFar;
    }

    /**
     * Minimum recorded value of the left wrist for a given dimension
     * 
     * @param dimension
     *            The dimension of interest
     * @return Minimum value of left wrist for the dimension
     */
    public double getMinLeftWrist(int dimension)
    {
        double minSoFar = Double.MAX_VALUE;
        GeneralValue currentValue;
        for (State current : stateList)
        {
            currentValue = current.getLeftWrist().getDimValue(dimension);
            if (currentValue.isValid() && currentValue.getDoubleValue() < minSoFar)
            {
                minSoFar = currentValue.getDoubleValue();
            }
        }
        return minSoFar;
    }

    /**
     * Average recorded value of the left wrist for a given dimension
     * 
     * @param dimension
     *            The dimension of interest
     * @return Average value of left wrist for the dimension
     */
    public double getAverageLeftWrist(int dimension)
    {
        double average = 0;
        int validValues = 0;
        GeneralValue currentValue;
        for (State current : stateList)
        {
            currentValue = current.getLeftWrist().getDimValue(dimension);
            if (currentValue.isValid())
            {
                validValues++;
                average += currentValue.getDoubleValue();
            }
        }
        return average / validValues;
    }
}
