package WHOPAYS.Domain;

public class xGroupController extends xDomainController<Group>{
    /**Singleton instance*/
    static xGroupController singletonInstance;

    /**
     * Private builder to support the singleton design pattern.
     */
    private xGroupController(){super();}

    /**
     * Singleton "builder".
     * @return The singleton instance.
     */
    public static xGroupController getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new xGroupController();
        }
        return singletonInstance;
    }

    //=================================================================//
    //============================TX METHODS==========================//
    //=================================================================//

    /**
     * Creates a new group in the system.
     */
    public void createGroup(){

    }
}
