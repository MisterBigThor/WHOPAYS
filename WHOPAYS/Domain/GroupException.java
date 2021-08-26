package WHOPAYS.Domain;

public class GroupException extends Exception{

    protected static String FullGroup = "The group have reached the maximum persons limit.";
    protected static String UserNotFound = "The user is already registered at the group.";
    protected static String UserAlreadyAdmin = "The user is an admin already.";

    public GroupException() {
        super("GROUP_EXCEPTION : Generic error at group object");
    }

    public GroupException(String message) {
        super(message);
    }
}
