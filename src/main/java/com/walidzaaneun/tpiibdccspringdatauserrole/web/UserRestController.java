package com.walidzaaneun.tpiibdccspringdatauserrole.web;

import com.walidzaaneun.tpiibdccspringdatauserrole.entities.User;
import com.walidzaaneun.tpiibdccspringdatauserrole.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserRestController {
    private IUserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{username}")
    public User findUser(@PathVariable String username){
        return userService.findUserByUsername(username);
    }

}
