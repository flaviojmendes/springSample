package es.flaviojmend.controller;

import es.flaviojmend.data.entity.Employee;
import es.flaviojmend.data.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Created by flavio.mendes on 22/08/2016.
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Employee> get() {
        return employeeRepository.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Employee employee) {
        employeeRepository.save(employee);

        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if(employee.getIdEmployee() == null) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }

        employeeRepository.save(employee);


        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?>  delete(@RequestBody Employee employee) {
        employeeRepository.delete(employee);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }

}