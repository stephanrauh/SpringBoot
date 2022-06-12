package de.beyondjava.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class EmployeeService {
    private EmployeeMapper employeeMapper;

    private EmployeeRepository employeeRepository;

    public void save(EmployeeDto employeeDto) {
        var employee = employeeMapper.dtoToEntity(employeeDto);
        employeeRepository.save(employee);
    }

    public List<EmployeeDto> findAll() {
        var employees = employeeRepository.findAll();
        return employeeMapper.entityToDTO(employees);
    }

    public EmployeeDto findById(long id) {
        var employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employeeMapper.entityToDTO(employee.get());
        }
        return null;
    }
}
