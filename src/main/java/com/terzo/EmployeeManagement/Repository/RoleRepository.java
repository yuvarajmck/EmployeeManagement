package com.terzo.EmployeeManagement.Repository;


import com.terzo.EmployeeManagement.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
