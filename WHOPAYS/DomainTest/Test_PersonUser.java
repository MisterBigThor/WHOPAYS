package WHOPAYS.DomainTest;

import WHOPAYS.Domain.PersonUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_PersonUser {

    @Test
    void testEquals(){
        PersonUser pu1 = new PersonUser(10, "alfa",
                "beta", 10, "michael", "");
        PersonUser pu2 = new PersonUser(10, "alfa",
                "beta", 10, "michael", "");
        PersonUser pu3 = new PersonUser(10, "alfa",
                "beta", 10, "joseLuis", "");
        assertTrue(pu2.equals(pu1));
        assertNotSame(pu1, pu3);
        assertFalse(pu2.equals(pu3));
        assertEquals(pu1.hashCode(), pu2.hashCode());
    }


}