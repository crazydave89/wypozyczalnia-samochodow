package pl.wypozyczalnia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wypozyczalnia.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
