package com.anish.crud.controllers;

import javax.validation.Valid;

import com.anish.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.anish.crud.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Employee employee) {
        return "add-employee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.print("has error-----" + employee.getFirstName());
            return "add-employee";
        }
        employeeRepository.save(employee);
        List<Employee> employees = employeeRepository.findAll(new Sort(Sort.Direction.ASC, "firstName"));
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") long id, @Valid Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            employee.setId(id);
            return "update-employee";
        }

        employeeRepository.save(employee);
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        employeeRepository.delete(employee);
        List<Employee> employees = employeeRepository.findAll(new Sort(Sort.Direction.ASC, "firstName"));
        model.addAttribute("employees", employees);
        return "index";
    }
}
