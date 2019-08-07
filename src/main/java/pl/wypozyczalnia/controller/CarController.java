package pl.wypozyczalnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.wypozyczalnia.model.*;
import pl.wypozyczalnia.service.CarService;
import pl.wypozyczalnia.service.DepartmentService;

import javax.validation.Valid;

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
    public String showAddCarForm(@RequestParam Long departmentId, Model model){
        Department department = departmentService.findById(departmentId);
        Car car = new Car();
        car.setDepartment(department);
        model.addAttribute("car", car);
        model.addAttribute("carBodyType", CarBodyType.values());
        model.addAttribute("rentStatus", RentStatus.values());
        return "addCarForm";
    }

    @PostMapping("/addCarForm/save")
    public String addCar(@ModelAttribute("car") @Valid Car car, RedirectAttributes redirectAttributes, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("car", car);
            model.addAttribute("carBodyType", CarBodyType.values());
            model.addAttribute("rentStatus", RentStatus.values());
            return "addCarForm";
        }
        redirectAttributes.addAttribute("departmentId",car.getDepartment().getDepartment_id());
        carService.saveCar(car);
        return "redirect:/department";
    }

    @GetMapping("/addCarForm/update")
    public String updateCarForm(@RequestParam Long car_id, Model model){
        Car car = carService.findById(car_id);
        model.addAttribute("car",car);
        model.addAttribute("carBodyType",CarBodyType.values());
        model.addAttribute("rentStatus",RentStatus.values());
        return "addCarForm";
    }

}
