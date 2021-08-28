package WHOPAYS.Domain;

import java.io.*;

/**
 * Abstract class to make support to the domain controllers.
 */
public abstract class DomainObject implements Serializable {
    public abstract String getDomainID();

    /**
     * Serialize a DomainObject
     * @return A byte array with all the information.
     */
    byte[] deserialize(){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BufferedOutputStream bs2 = new BufferedOutputStream(baos);
            ObjectOutputStream oos = new ObjectOutputStream(bs2);
            oos.writeObject(this);
            oos.close();
            baos.close();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * De-serialize the bytes and returns the DomainObject.
     * @param bytes Bytes
     * @return A DomainObject.
     */
    static DomainObject serialize(byte[] bytes){
        try{
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (DomainObject) ois.readObject();
        }
        catch (InvalidClassException e){
            System.out.println("seems that the saved instances are from a later version or corrupted.!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int hashCode() {
        return this.getDomainID().hashCode();
    }
}
