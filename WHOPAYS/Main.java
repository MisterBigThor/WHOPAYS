package WHOPAYS;

import WHOPAYS.Domain.*;

class Main{
    public static void main(String[] args) {
        int op = 23;
        inout input = new inout();
        try{
            while(op != 0){
                //Read option:
                op = input.readint();
                switch (op){
                    case 1:
                        //Add user

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
