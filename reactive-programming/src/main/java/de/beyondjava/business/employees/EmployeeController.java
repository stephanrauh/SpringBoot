package de.beyondjava.business.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @PostMapping
    public Mono<Employee> createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping
    public Mono<Employee> updateEmployee(@RequestBody Employee employee) {
        return employeeRepository
                .findByFirstName(employee.getFirstName())
                .flatMap(employeeResult -> employeeRepository.save(employee));
    }

    @DeleteMapping
    public Mono<Void> deleteEmployee(@RequestBody Employee employee) {
        return employeeRepository.deleteById(employee.getId());
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Employee> findOne(@PathVariable("id") long id) {
        return employeeRepository.findById(id);
    }
}
