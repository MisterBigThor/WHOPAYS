package WHOPAYS.Domain;

import java.util.*;

/**
 * Represents a group of users, with all his shopping tickets
 * related.
 */
public class Group implements DomainObject{
    /**Group name (no primary key).*/
    String groupName;
    /**Unique group identifier.*/
    int group_id;
    /**Admin user of the group*/
    PersonAdmin groupAdmin;
    /**User id of the members of this group. */
    Set<PersonUser> groupIntegrates;
    /**Related shopping tickets.*/
    List<ShoppingTickets> ticketHistory;


    /**
     * Empty constructor, set the minimum require members for an empty group.
     * @param groupName Name for the group.
     * @param group_id Unique identifier of the group.
     * @param admin Person who manages this group.
     */
    public Group(String groupName, Integer group_id, PersonAdmin admin) {
        setAttributes(admin, groupName, group_id);
        groupIntegrates = new HashSet<>();
        ticketHistory = new ArrayList<>();
    }

    /**
     * Default builder.
     * @param groupName Name for the group.
     * @param group_id Unique identifier of the group.
     * @param groupAdmin Person who manages this group.
     * @param groupIntegrates Collection of the identifiers of the users
     * @param ticketHistory Sorted collection of all the tickets.
     */
    public Group(String groupName, int group_id, PersonAdmin groupAdmin, Set<PersonUser> groupIntegrates, List<ShoppingTickets> ticketHistory) {
        this.groupName = groupName;
        this.group_id = group_id;
        this.groupAdmin = groupAdmin;
        this.groupIntegrates = groupIntegrates;
        this.ticketHistory = ticketHistory;
    }

    //=================================================================//
    //===========================GETTERS===============================//
    //=================================================================//

    public String getGroupName() {return groupName;}

    public int getGroup_id() {return group_id;}


    //=================================================================//
    //===========================MODIFY================================//
    //=================================================================//

    //TODO: Create ticket, del ticket, modify ticket methods.


    //=================================================================//
    //===========================PRIVATE===============================//
    //=================================================================//

    private void setAttributes(PersonAdmin admin, String groupName, int group_id){
        this.groupName = groupName;
        this.groupAdmin = admin;
        this.group_id = group_id;
        ticketHistory = new ArrayList<>();
    }

    @Override
    public String getDomainID() {
        return String.valueOf(this.group_id);
    }
}
