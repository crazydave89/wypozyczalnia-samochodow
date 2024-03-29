package pl.wypozyczalnia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wypozyczalnia.model.Department;
import pl.wypozyczalnia.model.Reservation;
import pl.wypozyczalnia.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void saveReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }

    public List<Reservation> findAllByLoanDepartment (Long department){
        return reservationRepository.findAllByLoanDepartment(department);
    }
}
