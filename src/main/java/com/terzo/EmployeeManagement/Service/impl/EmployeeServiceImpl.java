package com.terzo.EmployeeManagement.Service.impl;

import com.terzo.EmployeeManagement.Dto.EmployeeDTO;
import com.terzo.EmployeeManagement.Repository.EmployeeRepository;
import com.terzo.EmployeeManagement.Service.EmployeeService;
import com.terzo.EmployeeManagement.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee emp = mapToEmployee(employeeDTO);
        employeeRepository.save(emp);
    }

    private Employee mapToEmployee(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .photoUrl(employeeDTO.getPhotoUrl())
                .email(employeeDTO.getEmail())
                .id(employeeDTO.getId())
                .mobileNo(employeeDTO.getMobileNo())
                .department(employeeDTO.getDepartment())
                .joiningDate(employeeDTO.getJoiningDate())
                .name(employeeDTO.getName())
                .build();
    }

    @Override
    public List<EmployeeDTO> findAllEmployee() {
        List<Employee> emp = employeeRepository.findAll();
        return emp.stream()
                .map(employee -> mapToEmployeeDTO(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findEmployeeById(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        return mapToEmployeeDTO(employee);
    }

    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapToEmployee(employeeDTO);
        employeeRepository.save(employee);
    }

    @Override
    public void delete(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        employeeRepository.delete(employee);
    }

    private EmployeeDTO mapToEmployeeDTO(Employee emp) {
        return EmployeeDTO.builder()
                .department(emp.getDepartment())
                .email(emp.getEmail())
                .id(emp.getId())
                .joiningDate(emp.getJoiningDate())
                .mobileNo(emp.getMobileNo())
                .name(emp.getName())
                .photoUrl(emp.getPhotoUrl())
                .build();
    }




}
