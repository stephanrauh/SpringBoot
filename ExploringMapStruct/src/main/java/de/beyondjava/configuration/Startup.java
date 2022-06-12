package de.beyondjava.configuration;

import de.beyondjava.employees.Employee;
import de.beyondjava.employees.EmployeeMapper;
import de.beyondjava.employees.EmployeeMapperImpl;
import de.beyondjava.employees.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class Startup {
    private EmployeeRepository employeeRepository;

    private EmployeeMapper employeeMapper;

    @Bean
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args) -> {
            this.insertFourEmployees(repository);
            var employees = repository.findAll();
            var employeeDTOs = employeeMapper.entityToDTO(employees);
            System.out.println(employeeDTOs);
        };
    }

    public void insertFourEmployees(EmployeeRepository repository) {
        repository.save(new Employee("Dalia", "Abo Sheasha"));
        repository.save(new Employee("Trisha", "Gee"));
        repository.save(new Employee("Helen", "Scott"));
        repository.save(new Employee("Mala", "Gupta"));
    }
}
