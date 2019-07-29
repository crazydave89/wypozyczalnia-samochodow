package pl.wypozyczalnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wypozyczalnia.model.CarRental;
import pl.wypozyczalnia.service.CarRentalService;

@Controller
public class CarRentalController {

    private CarRentalService carRentalService;

    @Autowired
    public CarRentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @GetMapping("/carRental")
    public String showCarRentalForm(Model model){
        CarRental carRental = new CarRental();
        model.addAttribute("car_rental", carRental);
        return "car_rental_form";
    }

    @PostMapping("/carRental/save")
    public String createCarRental(@ModelAttribute("car_rental") CarRental car_rental){
        carRentalService.createCarRental(car_rental);
        return "redirect:/";
    }
}
