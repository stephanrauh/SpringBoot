package de.beyondjava.business.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class EmployeeService {
    private EmployeeMapper employeeMapper;

    private EmployeeRepository employeeRepository;

    public void save(EmployeeDto employeeDto) {
        val employee = employeeMapper.dtoToEntity(employeeDto);
        employeeRepository.save(employee);
    }

    public List<EmployeeDto> findAll() {
        val employees = employeeRepository.findAll();
        return employeeMapper.entityToDTO(employees);
    }

    public EmployeeDto findById(long id) {
        val employee = employeeRepository.findById(id).orElseThrow();
        return employeeMapper.entityToDTO(employee);
    }
}
