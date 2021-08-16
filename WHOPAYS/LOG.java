package WHOPAYS;

public class LOG {

    //TODO: Add support for multiple types of streamings (file, console)...
    public static void LOG_INFO(String msg, String className){
        System.out.println("===="+className+"====: "+ msg);
    }
}
