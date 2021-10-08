package com.devnicholas.employeemanager.controllers;

import com.devnicholas.employeemanager.entity.Employees;
import com.devnicholas.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeesController {
    @Autowired
    private EmployeeRepository employeeRepo;

    @GetMapping({"/"})
        public String viewHomePage(){
            return "/getting_started";

        }
    @GetMapping("/start_Activities")
    public String startActivities(){
        return "/admin_dashboard";
    }


    @GetMapping({"/showEmployees","/list"})
    public ModelAndView getAllEmployees(){
        ModelAndView mov = new ModelAndView("list_employees");
        mov.addObject("employees", employeeRepo.findAll());
        return mov;
    }
    @GetMapping("/addEmployee")
    private ModelAndView addEmployees(){
        ModelAndView modelAndView = new ModelAndView("add_employees");
        Employees newEmployee = new Employees();
        modelAndView.addObject("employees",newEmployee);
        return modelAndView;
    }
    @PostMapping("/addEmployee")
    public String addEmployees(@ModelAttribute Employees employees){
        employeeRepo.save(employees);
        return "redirect:/list";
    }
    @GetMapping("/showUpdate")
    public ModelAndView showUpdate(@RequestParam Long employeeId){
        ModelAndView mov = new ModelAndView("add_employees");
        Employees employeesU = employeeRepo.findById(employeeId).get();
        mov.addObject("employees", employeesU);
        return mov;
    }
    @GetMapping("/showDeleteEmployee")
    public String showDeleteEmployee(@RequestParam Long employeeId){
    employeeRepo.deleteById(employeeId);
    return "redirect:/list";
    }
}
