package pl.wypozyczalnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wypozyczalnia.model.CarRental;
import pl.wypozyczalnia.model.Department;
import pl.wypozyczalnia.service.CarRentalService;
import pl.wypozyczalnia.service.DepartmentService;
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
    public String showCarRentalControlPanel(@RequestParam Long carRentalId, Model model){
        CarRental carRental = carRentalService.findById(carRentalId);
        List<Department> departments = carRental.getDepartmentList();
        model.addAttribute("departments",departments);
        model.addAttribute("carRental",carRental);
        return "car_rental_control_panel";
    }


    @GetMapping("/carRentalList")
    public String showCarRentalList(Model model){
        List<CarRental> carRentalList = carRentalService.getCarRentalList();
        model.addAttribute("carRentalList",carRentalList);
        return "car_rental_list";
    }
}
