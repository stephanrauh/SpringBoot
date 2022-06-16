package de.beyondjava.tech.startup;

import de.beyondjava.business.employees.Employee;
import de.beyondjava.business.employees.EmployeeMapper;
import de.beyondjava.business.employees.EmployeeRepository;
import de.beyondjava.business.projects.Project;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

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
        val cafelito = new Project("Cafelito", """
                Demo project used at conferences, 
                see http://trishagee.github.io/presentation/angularjs_html5_groovy_java_mongodb_wcpgw/
                """);
        repository.save(new Employee("Dalia", "Abo Sheasha", Collections.emptyList()));
        repository.save(new Employee("Trisha", "Gee", List.of(cafelito)));
        repository.save(new Employee("Helen", "Scott", Collections.emptyList()));
        repository.save(new Employee("Mala", "Gupta", Collections.emptyList()));
    }
}
