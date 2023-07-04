package com.terzo.EmployeeManagement.controller;

import com.terzo.EmployeeManagement.Dto.EmployeeDTO;
import com.terzo.EmployeeManagement.Repository.EmployeeRepository;
import com.terzo.EmployeeManagement.Service.EmployeeService;
import com.terzo.EmployeeManagement.models.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employeelist")
    public  String listEmployee(Model model){
        List<EmployeeDTO> emp = employeeService.findAllEmployee();
        model.addAttribute("employee", emp);
        return "employeelist";
    }

    @GetMapping("/employee/{employeeId}/details")
    public String viewEmployee(@PathVariable("employeeId") Long employeeId, Model model){
        EmployeeDTO employeeDTO = employeeService.findEmployeeById(employeeId);
        model.addAttribute("employee", employeeDTO);
        return "employee-details";
    }

    @GetMapping("/employee/{employeeId}/edit")
    public String editEmployeeForm(@PathVariable("employeeId") long employeeId, Model model) {
        EmployeeDTO employee = employeeService.findEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "employee-edit";
    }
    @PostMapping("/employee/{employeeId}/edit")
    public String updateDetails(@PathVariable("employeeId") Long employeeId, @Valid @ModelAttribute("employee")EmployeeDTO employeeDTO, BindingResult result){
        if(result.hasErrors()){
            return "employee-edit";
        }
        employeeDTO.setId(employeeId);
        employeeService.updateEmployee(employeeDTO);
        return "redirect:/employeelist";
    }

    @GetMapping("/employee/new")
    public String addEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employee-add";
    }

    @PostMapping("/employee/new")
    public String addEmployee(@Valid @ModelAttribute("employee") EmployeeDTO employeeDTO, Model model, BindingResult result){
//        if(result.hasErrors()){
//            model.addAttribute("employee", employeeDTO);
//            return "employee-add";
//        }
        System.out.println(result);
        employeeService.saveEmployee(employeeDTO);
        return "redirect:/employeelist";
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
    }
}
