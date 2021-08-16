package WHOPAYS.Domain;

import java.util.TreeMap;

/**
 * Domain controller generic class.
 * @param <T> A DomainObject subclass, to use in the controller.
 */
public abstract class xDomainController<T extends DomainObject>{
    Integer ids;
    //TODO: Add on-demand loading boolean.
    protected TreeMap<String, T> instances;
    //TODO: Reference to the database controller objects.

    protected xDomainController() {
        instances = new TreeMap<>();
        getInstancesFromBD();
        ids = instances.size();
    }

    protected void getInstancesFromBD(){
        //Call BD to get instances.
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

    protected void addInstance(T t){
        //Save in the domain:
        instances.put(t.getDomainID(), t);
        //Pass the information to the persistence layer:

    }
}
