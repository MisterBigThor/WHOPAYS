package WHOPAYS.Domain;

import java.util.Set;
import java.util.TreeMap;

import WHOPAYS.LOG;
import WHOPAYS.Persistence.PersistenceException;
import WHOPAYS.Persistence.objectDataBase;

/**
 * Domain controller generic class.
 * @param <T> A DomainObject subclass, to use in the controller.
 */
public abstract class xDomainController<T extends DomainObject>{
    String instanceName = "Generic Domain Controller";

    Integer ids;
    /**Instances accessed via map, logarithmic cost.*/
    protected TreeMap<String, T> instances;
    /**Persistence object database*/
    protected objectDataBase persistenceDB;

    protected xDomainController(objectDataBase persistenceDB, String LOG_NAME) throws Exception {
        this.instanceName = LOG_NAME;
        this.persistenceDB = persistenceDB;
        instances = new TreeMap<>();
        initController(persistenceDB);

    }

    /**
     * Method to load all the required information.
     */
    protected void initController(objectDataBase persistenceDB) throws Exception{
        LOG.LOG_INFO("Loading data...", instanceName);
        Set<String> identifiers = persistenceDB.GetAllEntities();
        for(String id : identifiers){
            instances.put(id, null); //Save only the id, on demand load the object
        }
        ids = instances.size();
        LOG.LOG_INFO(String.format("Loaded %d instances", ids), instanceName);
    }

    /**
     * Get the next unique integer identifier.
     * @return A unique ID.
     */
    protected int getNextID(){
        int ret = ids;
        ids++;
        return ret;
    }

    /**
     * Add a new record of type T.
     * @param t Object involved
     */
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

    public boolean deleteInstance(String id){
        return null != instances.remove(id);
    }

}
