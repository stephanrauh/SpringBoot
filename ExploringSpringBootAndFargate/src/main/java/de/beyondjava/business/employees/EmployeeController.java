package de.beyondjava.business.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Data
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody EmployeeDto dto) {
        employeeService.save(dto);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto findOne(@PathVariable("id") int id) {
        return employeeService.findById(id);
    }
}
