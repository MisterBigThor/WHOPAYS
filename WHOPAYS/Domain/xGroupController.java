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

    /**
     * Private builder to support the singleton design pattern.
     */
    private xGroupController() throws Exception {super();}

    @Override
    protected void initController() throws Exception {
        //1) Load the db object.
        persistenceDB = xPersitenceController.getInstance().getDbGroups();
        //2) Load all the information.
        Set<String> ids = persistenceDB.GetAllEntities();
        for(String id : ids){
            instances.put(id, null);
        }
        LOG.LOG_INFO(String.format("Loaded %d groups", ids.size()), "GROUP_DOMAIN");
    }

    /**
     * Singleton "builder".
     * @return The singleton instance.
     */
    public static xGroupController getInstance() throws Exception {
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
