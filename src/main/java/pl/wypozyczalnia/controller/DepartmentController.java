package pl.wypozyczalnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wypozyczalnia.model.CarRental;
import pl.wypozyczalnia.model.Department;
import pl.wypozyczalnia.model.Employee;
import pl.wypozyczalnia.service.DepartmentService;

import java.util.List;

@Controller
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping("/addDepartment/save")
    public String addDepartment(@ModelAttribute("department") Department department){
        departmentService.saveDepartment(department);
        return "redirect:/";
    }

    @GetMapping("/deleteDepartment")
    public String deleteDepartment(@RequestParam ("departmentId") Long id){
        departmentService.deleteDepartmentById(id);
        return "redirect:/";
    }
    @GetMapping("/department")
    public String showCarRentalControlPanel(@RequestParam Long departmentId, Model model){
        Department department = departmentService.findById(departmentId);
        List<Employee> employeeList = department.getEmployeeList();
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("departmentId", departmentId);
        return "department_control_panel";
    }

}
