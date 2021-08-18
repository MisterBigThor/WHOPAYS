package WHOPAYS.Domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents an item, bought by a person and used by one or more
 * persons.
 */
public class Item {
    /**String reference of the object.*/
    String title;
    /**Price of the item.*/
    float price;
    /**Person who buys this item.*/
    PersonUser buyer;
    /**Persons who uses this item.*/
    Set<PersonUser> itemUsers;

    public Item(String title, float price, PersonUser buyer) {
        this.title = title;
        this.price = price;
        this.buyer = buyer;
        itemUsers = new HashSet<>();
    }

    public Item(String title, float price, PersonUser buyer, Set<PersonUser> itemUsers) {
        this.title = title;
        this.price = price;
        this.buyer = buyer;
        this.itemUsers = itemUsers;
    }
}
