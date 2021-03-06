package WHOPAYS.Domain;

import WHOPAYS.Persistence.PersistenceException;
import WHOPAYS.Persistence.xPersistenceController;

import java.util.Set;

/**
 * Domain controller for all the user instances of the system.
 */
public class xUserController extends xDomainController<PersonUser>{
    /**Singleton instance*/
    static xUserController singletonInstance;
    /**User logged at this moment.*/
    static PersonUser LogUser;

    /**Private builder to support singleton.*/
    private xUserController() throws Exception {
        super(xPersistenceController.getInstance().getDbUsers(), "USER_DOMAIN");
        LogUser = null;
    }

    /**
     * Singleton "builder".
     * @return The singleton instance.
     */
    public static xUserController getInstance() throws Exception {
        if (singletonInstance == null) singletonInstance = new xUserController();
        return singletonInstance;
    }

    /**
     * Log in into the user.
     * @param user Username
     * @param password Password
     * @throws PersonUserException If the password is incorrect.
     * @throws PersistenceException If the user wasn't found.
     */
    public void LoginUser(String user, String password) throws PersonUserException, PersistenceException {
        if(existsUserName(user)){
            LogUser = this.loadEntity(user);
            if(!LogUser.login(password))
                throw new PersonUserException(PersonUserException.BadPassword);
        }
        else throw new PersonUserException(PersonUserException.UserNotFound);
    }

    /**
     * Log out from the current user.
     */
    public void LogOut(){
        LogUser = null;
    }
    public String getLoginUserName() {return LogUser.getUsername();}
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
    public void addUser(String username, String name, String surname, int age, String password) throws PersonUserException {
        if(! existsUserName(username)){
            PersonUser pu = new PersonUser(super.getNextID(), name, surname, age, username, password);
            super.addInstance(pu);
        }
        else throw new PersonUserException(PersonUserException.UserNameDup);
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
