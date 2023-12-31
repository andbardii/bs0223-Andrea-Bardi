package com.app.devicehandler.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.devicehandler.security.entity.ERole;
import com.app.devicehandler.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
