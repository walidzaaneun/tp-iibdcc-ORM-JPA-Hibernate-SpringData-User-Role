package com.walidzaaneun.tpiibdccspringdatauserrole.repositories;

import com.walidzaaneun.tpiibdccspringdatauserrole.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
    Role findByName(String name);
}
