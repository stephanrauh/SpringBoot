package de.beyondjava.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Data
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody EmployeeDto dto) {
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
        var maybeEmployeeDto = employeeService.findById(id);
        if (null != maybeEmployeeDto) {
            return maybeEmployeeDto;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
