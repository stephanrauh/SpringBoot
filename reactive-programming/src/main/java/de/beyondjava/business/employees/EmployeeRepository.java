package de.beyondjava.business.employees;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends R2dbcRepository<Employee, Long> {
    Mono<Employee> findByFirstName(String name);
}
