package com.walidzaaneun.tpiibdccspringdatauserrole.services;

import com.walidzaaneun.tpiibdccspringdatauserrole.entities.Role;
import com.walidzaaneun.tpiibdccspringdatauserrole.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    User createUser(User user);
    Role creatreRole(Role role);
    User findUserByUsername(String username);
    Role findRoleByName(String name);
    void addRoleToUser(String username,String roleName);
    User login(String username,String password);
}
