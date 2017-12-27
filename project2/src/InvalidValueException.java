/**
 * Simple extension of RunTimeException
 * 
 * @author kevinalh
 * @version 2017-12-19
 * 
 */
public class InvalidValueException extends RuntimeException
{

    /**
     * Required because it's Serializable.
     */
    private static final long serialVersionUID = -1068829814983069233L;

    /**
     * Calls the RuntimeException constructor with the passed message.
     * 
     * @param message Error message sent
     */
    public InvalidValueException(String message)
    {
        super(message);
    }
}
