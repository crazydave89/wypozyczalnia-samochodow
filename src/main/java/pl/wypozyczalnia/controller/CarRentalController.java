package pl.wypozyczalnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wypozyczalnia.model.CarRental;
import pl.wypozyczalnia.model.Department;
import pl.wypozyczalnia.service.CarRentalService;
import pl.wypozyczalnia.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarRentalController {

    private CarRentalService carRentalService;
    private DepartmentService departmentService;

    @Autowired
    public CarRentalController(CarRentalService carRentalService, DepartmentService departmentService) {
        this.carRentalService = carRentalService;
        this.departmentService = departmentService;
    }

    @GetMapping("/carRentalForm")
    public String showCarRentalForm(Model model){
        CarRental carRental = new CarRental();
        model.addAttribute("car_rental", carRental);
        return "car_rental_form";
    }

    @PostMapping("/carRentalForm/save")
    public String createCarRental(@ModelAttribute("car_rental") CarRental car_rental){
        carRentalService.createCarRental(car_rental);
        return "redirect:/";
    }

    @GetMapping("/carRental")
    public String showCarRentalControlPanel(Model model){
        List<Department> departments = departmentService.getAllDepartment();
        model.addAttribute("departments",departments);
        return "car_rental_control_panel";
    }
}
