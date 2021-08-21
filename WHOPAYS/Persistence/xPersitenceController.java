package WHOPAYS.Persistence;

public class xPersitenceController {

    static final String TAG = "Generic persistence controller";
    /**Singleton instance*/
    private static xPersitenceController instance;
    /**Common directory for all the persitence files.*/
    protected static final String dir = ".data";
    /**Database instance for the users*/
    private objectDataBase dbUsers;
    private objectDataBase dbGroups;

    private xPersitenceController() {
    }

    /**
     * get Instance from the singleton design pattern.
     * @return The unique instance of the persistence controller.
     */
    public static xPersitenceController getInstance(){
        if (instance == null) {
            try {
                instance = new xPersitenceController();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public objectDataBase getDbUsers() throws Exception {
        if(this.dbUsers == null)
            this.dbUsers = new objectDataBase(dir, "users");
        return dbUsers;
    }

    public objectDataBase getDbGroups() throws Exception {
        if(this.dbGroups == null)
            this.dbGroups= new objectDataBase(dir, "groups");
        return dbGroups;
    }
}
