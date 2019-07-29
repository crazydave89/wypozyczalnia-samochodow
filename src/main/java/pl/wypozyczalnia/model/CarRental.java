package pl.wypozyczalnia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private String company_name ;
    @NotBlank
    private String domain ;
    @NotBlank
    private String contactAddress ;
    @NotBlank
    private String owner ;
    // TODO logotyp

    @OneToMany(mappedBy = "car_rental")
    @JsonIgnore
    private List<Department> departmentList = new ArrayList<>();

}
