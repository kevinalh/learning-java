/**
 * 3D Point class
 * 
 * Represents a point in 3D space. The coordinates can be invalid in case of
 * error in data collection.
 * 
 * @author Kevin Languasco
 * @version 2017-12-15
 *
 */
public class Point3D
{
    private GeneralValue[] values;

    /**
     * Constructs a Point3D given three coordinates (GeneralValue objects).
     * 
     * @param x
     *            The x-coordinate
     * @param y
     *            The y-coordinate
     * @param z
     *            The z-coordinate
     */
    public Point3D(GeneralValue x, GeneralValue y, GeneralValue z)
    {
        values = new GeneralValue[3];
        // We're referencing the GeneralValue objects given in the array, not copying
        // them.
        values[0] = x;
        values[1] = y;
        values[2] = z;
    }

    /**
     * Gets the GeneralValue object representing a given dimension of the Point3D,
     * that is, the coordinate asked for
     * 
     * @param dimension
     *            The dimension of the Point3D to obtain: 0 for the x-coordinate, 1
     *            for the y-coordinate, 2 for the z-coordinate
     * @return The GeneralValue object representing the Point3D dimension
     */
    public GeneralValue getDimValue(int dimension)
    {
        if (dimension < 0 || dimension > 2)
        {
            throw new IllegalArgumentException("The dimension should be betweeen 0 and 2");
        }
        else
        {
            return values[dimension];
        }
    }

    /**
     * Gets the array of coordinates for the Point3D.
     * 
     * @return An array of GeneralValue object representing the Point3D.
     */
    public GeneralValue[] getValues()
    {
        return values;
    }

    /**
     * Returns a String representing the Point3D in the format "x,y,z", where any
     * coordinate can be a value with 3 decimal places or "invalid"
     * 
     * @return A String representing the Point3D coordinates (including "invalid").
     */
    @Override
    public String toString()
    {
        return values[0].toString() + ',' + values[1].toString() + ',' + values[2].toString();
    }
}
