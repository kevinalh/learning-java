/**
 * Abstract class consisting of multiple items
 * 
 * @author kevinalh
 * @version 2017-12-19
 */
public abstract class MultipleItemAbstract extends SingleItemAbstract
{
    public abstract int getSize();
    public abstract SingleItemAbstract getItem(int index);
}
