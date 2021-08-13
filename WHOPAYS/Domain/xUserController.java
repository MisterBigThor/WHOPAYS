package WHOPAYS.Domain;

public class xUserController extends xDomainController<PersonUser>{
    static xUserController singletonInstance;

    private xUserController() {
        super();
    }

    public static xUserController getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new xUserController();
        }
        return singletonInstance;
    }

    @Override
    protected void getInstancesFromBD() {
        instances.put("bigThor", new PersonUser(0, "alfa", "beta", 10, "bigThor"));
        instances.put("small0", new PersonUser(1, "alfa", "beta", 10, "smallO"));
        instances.put("Valtteri", new PersonUser(2, "alfa", "beta", 10, "Valtteri"));
        instances.put("VB", new PersonUser(3, "alfa", "beta", 10, "VB"));
    }

    //Controller methods:
    private Boolean existsUserName(String username){
        return instances.containsKey(username);
    }

    public void addUser(String username, String name, String surname, int age){
        if(! existsUserName(username)){
            PersonUser pu = new PersonUser(super.getNextID(), name, surname, age, username);
            super.addInstance(pu);
        }
    }
    public void createGroup(){

    }


}
