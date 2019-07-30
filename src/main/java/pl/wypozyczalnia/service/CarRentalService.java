package pl.wypozyczalnia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wypozyczalnia.model.CarRental;
import pl.wypozyczalnia.repository.CarRentalRepository;

import java.util.List;

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

    public List<CarRental> getCarRentalList(){
        return carRentalRepository.findAll();
    }

    public CarRental findById(Long id){
        return carRentalRepository.findById(id).get();
    }
}
