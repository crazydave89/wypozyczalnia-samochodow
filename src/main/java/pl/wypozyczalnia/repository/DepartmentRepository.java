package pl.wypozyczalnia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wypozyczalnia.model.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
