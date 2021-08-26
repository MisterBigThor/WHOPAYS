package WHOPAYS;

import WHOPAYS.Domain.xDomainController;
import WHOPAYS.Domain.xGroupController;
import WHOPAYS.Domain.xUserController;

//FIXME: Use user id's or use the object itself. (For the moment use objects).

class Main{
    public static void main(String[] args) throws Exception {
        //Local auxiliary variables:
        int op = 23;
        String s_username;

        inout input = new inout();
        //Initialize domain controllers:
        xUserController user_domain = (xUserController) xUserController.getInstance();
        xGroupController group_domain = (xGroupController) xGroupController.getInstance();
        //Loop for the commands.
        try{
        while(op != 0){
            input.writeln("Enter 0 to exit, or one of the following commands:");
            input.writeln(MainCommands.commands);
            op = input.readint();
            switch (op){
                case 1:
                    //Add user
                    input.writeln("Adding a user...");
                    user_domain.addUser(input.userQuestionString("Enter username: "),
                            input.userQuestionString("Enter name: "),
                            input.userQuestionString("Enter surname: "),
                            input.userQuestionInteger("Enter age: "));
                    break;
                case 2:
                    //Delete user:
                    s_username = input.userQuestionString("Enter username to be deleted: ");
                    if(!user_domain.existsUserName(s_username))
                        input.writeln("The user " + s_username + "wasn't in the system.");

                    if(! user_domain.delUser(s_username))
                        input.writeln("Error deleting the user: " + s_username);
                    break;
                case 3:
                    //List users:
                    input.writeln(user_domain.listUsers().toString());
                    break;
                case 4:
                    //Create group

                    break;
                case 5:
                    //Delete groups

                    break;
                case 6:
                    //List ticket.

                    break;
                case 7:
                    //List debts.

                    break;
            }
        }
        }
        catch (Exception e){
            System.out.println("!!! Exception thrown !!!");
            System.out.println(e.toString());
        }
    }
}
