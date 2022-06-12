package de.beyondjava.employees;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    public List<Employee> findEmployeeByFirstNameContaining(String start);
}
