package WHOPAYS.ConsoleInterface;

import WHOPAYS.Domain.PersonUserException;
import WHOPAYS.Domain.xGroupController;
import WHOPAYS.Domain.xUserController;
import WHOPAYS.inout;

/**
 * User related commands implementation.
 */
public class UserMainMethods {

    private static final inout io = inout.getInstance();
    private static xUserController user_domain;
    private static xGroupController group_domain;
    static {
        try {
            user_domain = xUserController.getInstance();
            group_domain = xGroupController.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loginLoop() throws Exception {
        boolean correctLogin = false;
        while(!correctLogin){ //Can use while(true) + break;
            try {
                io.writeln("====LOGIN====");
                user_domain.LoginUser(
                        io.userQuestionString("Enter the username:"),
                        io.userQuestionString("Enter the password"));
                io.writeln("Correct login");
                correctLogin = true;
            }
            catch (PersonUserException e) {
                System.out.println(e.getMessage());
            }
        }
        io.writeln(String.format("Actual user: %s", user_domain.getLoginUserName()));
    }

    public static void LogOut(){
        user_domain.LogOut();
    }

    public static void AddUserInterface() throws Exception, PersonUserException{
        io.writeln("Adding a user...");
        user_domain.addUser(io.userQuestionString("Enter username: "),
                io.userQuestionString("Enter name: "),
                io.userQuestionString("Enter surname: "),
                io.userQuestionInteger("Enter age: "),
                io.userQuestionString("Enter password: "));
    }

    public static void DeleteUserInterface() throws Exception{
        String s_username = io.userQuestionString("Enter username to be deleted: ");
        if(!user_domain.existsUserName(s_username))
            io.writeln("The user " + s_username + "wasn't in the system.");

        if(! user_domain.delUser(s_username))
            io.writeln("Error deleting the user: " + s_username);
    }


}
