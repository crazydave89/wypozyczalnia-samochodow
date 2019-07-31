package pl.wypozyczalnia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wypozyczalnia.model.Car;
import pl.wypozyczalnia.model.Department;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findAllByDepartment(Department department);
}
