package pl.wypozyczalnia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservation_id;

    @NotNull
    private LocalDate reservationDate;
    @NotNull
    private Integer client_id;
    @NotNull
    private Integer car_id;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate stopDate;
    @NotNull
    private Integer loanDepartment; // department_id
    @NotNull
    private Integer returnDepartment; // department_id
    @NotNull
    private Double price;

}
