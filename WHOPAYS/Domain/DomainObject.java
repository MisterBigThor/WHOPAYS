package WHOPAYS.Domain;

import java.io.*;

public abstract class DomainObject implements Serializable {
    public abstract String getDomainID();

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
    static DomainObject serialize(byte[] bytes){
        try{
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (DomainObject) ois.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
