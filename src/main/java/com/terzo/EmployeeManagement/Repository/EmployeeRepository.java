package com.terzo.EmployeeManagement.Repository;

import com.terzo.EmployeeManagement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByName(String url);
}
