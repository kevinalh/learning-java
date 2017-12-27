import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class Point3DTest
{

    static GeneralValue x1, y1, z1, x2, y2, z2;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        x1 = new GeneralValue();
        y1 = new GeneralValue("12.9999");
        z1 = new GeneralValue("003.1");
        x2 = new GeneralValue("0.189");
        y2 = new GeneralValue("-0.264");
        z2 = new GeneralValue("-0.023");
    }

    @Test
    public void testPoint3D()
    {
        Point3D point = new Point3D(x1, y1, z1);
        GeneralValue[] pointArray = new GeneralValue[3];
        pointArray[0] = x1;
        pointArray[1] = y1;
        pointArray[2] = z1;
        GeneralValue[] originalArray = point.getValues();
        assertSame(originalArray[0], pointArray[0]);
        assertSame(originalArray[1], pointArray[1]);
        assertSame(originalArray[2], pointArray[2]);
    }

    @Test
    public void testGetDimValue()
    {
        Point3D point = new Point3D(x1, y1, z1);
        assertEquals(point.getDimValue(0).toString(), "invalid");
        assertEquals(point.getDimValue(1).getDoubleValue(), 12.9999, 0);
        assertEquals(point.getDimValue(2).getDoubleValue(), 3.1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDim4ArgumentToGetDimShouldThrow()
    {
        Point3D point = new Point3D(x1, y1, z1);
        point.getDimValue(4);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDimArgumentToGetDimShouldThrow()
    {
        Point3D point = new Point3D(x1, y1, z1);
        point.getDimValue(-1);
    }

    @Test
    public void testGetValues()
    {
        Point3D point = new Point3D(x1, y1, z1);
        GeneralValue[] coordinates = point.getValues();
        assertEquals(coordinates[0].toString(), "invalid");
        assertEquals(coordinates[2].toString(), "3.100");
    }

    @Test
    public void testToString()
    {
        Point3D point = new Point3D(x1, y1, z1);
        assertEquals(point.toString(), "invalid,13.000,3.100");
        point = new Point3D(x2, y2, z2);
        assertEquals(point.toString(), "0.189,-0.264,-0.023");
    }

}
