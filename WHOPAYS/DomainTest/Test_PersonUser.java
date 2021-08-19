package WHOPAYS.DomainTest;

import WHOPAYS.Domain.PersonUser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Test_PersonUser {

    @Test
    void testEquals(){
        PersonUser pu1 = new PersonUser(10, "alfa",
                "beta", 10, "michael");
        PersonUser pu2 = new PersonUser(10, "alfa",
                "beta", 10, "michael");
        assertTrue(pu2.equals(pu1));
        assertNotSame(pu1, pu2);
        pu2.setId(2344);
        assertFalse(pu2.equals(pu1));
    }


}