package WHOPAYS.Domain;

import java.util.TreeMap;

import WHOPAYS.LOG;
import WHOPAYS.Persistence.PersistenceException;
import WHOPAYS.Persistence.objectDataBase;

/**
 * Domain controller generic class.
 * @param <T> A DomainObject subclass, to use in the controller.
 */
public abstract class xDomainController<T extends DomainObject>{
    static String instanceName = "Generic Domain Controller";

    Integer ids;
    //TODO: Add on-demand loading boolean.
    /**Instances accessed via map, logarithmic cost.*/
    protected TreeMap<String, T> instances;
    /**Persistence object database*/
    protected objectDataBase persistenceDB;

    protected xDomainController() throws Exception {
        instances = new TreeMap<>();
        initController();
        ids = instances.size();
    }

    /**
     * Method to load all the required information.
     */
    protected abstract void initController() throws Exception;

    /**
     * Get the next unique integer identifier.
     * @return A unique ID.
     */
    protected int getNextID(){
        int ret = ids;
        ids++;
        return ret;
    }

    protected void addInstance(T t){
        //Save in the domain:
        instances.put(t.getDomainID(), t);
        //Pass the information to the persistence layer:
        try {
            persistenceDB.SaveRecord(t.getDomainID(), t.deserialize());
        }
        catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
}
