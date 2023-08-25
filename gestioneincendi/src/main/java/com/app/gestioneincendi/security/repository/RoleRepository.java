package com.app.gestioneincendi.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gestioneincendi.security.entity.ERole;
import com.app.gestioneincendi.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
