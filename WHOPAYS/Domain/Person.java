package WHOPAYS.Domain;

/**
 * Represents a person with name, surname and age.
 */
public abstract class Person extends DomainObject {

    int id;
    String name;
    String surname;
    int age;

    static int int_invalid_field = -1;
    static String str_invalid_field = "";


    /**
     * Empty person.
     */
    public Person(){
        id = int_invalid_field;
        name = str_invalid_field;
        surname = str_invalid_field;
        age = int_invalid_field;
    }
    /**
     * Constructor with all the fields.
     * @param id Unique identifier
     * @param name Person name
     * @param surname Person surname
     * @param age Person age.
     */
    public Person(int id, String name, String surname, int age){
        //If we don't use this. to refer to the class, the variables
        //are shadow by the parameters.
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + "-> " + surname + ", " + name + " [" + age + ']';
    }

    public abstract boolean equals(PersonUser obj);
}
