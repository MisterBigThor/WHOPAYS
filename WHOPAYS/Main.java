package WHOPAYS;

import WHOPAYS.ConsoleInterface.MainCommands;
import WHOPAYS.ConsoleInterface.*;
import WHOPAYS.Domain.PersonUserException;
import WHOPAYS.Domain.xGroupController;
import WHOPAYS.Domain.xUserController;

//FIXME: Use user id's or use the object itself. (For the moment use objects).

class Main{
    public static void main(String[] args) throws Exception {
        //Local auxiliary variables:
        int op = 23;
        boolean log = false;

        inout input = inout.getInstance();

        //Initialize domain controllers:
        xUserController user_domain = (xUserController) xUserController.getInstance();
        xGroupController group_domain = (xGroupController) xGroupController.getInstance();

        //Loop for the commands.
        try{
        while(op != 0){
            if(!log){
                int x = input.userQuestionInteger("0. To login, 1 or greater to create a new user.");
                if(x >= 1){
                    input.writeln("Adding a new user...");
                    try {
                        UserMainMethods.AddUserInterface();
                    }
                    catch (PersonUserException e) {
                        input.writeln(e.getMessage());
                    }

                }
                UserMainMethods.loginLoop();
                log = true;
            }
            input.writeln("Enter 0 to exit, or one of the following commands:");
            input.writeln(MainCommands.commands);
            op = input.readint();
            switch (op){
                case 1:
                    //Add user
                    try {
                        UserMainMethods.AddUserInterface();
                    }
                    catch (PersonUserException e) {input.writeln(e.getMessage());}
                    break;

                case 2:
                    //Delete user:
                    UserMainMethods.DeleteUserInterface();
                    break;

                case 3:
                    //List users:
                    input.writeln(user_domain.listUsers().toString());
                    break;

                case 4:
                    //Create group
                    group_domain.createNewGroup(
                            input.userQuestionString("Name of the new group?"),
                            input.userQuestionString("Admin id ?"));
                    break;

                case 5:
                    //Delete groups
                    input.writeln(group_domain.listGroups().toString());
                    group_domain.deleteGroup(
                            input.userQuestionString("Enter the Id of the group to be deleted:")
                    );
                    break;

                case 6:
                    //Add users to the group.
                    input.writeln(group_domain.listGroups().toString());
                    group_domain.addUserToGroup(
                            input.userQuestionString("Enter the Id of the group to be edited:"),
                            input.userQuestionString("Enter the Id of the user to be added:")
                    );
                    break;

                case 7:
                    //List groups.
                    input.writeln(group_domain.listGroups().toString());
                    break;
                case 8:
                    //Log Out
                    UserMainMethods.LogOut();
                    log = false;
                    break;
                case 9:
                    //Log Out && end the application.
                    UserMainMethods.LogOut();
                    log = false;
                    System.exit(0);
                    break;
            }
        }
        }
        catch (Exception e){
            System.out.println("!!! Exception thrown !!!");
            System.out.println(e.getMessage());
        }
    }
}
