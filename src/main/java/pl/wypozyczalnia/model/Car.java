package pl.wypozyczalnia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @Enumerated(value = EnumType.STRING)
    private CarBodyType carBodyType;
    @NotNull
    private Integer productionYear;
    @NotBlank
    private String color;
    @NotNull
    private Double mileage; // przebieg
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private RentStatus rentStatus;
    @NotNull
    private Double pricePerDay;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", carBodyType=" + carBodyType +
                ", productionYear=" + productionYear +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", rentStatus=" + rentStatus +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
