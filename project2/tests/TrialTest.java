import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TrialTest
{

    static Trial trial;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        trial = new Trial("mydata", "k5", 4);
    }

    @Test(expected = IOException.class)
    public void testTrial() throws IOException
    {
        Trial badTrial = new Trial("mydata", "k5", 5);
    }

    @Test
    public void testGetState()
    {
        assertEquals(trial.getState(0).getLeftWrist().getDimValue(0).getDoubleValue(), 1, 0);
        assertFalse(trial.getState(1).getLeftWrist().getDimValue(0).isValid());
        assertEquals(trial.getState(2).getLeftWrist().getDimValue(0).getDoubleValue(), 5, 0);
        assertSame(trial.getItem(0), trial.getState(0));
    }

    @Test
    public void testGetSize()
    {
        assertEquals(trial.getSize(), 3);
    }

    @Test
    public void testGetInfantID()
    {
        assertEquals(trial.getInfantID(), "k5");
    }

    @Test
    public void testGetWeek()
    {
        assertEquals(trial.getWeek(), 4);
    }

    @Test
    public void testGetFileName()
    {
        assertEquals(trial.getFileName(), "mydata/subject_k5_w04.csv");
    }

    @Test
    public void testGetMaxLeftWrist()
    {
        assertEquals(trial.getMaxLeftWrist(0).getDoubleValue(), 5, 0.001);
        assertEquals(trial.getMaxLeftWrist(1).getDoubleValue(), 3, 0.001);
        assertEquals(trial.getMaxLeftWrist(2).getDoubleValue(), 11, 0.001);
    }

    @Test
    public void testGetMinLeftWrist()
    {
        assertEquals(trial.getMinLeftWrist(0).getDoubleValue(), 1, 0.001);
        assertEquals(trial.getMinLeftWrist(1).getDoubleValue(), 1, 0.001);
        assertEquals(trial.getMinLeftWrist(2).getDoubleValue(), 1, 0.001);
    }

    @Test
    public void testGetAverageLeftWrist()
    {
        assertEquals(trial.getAverageLeftWrist(0).getDoubleValue(), 3, 0.001);
        assertEquals(trial.getAverageLeftWrist(1).getDoubleValue(), 2, 0.001);
        assertEquals(trial.getAverageLeftWrist(2).getDoubleValue(), 14.0/3.0, 0.001);
    }

}
