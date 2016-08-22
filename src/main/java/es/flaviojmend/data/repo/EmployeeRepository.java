package es.flaviojmend.data.repo;

import es.flaviojmend.data.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by flavio on 19/07/16.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {


    List<Employee> findByName(String name);

}

