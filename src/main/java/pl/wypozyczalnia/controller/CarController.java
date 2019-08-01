package pl.wypozyczalnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wypozyczalnia.model.*;
import pl.wypozyczalnia.service.CarService;
import pl.wypozyczalnia.service.DepartmentService;

@Controller
public class CarController {

    private CarService carService;
    private DepartmentService departmentService;

    @Autowired
    public CarController(CarService carService, DepartmentService departmentService) {
        this.carService = carService;
        this.departmentService = departmentService;
    }

    @GetMapping("/addCarForm")
    public String showAddEmployeeForm(@RequestParam Long departmentId, Model model){
        Department department = departmentService.findById(departmentId);
        Car car = new Car();
        car.setDepartment(department);
        model.addAttribute("car", car);
        model.addAttribute("carBodyType", CarBodyType.values());
        model.addAttribute("rentStatus", RentStatus.values());
        return "addCarForm";
    }

    @PostMapping("/addCarForm/save")
    public String addDepartment(@ModelAttribute("car") Car car){
        carService.saveCar(car);
        return "redirect:/";
    }

    @GetMapping("/addCarForm/update")
    public String saveEmployee(@RequestParam Long car_id, Model model){
        Car car = carService.findById(car_id);
        model.addAttribute("car",car);
        model.addAttribute("carBodyType",CarBodyType.values());
        model.addAttribute("rentStatus",RentStatus.values());
        return "addCarForm";
    }

}
