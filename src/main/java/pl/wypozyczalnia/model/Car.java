package pl.wypozyczalnia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long car_id;

    @NotBlank
    private String brand; //marka
    @NotBlank
    private String model;
    @NotNull
    private CarBodyType carBodyType;
    @NotNull
    private Integer productionYear;
    @NotBlank
    private String color;
    @NotNull
    private Double mileage; // przebieg
    @NotNull
    private RentStatus rentStatus;
    @NotNull
    private Double pricePerDay;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;
}
