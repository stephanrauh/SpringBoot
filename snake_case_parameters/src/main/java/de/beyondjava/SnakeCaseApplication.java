package de.beyondjava;

import de.beyondjava.tech.startup.Startup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnakeCaseApplication {

    @Autowired
    private Startup startup;

    public static void main(String[] args) {
        SpringApplication.run(SnakeCaseApplication.class, args);
    }


}
