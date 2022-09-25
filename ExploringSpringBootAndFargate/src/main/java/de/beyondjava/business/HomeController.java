package de.beyondjava.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@Data
@AllArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request
    ) {
        var root = request.getRequestURI();
        var response = """
<h1>Greetings!</h1>
<p>This is Spring Boot running on AWS Fargate, deployed by an AWS CDK script.</p>
<p>Check out these URLs:</p>
<ul>
<li>
<a href="/employees/">List of employees</a>
</li>
<li>
<a href="/projects/">List of projects</a>
</li>
</ul>
""";
        return response;
    }
}