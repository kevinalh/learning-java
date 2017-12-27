import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class StateTest
{
    static State state;
    static String line = "2.00,0.258,0.040,0.217,0.189,-0.264,-0.023";
    static String wrongLine = "3,1.2,-4.5";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        state = new State(line);
    }

    @Test
    public void testState()
    {
        assertEquals("0.189,-0.264,-0.023", state.getRightWrist().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailWhenGivenInvalidLine()
    {
        State wrongState = new State(wrongLine);
        fail("This shouldn't run");
    }

    @Test
    public void testGetLeftWrist()
    {
        assertEquals(state.getLeftWrist().getDimValue(0).getDoubleValue(), 0.258, 0);
    }

    @Test
    public void testGetRightWrist()
    {
        assertEquals(state.getRightWrist().getDimValue(2).getDoubleValue(), -0.023, 0);
    }

    @Test
    public void testGetTime()
    {
        assertEquals(state.getTime(), 2.00, 0);
    }

    @Test
    public void testToString()
    {
        assertEquals("2.00: left_wrist=<0.258,0.040,0.217>, right_wrist=<0.189,-0.264,-0.023>", state.toString());
    }

    @Test
    public void testGetStatsOfLeftWrist()
    {
        assertEquals(state.getMaxLeftWrist(0).getDoubleValue(), 0.258, 0);
        assertEquals(state.getAverageLeftWrist(0).getDoubleValue(), 0.258, 0);
        assertEquals(state.getMinLeftWrist(0).getDoubleValue(), 0.258, 0);
        String badLine = "2.00,NaN,0.040,0.217,0.189,-0.264,-0.023";
        State badState = new State(badLine);
        try
        {
            badState.getAverageLeftWrist(0);
            fail("This shouldn't run");
        }
        catch(InvalidValueException ex)
        {
            assertNotNull(ex);
        }
        try
        {
            badState.getMinLeftWrist(0);
            fail("This shouldn't run");
        }
        catch(InvalidValueException ex)
        {
            assertNotNull(ex);
        }
        try
        {
            badState.getMaxLeftWrist(0);
            fail("This shouldn't run");
        }
        catch(InvalidValueException ex)
        {
            assertNotNull(ex);
        }
    }
    
}
