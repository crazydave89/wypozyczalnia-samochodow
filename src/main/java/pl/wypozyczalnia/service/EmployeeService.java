package pl.wypozyczalnia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wypozyczalnia.model.Employee;
import pl.wypozyczalnia.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id).get();
    }

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }
}
