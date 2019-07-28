package pl.wypozyczalnia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long car_rental_id;
    private final String company_name = "Car Rental";
    private final String domain = "http://localhost:8080";
    private final String contactAddress = "Bydgoszcz ul. Grunwaldzka 5";
    private final String owner = "Dawid Kamasz";
    // TODO logotyp

    @OneToMany(mappedBy = "car_rental")
    @JsonIgnore
    private List<Department> departmentList = new ArrayList<>();

}
