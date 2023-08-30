package com.baharmand.dao;

import com.baharmand.model.AppRole;
import com.baharmand.model.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserDAOCollectionTest {
    private AppUserDAO appUserDAO;
    private AppUser appUser1;
    private AppUser appUser2;

    @BeforeEach
    void setUp() {
        appUserDAO = new AppUserDAOCollection();
        appUser1 = new AppUser("user1", "3435", AppRole.ROLE_APP_USER);
        appUser2 = new AppUser("user2", "3r435", AppRole.ROLE_APP_USER);
    }

    @Test
    void testPersistAndFindByUsername() {
        appUserDAO.persist(appUser1);
        appUserDAO.persist(appUser2);
        AppUser foundUser = appUserDAO.findByUsername("user1");
        assertNotNull(foundUser);
        assertEquals(appUser1, foundUser);
    }
    @Test
    void testFindByUsernameNonExistent() {
        AppUser foundUser = appUserDAO.findByUsername("user3");
        assertNull(foundUser);
    }
    @Test
    void testFindAll() {
        appUserDAO.persist(appUser1);
        appUserDAO.persist(appUser2);

        assertEquals(2, appUserDAO.findAll().size());
        assertTrue(appUserDAO.findAll().contains(appUser1));
        assertTrue(appUserDAO.findAll().contains(appUser2));
    }

}
