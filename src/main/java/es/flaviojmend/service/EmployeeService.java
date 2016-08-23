package es.flaviojmend.service;

import es.flaviojmend.persistence.entity.Employee;
import es.flaviojmend.persistence.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {

//        if(employee.getName() == null) {
//            throw new Exception("Não pode ter nome nulo");
//        }
//        employee.setRegistrationNumber(geraMatricula());
        employeeRepository.save(employee);
    }


    public Iterable<Employee> listEmployees(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

}
