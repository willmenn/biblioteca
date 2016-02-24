package com.librarian.dao.impl;

import com.librarian.dao.UserDAO;
import com.librarian.entity.User;

public class UserDAOImpl implements UserDAO {

    public User login(String number, String pass) {
        User user = new User("Gandalf", "gandalf@cinzento.com", "000-000-1001", "01", "pass");
        if ((number.equals(user.getLibNumber())) && (pass.equals(user.getPassword()))) {
            return user;
        }
        return null;
    }
}
