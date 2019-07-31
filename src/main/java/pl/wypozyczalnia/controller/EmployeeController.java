package pl.wypozyczalnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wypozyczalnia.model.Department;
import pl.wypozyczalnia.model.Employee;
import pl.wypozyczalnia.service.DepartmentService;
import pl.wypozyczalnia.service.EmployeeService;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    private DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/addEmployeeForm")
    public String showAddEmployeeForm(@RequestParam Long departmentId, Model model){
        Department department = departmentService.findById(departmentId);
        Employee employee = new Employee();
        employee.setDepartment(department);
        model.addAttribute("employee", employee);
        return "addEmployeeForm";
    }

    @PostMapping("/addEmployeeForm/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        Long id = employee.getDepartment().getDepartment_id();
        return "redirect:/department?departmentId="+id;
    }

    @GetMapping("/addEmployeeForm/update")
    public String saveEmployee(@RequestParam Long employee_id, Model model){
        Employee employee = employeeService.findById(employee_id);
        model.addAttribute("employee",employee);
        return "addEmployeeForm";
    }

    @GetMapping("/department/deleteEmployee")
    public String deleteEmployee(@RequestParam Long employee_id){
        Employee employee = employeeService.findById(employee_id);
        Long id = employee.getDepartment().getDepartment_id();
        employeeService.deleteById(employee_id);
        return "redirect:/department?departmentId="+id;
    }

}
