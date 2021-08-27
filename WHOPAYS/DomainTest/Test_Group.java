package WHOPAYS.DomainTest;

import WHOPAYS.Domain.GroupException;
import WHOPAYS.Domain.PersonUser;
import WHOPAYS.Domain.Group;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Test_Group {

    /**
     * Create a simple group with one admin:
     */
    @Test
    void createGroup(){
        int id = 0;
        PersonUser pu = newRandomUsers(0);
        Group gr = new Group("myGroup", 12, pu);
        for (int i = 1; i < 25; i++) {
            PersonUser pu2 = newRandomUsers(++id);
            try {
                gr.addUser(pu2, false);
            } catch (GroupException e) {
                System.out.println(e.getMessage());
            }
        }
        assertEquals(gr.getGroupAdmins().size(), 1);
        assertEquals(gr.getGroupIntegrates().size(), 24);
    }

    /**
     * Create a group and erase 10 people.
     */
    @Test
    void createGroup2(){

    }

    private PersonUser newRandomUsers(int id){
        String name = "name";
        String surname = "surname";
        int age = 23;
        //Random create a username string:
        byte[] arr = new byte[7];
        new Random().nextBytes(arr);
        String username = new String(arr, StandardCharsets.US_ASCII);
        PersonUser ret = new PersonUser(id, name, surname, age, username, "");
        return ret;
    }
}