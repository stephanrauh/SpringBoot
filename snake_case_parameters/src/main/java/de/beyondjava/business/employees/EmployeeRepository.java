package de.beyondjava.business.employees;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findEmployeeByFirstNameContaining(String start);

    Optional<Employee> findEmployeeByFirstName(String firstName);
}
