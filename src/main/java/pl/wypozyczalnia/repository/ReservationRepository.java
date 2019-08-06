package pl.wypozyczalnia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wypozyczalnia.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
