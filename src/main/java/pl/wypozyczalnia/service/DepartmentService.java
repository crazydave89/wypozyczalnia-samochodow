package pl.wypozyczalnia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wypozyczalnia.model.Department;
import pl.wypozyczalnia.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }
    public void  deleteDepartmentById(Long id){
        departmentRepository.deleteById(id);
    }

    public Department findById(Long id){
        return departmentRepository.findById(id).get();
    }
}
