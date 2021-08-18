package WHOPAYS.Domain;



public class PersonAdmin extends PersonUser {

    //TODO: Add attribute for the managed groups.

    public PersonAdmin(int id, String name, String surname, int age, String userName) {
        super(id, name, surname, age, userName);
    }
}
