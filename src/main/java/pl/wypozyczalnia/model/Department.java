package pl.wypozyczalnia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;

    @ManyToOne
    @JoinColumn(name = "car_rental_id")
    @JsonIgnore
    private CarRental car_rental;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    List<Employee> employeeList = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Car> carList = new ArrayList<>();

}
