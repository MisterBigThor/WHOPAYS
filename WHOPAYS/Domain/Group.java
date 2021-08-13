package WHOPAYS.Domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * Represents a group of users, with all the shopping tickets
 * related.
 */
public class Group extends ArrayList<String> {
    String groupName;
    Integer groupAdmin;
    Set<ShoppingTickets> alfa;

    /**
     * Empty constructor, only set the admin and name.
     * @param groupName
     * @param admin
     */
    public Group(String groupName, PersonAdmin admin) {
        setAttributes(admin, groupName);
    }

    /**
     * Default builder, with empty alfa.
     * @param groupName
     * @param admin
     * @param persons
     */
    public Group(String groupName, PersonAdmin admin, Collection<? extends String> persons) {
        super(persons);
        setAttributes(admin, groupName);
    }
    public Group(String groupName, PersonAdmin admin, Collection<? extends String> persons, Collection<? extends ShoppingTickets> tickets){
        super(persons);
        setAttributes(admin, groupName);
        this.alfa = (Set<ShoppingTickets>) tickets;
    }
    private void setAttributes(PersonAdmin admin, String groupName){
        this.groupName = groupName;
        this.groupAdmin = admin.getId();
        alfa = new HashSet<>();
    }

    //TODO: Add support for add tickets

    //
}
