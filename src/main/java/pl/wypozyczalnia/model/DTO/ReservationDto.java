package pl.wypozyczalnia.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.wypozyczalnia.model.Car;
import pl.wypozyczalnia.model.Department;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    @NotNull
    private LocalDate reservationDate = LocalDate.now();
    @NotNull
    private Integer client_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate stopDate;
    @NotNull
    private Department loanDepartment; // department_id
    @NotNull
    private Department returnDepartment; // department_id
    @NotNull
    private Double price;
    @NotNull
    private Car car;


}
