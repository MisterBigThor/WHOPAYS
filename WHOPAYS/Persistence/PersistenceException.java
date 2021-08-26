package WHOPAYS.Persistence;

/**
 * This exception will be critical for the system.
 */
public class PersistenceException extends Exception{

    public static String UnableCreateDir = "The system was unable to create a directory.";
    public static String DupInstanceIdentifier = "Attempt to save a duplicated instance.";
    public static String NotFoundID = "The requested identifier isn't found.";
    public static String NotFoundOBJ = "Unable to load the requested object.";

    protected boolean isCriticalException;

    public PersistenceException() {
        super("Persistence exception : Generic exception");
    }

    public PersistenceException(String message, boolean isCritical) {
        super(message);
    }
}
