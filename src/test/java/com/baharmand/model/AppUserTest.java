package com.baharmand.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserTest {
    private AppUser user1;
    private AppUser user2;
    private AppUser user3;

    @BeforeEach
    void setup() {
        user1 = new AppUser("user1", "22d", AppRole.ROLE_APP_USER);
        user2 = new AppUser("user2", "hf4", AppRole.ROLE_APP_USER);
        user3 = new AppUser("user1", "dfr", AppRole.ROLE_APP_ADMIN);
    }

    @Test
    public void testEqualsSameInstance() {
        assertTrue(user1.equals(user1));
    }

    @Test
    public void testEqualsDifferentInstances() {
        assertFalse(user1.equals(user2));
        assertFalse(user1.equals(user3)); //same userName different roles

    }

    @Test
    public void testToString(){
        assertEquals("AppUser {" + "userName='" + user1.getUserName() + '\'' + ", role=" + AppRole.ROLE_APP_USER + '}', user1.toString() );
    }
}
