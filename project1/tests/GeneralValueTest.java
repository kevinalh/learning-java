import static org.junit.Assert.*;

import org.junit.Test;

public class GeneralValueTest
{

    /**
     * Verifies that the default constructor creates an invalid value.
     */
    @Test
    public void testGeneralValue()
    {
        GeneralValue value = new GeneralValue();
        assertFalse("The default constructor isn't generating an invalid value", value.isValid());
    }

    /**
     * Verifies that the constructor is interpreting the String parameter correctly.
     */
    @Test
    public void testGeneralValueString()
    {
        GeneralValue value = new GeneralValue("12.69321");
        assertEquals("The constructor isn't reading the String correctly", value.getDoubleValue(), 12.69321, 0);
        value = new GeneralValue("NaN");
        assertFalse("NaN isn't interpreted correctly by the constructor", value.isValid());
    }

    @Test
    public void testIsValid()
    {
        GeneralValue value = new GeneralValue("991");
        assertTrue("991 should be a valid value", value.isValid());
        value = new GeneralValue("NaN");
        assertFalse("NaN shouldn't be considered a valid value", value.isValid());
    }

    @Test
    public void testGetDoubleValue()
    {
        GeneralValue value = new GeneralValue("15.1212");
        assertEquals("The getter isn't working as expected", value.getDoubleValue(), 15.1212, 0);
    }

    /**
     * Tests that the String representation is working as detailed in the
     * specification.
     */
    @Test
    public void testToString()
    {
        GeneralValue value = new GeneralValue("98.3489212");
        assertEquals("The String isn't in the correct format", value.toString(), "98.349");
        value = new GeneralValue("004");
        assertEquals("The String isn't in the correct format", value.toString(), "4.000");
        value = new GeneralValue("NaN");
        assertEquals("Isn't printing 'invalid' in the case of NaN", value.toString(), "invalid");
        value = new GeneralValue("-0.26432");
        assertEquals("The negative values aren't printing correctly", value.toString(), "-0.264");
    }

}
