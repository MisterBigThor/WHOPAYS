package WHOPAYS.Persistence;

import java.io.*;
import java.nio.file.Files;
import java.util.Set;
import java.util.TreeMap;
import WHOPAYS.LOG;

/**
 * A class to store information of classes with the same type.
 * Each file contains a class, serialized into bytes.
 * @author vcorreal
 */
public abstract class xPersistenceController<Identifier> {

    /**File with all the information of all the objects*/
    private File file_ids;
    /**Map of objects(save in a file), each entry points to a file
     * with the information.*/
    private TreeMap<Identifier, File> objectInformation;
    /**Path to save the information.*/
    private String path = "";
    /**Number of objects*/
    private int n;

    public static final String CLASS_NAME = "PERSISTENCE";

    //TODO: Add critical exception.
    /**
     * Default builder.
     * @param baseFolder Base directory to store the data.
     * @param name Name of the database.
     * @throws Exception Critical exception, the app will crash.
     */
    public xPersistenceController(String baseFolder, String name) throws Exception {
        LOG.LOG_INFO("Loading data from " + name, CLASS_NAME);
        this.path = baseFolder+File.separator+name;
        this.n = 0;
        //Create the directory for the Persistence info:
        File f = new File(this.path);
        f.mkdirs();

        file_ids = new File(this.path+File.separator+"metadata.bin");
        if(! file_ids.exists()){
            LOG.LOG_INFO("Creating a new internal control file...", CLASS_NAME);
            if(!file_ids.createNewFile()) throw new PersistenceException();
            SaveMap();
            n = objectInformation.size();
            LOG.LOG_INFO("Found "+ n + "entities.", CLASS_NAME);
        }
        else LoadMap();
    }
    //=================================================================//
    //=========================ENTITY METHODS==========================//
    //=================================================================//

    /**
     * Saves a new object.
     * @param id Unique identifier
     * @param obj_bytes Bytes associated with the new object.
     * @throws PersistenceException if the id is already used.
     */
    public void SaveRecord(Identifier id, byte[] obj_bytes) throws PersistenceException {
        if(Exists(id)) throw new PersistenceException();
        try{
            File f = new File(path+File.separator+id+".bin");
            if(! f.createNewFile()) throw new PersistenceException();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(obj_bytes);
            fos.close();
            objectInformation.put(id, f);
            SaveMap();
            n += 1;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException();
        }
    }

    /**
     * Check if a unique ID exists in the system.
     * @param id
     * @return Boolean value.
     */
    public boolean Exists(Identifier id){return objectInformation.containsKey(id);}

    /**
     * Delete the entity identified with id.
     * @param id Unique identifier of the entity.
     * @throws PersistenceException If the id doesn't exists.
     */
    public void DeleteEntity(Identifier id) throws PersistenceException {
        final File f = GetEntityFile(id);
        //"Can't delete the entity "+id
        if(! f.delete()) throw new PersistenceException();
        objectInformation.remove(id);
        SaveMap();
        n -= 1;
    }

    /**
     * Modify the entity attributes.
     * @param id Unique identifier of the entity.
     * @param obj_bytes Bytes associated with the object.
     */
    public void ModifyEntity(Identifier id, byte[] obj_bytes){
        try{
            DeleteEntity(id);
            SaveRecord(id, obj_bytes);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Get the object bytes of the entity identified with id.
     * @param id Identifier of the entity.
     * @return A byte array with a deserialized object.
     */
    public byte[] getObject(Identifier id) throws PersistenceException {
        byte[] ret = null;
        try{
            final File obj = objectInformation.get(id);
            if (obj == null) throw new PersistenceException();

            ret = Files.readAllBytes(obj.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Get all the identifiers of persistence.
     * @return A set of identifiers.
     */
    public Set<Identifier> GetAllEntities(){return objectInformation.keySet();}

    //=================================================================//
    //=========================PRIVATE METHODS=========================//
    //=================================================================//

    /**
     * Load the information of all the objects (the object information attribute).
     */
    private void LoadMap(){
        try{
            FileInputStream fis = new FileInputStream(file_ids);
            ObjectInputStream ois = new ObjectInputStream(fis);
            objectInformation = (TreeMap<Identifier, File>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Save the information of all the objects controlled here.
     */
    private void SaveMap(){
        try {
            FileOutputStream fos = new FileOutputStream(file_ids);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objectInformation);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the information of the object related with the id.
     * @param id Object unique identifier.
     * @return The file object associated with the id.
     * @throws PersistenceException If the information of the entity isn't found.
     */
    private File GetEntityFile(Identifier id) throws PersistenceException{
        final File f = objectInformation.get(id);
        //"The entity "+ id + "doesn't exist"
        if (f == null) throw new PersistenceException();
        return f;
    }
}
