import java.io.IOException;
import java.util.ArrayList;

/**
 * Class representing an Infant
 * 
 * @author kevinalh
 * @version 2017-12-19
 */
public class Infant extends MultipleItemAbstract
{
    private ArrayList<Trial> trialList;
    private String infantID;
    private int MAX_WEEK = 16;

    public Infant(String directory, String infantID) throws IOException
    {
        
    }
    
    @Override
    public int getSize()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public SingleItemAbstract getItem(int index)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GeneralValue getMaxLeftWrist(int dim)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GeneralValue getMinLeftWrist(int dim)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GeneralValue getAverageLeftWrist(int dim)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
