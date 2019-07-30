package pl.wypozyczalnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wypozyczalnia.model.CarRental;
import pl.wypozyczalnia.model.Department;
import pl.wypozyczalnia.service.DepartmentService;

@Controller
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/addDepartment")
    public String showAddDepartmentForm(Model model){
        Department department = new Department();
        model.addAttribute("department",department);
        return "create_department_form";
    }

    @PostMapping("/addDepartment/save")
    public String addDepartment(@ModelAttribute("department") Department department){
        departmentService.saveDepartment(department);
        return "redirect:/";
    }
}
