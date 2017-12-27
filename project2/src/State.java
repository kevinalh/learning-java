/**
 * Representation of the state of a single time step
 * 
 * @author Kevin Languasco
 * @version 2017-12-19
 *
 */
public class State extends SingleItemAbstract
{
    /** Position of the left Wrist */
    private Point3D leftWrist;
    /** Position of the right Wrist */
    private Point3D rightWrist;
    /** Timestamp of the current sample. */
    private double time;

    /**
     * Builds the State based on information of a comma-separated String.
     * 
     * @param strg
     *            String with 7 comma-separated values.
     */
    public State(String strg)
    {
        String[] substrings = strg.split(",");
        if (substrings.length < 7)
        {
            throw new IllegalArgumentException("The String should have 7 comma-separated values");
        }
        try
        {
            time = Double.parseDouble(substrings[0]);
            leftWrist = new Point3D(
                    new GeneralValue(substrings[1]), new GeneralValue(substrings[2]), new GeneralValue(substrings[3])
            );
            rightWrist = new Point3D(
                    new GeneralValue(substrings[4]), new GeneralValue(substrings[5]), new GeneralValue(substrings[6])
            );
        }
        catch (NullPointerException | NumberFormatException ex)
        {
            throw new IllegalArgumentException("The String is not in the correct format");
        }
    }

    /**
     * Gets the leftWrist Point3D object
     * 
     * @return Left wrist Point3D object
     */
    public Point3D getLeftWrist()
    {
        return leftWrist;
    }

    /**
     * Gets the rightWrist Point3D object
     * 
     * @return Right wrist Point3D object
     */
    public Point3D getRightWrist()
    {
        return rightWrist;
    }

    /**
     * Gets the time in which this State was recorded
     * 
     * @return The time of recording
     */
    public double getTime()
    {
        return time;
    }

    /**
     * Represents the State by printing the time with 2 decimal places and the
     * wrists via their values.
     * 
     * @return Representation of the State via the time and the wrists
     */
    @Override
    public String toString()
    {
        return String.format("%.2f: left_wrist=<", time) + leftWrist.toString() + ">, right_wrist=<"
                + rightWrist.toString() + ">";
    }

    /**
     * Gets the value of the left wrist
     * 
     * @param dim
     *            Dimension of interest
     * @return Value of left wrist point coordinate
     */
    @Override
    public GeneralValue getAverageLeftWrist(int dim)
    {
        GeneralValue value = leftWrist.getDimValue(dim);
        if (!value.isValid())
        {
            throw new InvalidValueException("Value isn't valid");
        }
        return value;
    }

    /**
     * Gets the value of the left wrist
     * 
     * @param dim
     *            Dimension of interest
     * @return Value of left wrist point coordinate
     */
    @Override
    public GeneralValue getMinLeftWrist(int dim)
    {
        try
        {
            return getAverageLeftWrist(dim);
        }
        catch (InvalidValueException ex)
        {
            throw ex;
        }
    }

    /**
     * Gets the value of the left wrist
     * 
     * @param dim
     *            Dimension of interest
     * @return Value of left wrist point coordinate
     */
    @Override
    public GeneralValue getMaxLeftWrist(int dim)
    {
        try
        {
            return getAverageLeftWrist(dim);
        }
        catch (InvalidValueException ex)
        {
            throw ex;
        }
    }

}
