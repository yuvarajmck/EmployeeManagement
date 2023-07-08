package com.terzo.EmployeeManagement.Repository;

import com.terzo.EmployeeManagement.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
