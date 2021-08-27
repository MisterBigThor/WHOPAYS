package WHOPAYS.ConsoleInterface;

import WHOPAYS.Domain.xGroupController;
import WHOPAYS.Domain.xUserController;
import WHOPAYS.inout;

public class UserMainMethods {

    private static inout io;
    private static xUserController user_domain;
    private static xGroupController group_domain;

    public UserMainMethods(inout io) throws Exception {
        UserMainMethods.io = io;
        user_domain = (xUserController) xUserController.getInstance();
        group_domain = (xGroupController) xGroupController.getInstance();
    }

    public static void AddUserInterface() throws Exception {
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
