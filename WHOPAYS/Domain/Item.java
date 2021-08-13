package WHOPAYS.Domain;

import java.util.Set;

public class Item {
    String reference;
    float price;
    Person buyer;

    Item(String reference, float price){

    }

    void setBuyer(Person p){
        this.buyer = p;
    }

}
