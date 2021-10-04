package com.devnicholas.employeemanager.controllers;

import com.devnicholas.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeesController {
    @Autowired
    private EmployeeRepository employeeRepo;
    @GetMapping({"/","/showEmployees","/list"})
    public ModelAndView getAllEmployees(){
        ModelAndView mov = new ModelAndView("list_employees");
        mov.addObject("employees", employeeRepo.findAll());
        return mov;
    }
}
