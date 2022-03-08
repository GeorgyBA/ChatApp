package com.sda.dao;

import com.sda.model.User;

public interface UserDao {
    User getByLoginAndPassword(String login, String password);
    User getByLogin(String login);
}


