package com.walidzaaneun.tpiibdccspringdatauserrole;

import com.walidzaaneun.tpiibdccspringdatauserrole.entities.Role;
import com.walidzaaneun.tpiibdccspringdatauserrole.entities.User;
import com.walidzaaneun.tpiibdccspringdatauserrole.services.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpIibdccSpringDataUserRoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpIibdccSpringDataUserRoleApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IUserService userService){
        return args -> {
            User u1 = User.builder()
                    .username("walidzaaneun")
                    .password("pass1234")
                    .build();
            User u2 = User.builder()
                    .username("mohamedyousfi")
                    .password("pass5678")
                    .build();
            User u3 = User.builder()
                    .username("admin")
                    .password("admin1234")
                    .build();

            userService.createUser(u1);
            userService.createUser(u2);
            userService.createUser(u3);

            Role r1 = Role.builder()
                    .name("STUDENT")
                    .build();
            Role r2 = Role.builder()
                    .name("TEACHER")
                    .build();
            Role r3 = Role.builder()
                    .name("ADMIN")
                    .build();

            userService.creatreRole(r1);
            userService.creatreRole(r2);
            userService.creatreRole(r3);

            userService.addRoleToUser("admin","ADMIN");
            userService.addRoleToUser("walidzaaneun","STUDENT");
            userService.addRoleToUser("mohamedyousfi","TEACHER");
            userService.addRoleToUser("mohamedyousfi","ADMIN");

            try {
                User user = userService.login("walidzaaneun","pass1234");
                System.out.println("Login succesful : "+ user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
