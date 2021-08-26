package WHOPAYS.Persistence;

import WHOPAYS.LOG;

public class xPersistenceController {

    static final String TAG = "Generic persistence controller";
    /**Singleton instance*/
    private static xPersistenceController instance;
    /**Common directory for all the persitence files.*/
    protected static final String dir = ".data";
    /**Database instance for the users*/
    private objectDataBase dbUsers;
    private objectDataBase dbGroups;

    private xPersistenceController() {
    }

    /**
     * get Instance from the singleton design pattern.
     * @return The unique instance of the persistence controller.
     */
    public static xPersistenceController getInstance(){
        if (instance == null)
            instance = new xPersistenceController();
        return instance;
    }

    /**
     * Get the user database. The app will crash if there is any exception.
     * @return An object database object.
     */
    public objectDataBase getDbUsers() {
        if(this.dbUsers == null)
            try{
                this.dbUsers = new objectDataBase(dir, "users");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                LOG.LOG_INFO(e.getMessage(), TAG);
                System.exit(-1);
            }
        return dbUsers;
    }

    /**
     * Get the groups database
     * @return An object database object
     * @throws Exception If there is any problem while loading the database.
     */
    public objectDataBase getDbGroups() throws Exception{
        if(this.dbGroups == null)
            this.dbGroups= new objectDataBase(dir, "groups");
        return dbGroups;
    }
}
