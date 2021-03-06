package WHOPAYS.Domain;

public class PersonUserException extends Throwable {

    public static String UserNotFound = "Unable to find the user.";
    public static String BadPassword = "Incorrect password.";
    public static String UserNameDup = "The requested username is already in use.";
    protected static String BadCharacterAtName = "The only characters allowed are in the range [a-z] and [A-Z]";

    public PersonUserException() {
        super("USER EXCEPTION: Generic exception");
    }

    public PersonUserException(String message) {
        super(message);
    }
}
