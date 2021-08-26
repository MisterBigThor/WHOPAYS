package WHOPAYS.Domain;

import java.util.HashSet;
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
     * @param t Object involved.
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

    /**
     * Edit the fields of the instance
     * @param t New data object.
     */
    protected void editInstance(T t) {
        //Save the new instance:
        instances.put(t.getDomainID(), t);
        persistenceDB.ModifyEntity(t.getDomainID(), t.deserialize());
    }
    /**
     * Gets the entity under demand, if the entity is already loaded, the information
     * is returned.
     * @param id Identifier of the entity
     * @return The object requested.
     * @throws Exception If something IO exceptions is thrown.
     */
    protected T loadEntity(String id) throws Exception {
        T t = instances.get(id);
        if(t == null) {
            byte[] object = persistenceDB.getObject(id);
            t = (T) DomainObject.serialize(object);
            instances.put(id, t);
        }
        return t;
    }

    public boolean deleteInstance(String id){
        try {
            persistenceDB.DeleteEntity(id);
        } catch (PersistenceException e) {
            e.printStackTrace();
            return false;
        }
        return null != instances.remove(id);
    }

    public Set<String> listInstances(){
        Set<String> ret = new HashSet<>();
        for (String id: instances.keySet()) {
            ret.add(instances.get(id).toString()+"\n");
        }
        return ret;
    }
}
