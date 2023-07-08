package com.terzo.EmployeeManagement.controller;

import com.terzo.EmployeeManagement.Dto.EmployeeDTO;
import com.terzo.EmployeeManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> listEmployee(){
        List<EmployeeDTO> emp = employeeService.findAllEmployee();
        return emp;
    }
    @PostMapping("/employee/new")
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.saveEmployee(employeeDTO);
    }

    @PutMapping("/employee")
    public void updateDetails(@RequestBody EmployeeDTO employeeDTO){
        employeeService.updateEmployee(employeeDTO);
    }

    @GetMapping("/employee/{employeeId}/details")
    public EmployeeDTO viewEmployee(@PathVariable("employeeId") Long employeeId){
        return employeeService.findEmployeeById(employeeId);
    }

    @DeleteMapping("/employee/{employeeId}/delete")
    public void deleteEmployee(@PathVariable("employeeId") long id){
        employeeService.delete(id);
    }

/*
    @GetMapping("/employeelist/new")
    public List<EmployeeDTO> listEmployeeNew(Model model){
        List<EmployeeDTO> emp = employeeService.findAllEmployee();
        model.addAttribute("employee", emp);
        return emp;
    }



//    @GetMapping("/employee/{employeeId}/edit")
//    public void editEmployeeForm(@PathVariable("employeeId") long employeeId, Model model) {
//        EmployeeDTO employee = employeeService.findEmployeeById(employeeId);
//        model.addAttribute("employee", employee);
//    }


    @GetMapping("/employee/new")
    public String addEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employee-add";
    }



    @GetMapping("/employee/{employeeId}/delete")
    public String deleteEmployeeForm(@PathVariable("employeeId") long employeeId, Model model){
        EmployeeDTO employeeDTO = employeeService.findEmployeeById(employeeId);
        model.addAttribute("employee", employeeDTO);
        return "employee-delete";
    }

    @GetMapping("/employee/{employeeId}/confirm/delete")
    public String deleteClub(@PathVariable("employeeId")long employeeId){
        employeeService.delete(employeeId);
        return "redirect:/employeelist";
    }*/
}
