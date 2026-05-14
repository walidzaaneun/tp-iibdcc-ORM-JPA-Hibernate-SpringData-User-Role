package com.walidzaaneun.tpiibdccspringdatauserrole.services;

import com.walidzaaneun.tpiibdccspringdatauserrole.entities.Role;
import com.walidzaaneun.tpiibdccspringdatauserrole.entities.User;
import com.walidzaaneun.tpiibdccspringdatauserrole.repositories.RoleRepository;
import com.walidzaaneun.tpiibdccspringdatauserrole.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role creatreRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUsername(username);
        Role role = findRoleByName(roleName);
        user.getRoles().add(role);
        role.getUsers().add(user);
        // userRepository.save(user); no need, service is transactional
    }

    @Override
    public User login(String username, String password) {
        User user = findUserByUsername(username);
        if (user == null) throw new RuntimeException("user cannot be null");
        if (user.getPassword().equals(password))
            return user;
        else
            throw new RuntimeException("username or password isnt correct");
    }
}
