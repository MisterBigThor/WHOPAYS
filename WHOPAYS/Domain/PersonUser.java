package WHOPAYS.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * User of the system.
 */
public class PersonUser extends Person{
    /**User password.*/
    String password; //In the real life, take care of this type of fields.
    /**Groups this user is admin.*/
    List<Group> myAdminGroups;
    /**Unique username*/
    String userName;

    public PersonUser(int id, String name, String surname, int age, String userName) {
        super(id, name, surname, age);
        this.userName = userName;
        this.myAdminGroups = new ArrayList<>();
    }

    public PersonUser(int id, String name, String surname, int age, String password, List<Group> myAdminGroups, String userName) {
        super(id, name, surname, age);
        this.password = password;
        this.myAdminGroups = myAdminGroups;
        this.userName = userName;
    }

    public String getUsername() {return this.userName;}

    Boolean changePassword(String old_password, String new_password){
        if(Objects.equals(this.password, old_password)){
            password= new_password;
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "surname='" + surname + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(PersonUser obj) {return obj.getId() == this.id;}

    @Override
    public String getDomainID() {return this.getUsername();}

    public void addAdminGroup(Group g) {
        myAdminGroups.add(g);
    }
}
