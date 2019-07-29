package pl.wypozyczalnia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wypozyczalnia.model.CarRental;
import pl.wypozyczalnia.repository.CarRentalRepository;

@Service
public class CarRentalService {

    private CarRentalRepository carRentalRepository;

    @Autowired
    public CarRentalService(CarRentalRepository carRentalRepository) {
        this.carRentalRepository = carRentalRepository;
    }

    public void createCarRental(CarRental carRental){
        carRentalRepository.save(carRental);
    }
}
