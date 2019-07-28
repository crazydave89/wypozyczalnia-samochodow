package pl.wypozyczalnia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Returned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long return_id;
    @NotNull
    private Integer employee_id;
    @NotNull
    private LocalDate returnDate;
    @NotNull
    private Integer reservation_id;
    @NotNull
    private Double supplement; // dopłata
    @NotBlank
    private String returnComments;

}
