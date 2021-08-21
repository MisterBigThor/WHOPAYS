package WHOPAYS.Domain;

import WHOPAYS.LOG;
import WHOPAYS.Persistence.xPersitenceController;

import java.util.Set;

/**
 * Domain controller for all the user instances of the system.
 */
public class xUserController extends xDomainController<PersonUser>{
    /**Singleton instance*/
    static xUserController singletonInstance;

    /**Private builder to support singleton.*/
    private xUserController() throws Exception {
        super();

    }

    /**
     * Singleton "builder".
     * @return The singleton instance.
     */
    public static xUserController getInstance() throws Exception {
        if (singletonInstance == null) {
            singletonInstance = new xUserController();
        }
        return singletonInstance;
    }

    @Override
    protected void initController() throws Exception {
        LOG.LOG_INFO("Loading users bd", "USER_DOMAIN");
        //1) Load the db object.
        persistenceDB = xPersitenceController.getInstance().getDbUsers();

        //2) Load all the information.
        Set<String> identifiers = persistenceDB.GetAllEntities();
        for(String id : identifiers){
            instances.put(id, null); //Save only the id, on demand load the object
        }
        LOG.LOG_INFO(String.format("Loaded %d users", identifiers.size()), "USER_DOMAIN");
    }

    //=================================================================//
    //============================TX METHODS==========================//
    //=================================================================//

    public void addUser(String username, String name, String surname, int age){
        if(! existsUserName(username)){
            PersonUser pu = new PersonUser(super.getNextID(), name, surname, age, username);
            super.addInstance(pu);
        }
    }
    public void delUser(String username){

    }


    public Boolean existsUserName(String username){
        return instances.containsKey(username);
    }

}
