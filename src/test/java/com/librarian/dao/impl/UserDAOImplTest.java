package com.librarian.dao.impl;

import com.librarian.dao.UserDAO;
import com.librarian.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserDAOImplTest {

    private UserDAO dao;

    @Before
    public void setUp() {
        dao = new UserDAOImpl();
    }


    @Test
    public void shouldPerformLogin() {
        User user = dao.login("01", "pass");
        assertNotNull(user);
    }

    @Test
    public void shouldNotPerformLogin(){
        User user = dao.login("", "");
        assertNull(user);
    }

}
