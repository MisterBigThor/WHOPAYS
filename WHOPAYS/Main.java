package WHOPAYS;

import WHOPAYS.Domain.xDomainController;
import WHOPAYS.Domain.xGroupController;
import WHOPAYS.Domain.xUserController;

//FIXME: Use user id's or use the object itself. (For the moment use objects).

class Main{
    public static void main(String[] args) throws Exception {
        int op = 23;

        inout input = new inout();
        //Initialize domain controllers:
        xUserController user_domain = (xUserController) xUserController.getInstance();
        xGroupController group_domain = (xGroupController) xGroupController.getInstance();
        //Loop for the commands.
        try{
            while(op != 0){
                input.writeln("Enter 0 to exit, or one of the following commands:");
                String commands_txt = "1, -1, 2, -2"; //todo: Move to static in a class
                input.writeln(commands_txt);
                op = input.readint();
                switch (op){
                    case 1:
                        //Add user
                        input.writeln("Adding a user...");
                        String name= input.userQuestionString("Enter name: ");
                        String surname = input.userQuestionString("Enter surname: ");
                        String s_username = input.userQuestionString("Enter username: ");
                        int age = input.userQuestionInteger("Enter age: ");

                        user_domain.addUser(s_username, name, surname, age);
                        break;
                    case -1:
                        //Delete user:
                        String s_usr=input.readname();
                        user_domain.delUser(s_usr);
                        break;
                    case 2:
                        //Create group

                        break;

                    case -2:
                        //Delete group

                        break;
                    case 3:
                        //Create ticket

                        break;
                    case -3:
                        //Delete ticket.

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
