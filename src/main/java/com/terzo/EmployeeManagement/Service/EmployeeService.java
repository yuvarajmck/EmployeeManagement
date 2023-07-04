package com.terzo.EmployeeManagement.Service;

import com.terzo.EmployeeManagement.Dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService{
    void updateEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> findAllEmployee();

    EmployeeDTO findEmployeeById(long employeeId);

    void saveEmployee(EmployeeDTO employeeDTO);

    void delete(long employeeId);
}
