package WHOPAYS;

import WHOPAYS.Domain.xDomainController;
import WHOPAYS.Domain.xUserController;

class Main{
    public static void main(String[] args) {
        int op = 23;

        inout input = new inout();
        xUserController user_domain = (xUserController) xUserController.getInstance();

        try{
            while(op != 0){
                //Read option:
                op = input.readint();
                switch (op){
                    case 1:
                        //Add user
                        String username=input.readname();
                        String name=input.readname();
                        String surname = input.readname();
                        int age = input.readint();
                        user_domain.addUser(username, name, surname, age);
                        break;
                    case -1:
                        //Delete user:

                        break;
                }
            }
        }
        catch (Exception e){
            System.out.println("Exception:");
            System.out.println(e.toString());
        }




    }
}
