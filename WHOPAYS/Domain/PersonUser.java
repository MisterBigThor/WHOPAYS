package WHOPAYS.Domain;

import java.util.Objects;

public class PersonUser extends Person{

    String password; //In the real life, take care of this type of fields.

    public PersonUser(int id, String name, String surname, int age, String userName) {
        super(id, name, surname, age, userName);
    }

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
}
