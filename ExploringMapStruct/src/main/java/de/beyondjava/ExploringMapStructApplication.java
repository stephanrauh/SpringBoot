package de.beyondjava;

import de.beyondjava.configuration.Startup;
import de.beyondjava.employees.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "de")
public class ExploringMapStructApplication {

    @Autowired
    private Startup startup;

    public static void main(String[] args) {
        SpringApplication.run(ExploringMapStructApplication.class, args);
    }


}
