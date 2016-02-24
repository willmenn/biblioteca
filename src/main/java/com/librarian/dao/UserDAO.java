package com.librarian.dao;

import com.librarian.entity.User;

public interface UserDAO {

    User login(String number,String pass);
}
