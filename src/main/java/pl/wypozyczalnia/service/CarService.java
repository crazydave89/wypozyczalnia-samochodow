package pl.wypozyczalnia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wypozyczalnia.model.Car;
import pl.wypozyczalnia.model.Department;
import pl.wypozyczalnia.repository.CarRepository;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllByDepartment(Department department){
        return carRepository.findAllByDepartment(department);
    }

    public void saveCar(Car car){
        carRepository.save(car);
    }

    public Car findById(Long id){
       return carRepository.findById(id).get();
    }
}
