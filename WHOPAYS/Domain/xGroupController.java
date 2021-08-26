package WHOPAYS.Domain;

import WHOPAYS.LOG;
import WHOPAYS.Persistence.xPersitenceController;

import java.util.Set;

/**
 * Domain controller for all the group instances in the system.
 */
public class xGroupController extends xDomainController<Group>{
    /**Singleton instance*/
    static xGroupController singletonInstance;
    static xUserController userDomain;

    /**Private builder to support the singleton design pattern.*/
    private xGroupController() throws Exception {
        super(xPersitenceController.getInstance().getDbGroups(), "GROUP_DOMAIN");
        userDomain = xUserController.getInstance();
    }

    /**
     * Singleton "builder".
     * @return The singleton instance.
     */
    public static xGroupController getInstance() throws Exception {
        if (singletonInstance == null) singletonInstance = new xGroupController();
        return singletonInstance;
    }

    //=================================================================//
    //============================TX METHODS==========================//
    //=================================================================//

    /**
     * Creates a new group in the system.
     * @param grName Group name
     * @param adminID Admin id (username)
     */
    public void createNewGroup(String grName, String adminID){
        if(!persistenceDB.Exists(grName)){

            try {
                PersonUser admin = userDomain.loadEntity(adminID);
                Group g = new Group(grName, super.getNextID(), admin);
                admin.addAdminGroup(g);             //Link the user with the group.
                userDomain.saveInstance(admin);     //Save the modified admin data.
                super.addInstance(g);               //Save the new group
            } catch (Exception e) {
                System.out.printf("The user %s id wasn't found%n", adminID);
            }
        }
    }

    public Set<String> listGroups() {return super.listInstances();}
}

