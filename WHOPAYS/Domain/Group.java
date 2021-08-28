package WHOPAYS.Domain;

import java.util.*;

/**
 * Represents a group of users, with all his shopping tickets
 * related.
 */
public class Group extends DomainObject{
    /**Group name (no primary key).*/
    String groupName;
    /**Unique group identifier.*/
    int group_id;
    /**User with admin rights over this group.*/
    Set<PersonUser> adminRights;
    /**User id of the members of this group. All admins are also integrates*/
    Set<PersonUser> groupIntegrates;
    /**Related shopping tickets.*/
    List<ShoppingTickets> ticketHistory;
    /**Max users per group*/
    static int MAX_USERS = 100;

    /**
     * Empty constructor, set the minimum require members for an empty group.
     * @param groupName Name for the group.
     * @param group_id Unique identifier of the group.
     * @param admin Person who manages this group.
     */
    public Group(String groupName, Integer group_id, PersonUser admin) {
        setAttributes(admin, groupName, group_id);
        this.groupIntegrates.add(admin);
    }

    /**
     * Default builder.
     * @param groupName Name for the group.
     * @param group_id Unique identifier of the group.
     * @param groupAdmin Person who manages this group.
     * @param groupIntegrates Collection of the identifiers of the users
     * @param ticketHistory Sorted collection of all the tickets.
     */
    public Group(String groupName, int group_id, PersonUser groupAdmin,
                 Set<PersonUser> groupIntegrates, List<ShoppingTickets> ticketHistory) {
        setAttributes(groupAdmin, groupName, group_id);
        this.groupIntegrates = groupIntegrates;
        this.ticketHistory = ticketHistory;
    }

    //=================================================================//
    //===========================GETTERS===============================//
    //=================================================================//

    public String getGroupName() {return groupName;}

    public int getGroup_id() {return group_id;}

    /**
     * List all the users with admin rights in this group.
     * @return A list string with the username of all the users with admin rights.
     */
    public Set<String> getGroupAdmins(){
        Set<String> ret = new HashSet<>();
        this.adminRights.forEach(personUser -> {ret.add(personUser.userName);});
        return ret;
    }

    /**
     * List all the users in the group.
     * @return A string list with the usernames.
     */
    public Set<String> getGroupIntegrates(){
        Set<String> ret = new HashSet<>();
        this.groupIntegrates.forEach((personUser -> {ret.add(personUser.userName);}));
        return ret;
    }

    @Override
    public String getDomainID() {
        return String.valueOf(this.group_id);
    }

    @Override
    public String toString() {
        return String.format("%d - Group %s, admins : %s. \n\t Users: %s\n", this.group_id, this.groupName, this.adminRights.toString(), this.groupIntegrates.toString());
    }


    //=================================================================//
    //===========================MODIFY================================//
    //=================================================================//

    //************************USER RELATED METHODS*********************//

    /**
     * Add a user to this group.
     * @param p Person to be added.
     * @param adminRights If true, the user will have admin rights.
     * @throws GroupException If the user was already in the group, the person limit has reached, or it was an admin already
     */
    public void addUser(PersonUser p, boolean adminRights) throws GroupException {
        if(this.groupIntegrates.size() >= MAX_USERS)
            throw new GroupException(GroupException.FullGroup);

        if(!this.groupIntegrates.add(p))
            throw new GroupException(GroupException.UserNotFound);

        if(adminRights)
            if(!this.adminRights.add(p)) throw new GroupException(GroupException.UserAlreadyAdmin);

    }

    public void addAdminRights(PersonUser p) throws Exception {
        if(!this.adminRights.add(p))
            throw new GroupException(GroupException.UserAlreadyAdmin);
    }
    public void delUser(PersonUser p) throws GroupException {
        boolean remove = this.groupIntegrates.remove(p);
        if(!remove) throw new GroupException(GroupException.UserNotFound);
    }

    public void delUserById(String id) throws GroupException{
        this.delUser(new PersonUser(id));
    }

    //************************TICKETS RELATED METHODS*********************//
    //TODO: Create ticket, del ticket, modify ticket methods.



    //=================================================================//
    //===========================PRIVATE===============================//
    //=================================================================//

    /**
     * Set the value of the following attributes:
     * @param admin Admin of the group
     * @param groupName Name of the group.
     * @param group_id Unique identifier of the group.
     */
    private void setAttributes(PersonUser admin, String groupName, int group_id){
        this.groupName = groupName;
        this.group_id = group_id;
        this.adminRights = new HashSet<>(MAX_USERS);
        adminRights.add(admin);
        groupIntegrates = new HashSet<>(MAX_USERS);
        ticketHistory = new ArrayList<>();
    }
}
