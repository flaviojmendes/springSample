package es.flaviojmend.controller;

import es.flaviojmend.data.entity.Employee;
import es.flaviojmend.data.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by flavio.mendes on 22/08/2016.
 */

@RestController
public class EmployeeController {


    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/employee")
    public Iterable<Employee> getEmployee() {
        return employeeRepository.findAll();
    }


}
