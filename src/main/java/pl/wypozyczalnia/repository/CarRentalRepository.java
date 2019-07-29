package pl.wypozyczalnia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wypozyczalnia.model.CarRental;

@Repository
public interface CarRentalRepository extends JpaRepository<CarRental,Long> {
}
