/**
 * Value class
 * 
 * Captures both a double value and whether or not it is valid
 * 
 * @author Kevin Languasco
 * @version 2017-12-14
 *
 */
public class GeneralValue
{
    /** Is the value valid? */
    private final boolean valid;
    /** Double value stored. */
    private final double doubleValue;

    /**
     * The default constructor generates an invalid value.
     */
    public GeneralValue()
    {
        doubleValue = 0.0;
        valid = false;
    }

    /**
     * Stores the value in the String parameter if it's a number. If it's "NaN", the
     * 'valid' instance variable is set to false.
     * 
     * @param strg
     *            The value to be stored, or "NaN"
     */
    public GeneralValue(String strg)
    {
        if (strg.equals("NaN"))
        {
            doubleValue = 0.0;
            valid = false;
        }
        else
        {
            try
            {
                doubleValue = Double.parseDouble(strg);
            }
            catch (NullPointerException | NumberFormatException ex)
            {
                throw ex;
            }
            valid = true;
        }
    }

    /**
     * Indicates whether the value is valid or not.
     * 
     * @return A boolean indicating the validity of the value.
     */
    public boolean isValid()
    {
        return valid;
    }

    /**
     * Gets the double value stored in the object.
     * 
     * @return The value stored.
     */
    public double getDoubleValue()
    {
        return doubleValue;
    }

    /**
     * If the 'valid' instance variable is true, returns a String with the value
     * stored, using 3 decimal places. Otherwise, returns "Invalid".
     * 
     * @return If valid, the value stored as a String, with 3 decimal places.
     *         Otherwise, "Invalid".
     */
    @Override
    public String toString()
    {
        if (valid)
        {
            return String.format("%.3f", doubleValue);
        }
        else
        {
            return "invalid";
        }
    }
}
