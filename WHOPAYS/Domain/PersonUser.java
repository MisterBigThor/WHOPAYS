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
    /**TODO: Groups I am enrolled*/
    List<Group> myGroups;
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

    //=================================================================//
    //===========================GETTERS===============================//
    //=================================================================//

    public String getUsername() {return this.userName;}

    @Override
    public String getDomainID() {return this.getUsername();}

    @Override
    public String toString() {
        return String.format("User %s (%s, %s)", this.userName, this.surname, this.name);
    }

    @Override
    public boolean equals(PersonUser obj) {return obj.getId() == this.id;}

    //=================================================================//
    //===========================MODIFY================================//
    //=================================================================//

    public void changePassword(String old_password, String new_password) throws PersonUserException {
        if(Objects.equals(this.password, old_password)){
            password= new_password;
        }
        else throw new PersonUserException(PersonUserException.BadPassword);
    }

    public void addAdminGroup(Group g) {
        myAdminGroups.add(g);
    }
}
