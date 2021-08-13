package WHOPAYS.Domain;

import java.util.TreeMap;

/**
 * Domain controller generic class.
 * @param <T> A DomainObject subclass, to use in the controller.
 */
public abstract class xDomainController<T extends DomainObject>{
    Integer ids;

    protected TreeMap<String, T> instances;
    //TODO: Reference to the database controller objects.

    public xDomainController() {
        instances = new TreeMap<>();
        getInstancesFromBD();
        ids = instances.size();
    }
    protected void getInstancesFromBD(){
        //Call BD to get instances.
    }

    protected int getNextID(){
        int ret = ids;
        ids++;
        return ret;
    }

    protected void addInstance(T t){
        instances.put(t.getDomainID(), t);
    }
}
