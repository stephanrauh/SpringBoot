package de.beyondjava.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        var maybeEmployeeDto = employeeService.findById(id);
        if (null != maybeEmployeeDto) {
            return maybeEmployeeDto;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    //    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
