package WHOPAYS.Domain;

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
        super(xPersitenceController.getInstance().getDbUsers(), "USER_DOMAIN");
    }

    /**
     * Singleton "builder".
     * @return The singleton instance.
     */
    public static xUserController getInstance() throws Exception {
        if (singletonInstance == null) singletonInstance = new xUserController();
        return singletonInstance;
    }

    //=================================================================//
    //============================TX METHODS==========================//
    //=================================================================//

    /**
     * Create a new user, if the username is not registered yet.
     * @param username Username of the new user.
     * @param name Name of the new user.
     * @param surname Surname of the new user.
     * @param age Age of the new user.
     */
    public void addUser(String username, String name, String surname, int age){
        if(! existsUserName(username)){
            PersonUser pu = new PersonUser(super.getNextID(), name, surname, age, username);
            super.addInstance(pu);
        }
    }

    /**
     * Delete a user from the system.
     * @param username Username to be deleted.
     * @return True if the user was successfully deleted.
     */
    public boolean delUser(String username){
        super.deleteInstance(username);
        return false;
    }

    public Set<String> listUsers(){return super.listInstances();}


    public Boolean existsUserName(String username){
        return instances.containsKey(username);
    }

    protected void saveInstance(PersonUser instance){
        super.editInstance(instance);
    }

}
