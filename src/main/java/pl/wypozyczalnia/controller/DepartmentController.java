package pl.wypozyczalnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wypozyczalnia.model.Car;
import pl.wypozyczalnia.model.Department;
import pl.wypozyczalnia.model.Employee;
import pl.wypozyczalnia.service.CarService;
import pl.wypozyczalnia.service.DepartmentService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DepartmentController {

    private DepartmentService departmentService;
    private CarService carService;

    @Autowired
    public DepartmentController(DepartmentService departmentService, CarService carService) {
        this.departmentService = departmentService;
        this.carService = carService;
    }



    @PostMapping("/addDepartment/save")
    public String addDepartment(@ModelAttribute("department") @Valid Department department, RedirectAttributes redirectAttributes, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "create_department_form";
        }
        departmentService.saveDepartment(department);
        redirectAttributes.addAttribute("carRentalId",department.getCar_rental().getCar_rental_id());
        return "redirect:/carRental";
    }

    @GetMapping("/deleteDepartment")
    public String deleteDepartment(@RequestParam ("departmentId") Long id, RedirectAttributes redirectAttributes){
        Department department = departmentService.findById(id);
        departmentService.deleteDepartmentById(id);
        redirectAttributes.addAttribute("carRentalId",department.getCar_rental().getCar_rental_id());
        return "redirect:/carRental";
    }
    @GetMapping("/department")
    public String showDepartmentControlPanel(@RequestParam Long departmentId, Model model){
        Department department = departmentService.findById(departmentId);
        List<Employee> employeeList = department.getEmployeeList();
        List<Car> carList = carService.getAllByDepartment(department);
        model.addAttribute("carList",carList);
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("departmentId", departmentId);
        return "department_control_panel";
    }

}
