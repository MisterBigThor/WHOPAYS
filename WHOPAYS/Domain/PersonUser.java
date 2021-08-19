package WHOPAYS.Domain;

import java.util.List;
import java.util.Objects;

public class PersonUser extends Person{
    /**User password.*/
    String password; //In the real life, take care of this type of fields.
    /**Groups this user is admin.*/
    List<Group> myAdminGroups;
    String userName;

    public PersonUser(int id, String name, String surname, int age, String userName) {
        super(id, name, surname, age);
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
}
