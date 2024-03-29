package pl.wypozyczalnia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wypozyczalnia.model.Car;
import pl.wypozyczalnia.model.CarRental;
import pl.wypozyczalnia.model.Department;
import pl.wypozyczalnia.model.Reservation;
import pl.wypozyczalnia.service.CarRentalService;
import pl.wypozyczalnia.service.CarService;
import pl.wypozyczalnia.service.DepartmentService;
import pl.wypozyczalnia.service.ReservationService;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
public class ReservationController {

    private ReservationService reservationService;
    private CarService carService;
    private DepartmentService departmentService;
    private CarRentalService carRentalService;

    @Autowired
    public ReservationController(ReservationService reservationService, CarService carService, DepartmentService departmentService, CarRentalService carRentalService) {
        this.reservationService = reservationService;
        this.carService = carService;
        this.departmentService = departmentService;
        this.carRentalService = carRentalService;
    }

    @GetMapping("/reservation")
    public String createReservation(Model model){
        Reservation reservation = new Reservation();
        CarRental carRental = carRentalService.findById(1L);
        List<Department> departmentList = carRental.getDepartmentList();
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("reservation", reservation);
        return "reservationForm";
    }

    @GetMapping("/reservation/getCars")
    public String createReservationGetCars(@ModelAttribute Reservation reservation, Model model){
        Long loanDepartmentId = reservation.getLoanDepartment();
        Department loanDepartment = departmentService.findById(loanDepartmentId);
        List<Car> carList = carService.getAllByDepartment(loanDepartment);

        LocalDate startDate = reservation.getStartDate();
        LocalDate stopDate = reservation.getStopDate();
        List<Reservation> reservationList = reservationService.findAllByLoanDepartment(loanDepartmentId);
        for (Reservation res1 : reservationList) {
            if ((res1.getStartDate().isBefore(startDate)&&res1.getStopDate().isAfter(startDate))||(res1.getStartDate().equals(startDate))||startDate.equals(stopDate)){
                Car car = carService.findById(res1.getCar_id());
                carList.remove(car);
            }
            else if ((res1.getStartDate().isBefore(stopDate)&&res1.getStopDate().isAfter(stopDate))&&res1.getStartDate().isAfter(startDate)){
                Car car = carService.findById(res1.getCar_id());
                carList.remove(car);
            }
        }


        model.addAttribute("reservation", reservation);
        model.addAttribute("carList",carList);
        return "reservationForm";
    }

    @GetMapping("/reservation/calculate")
    public String createReservationCalculate(@ModelAttribute Reservation reservation, Model model){
        Period until = reservation.getStartDate().until(reservation.getStopDate());
        Long daysAmount = Long.valueOf(until.getDays());
        Car car = carService.findById((reservation.getCar_id()));
        Double finalPrice = car.getPricePerDay()*(daysAmount);
        reservation.setPrice(finalPrice);
        model.addAttribute("reservation", reservation);
        model.addAttribute("finalPrice", finalPrice);
        return "reservationForm";
    }

    @PostMapping("/reservation/create")
    public String createReservation(@ModelAttribute Reservation reservation){
        reservationService.saveReservation(reservation);
        return "done";
    }
}
