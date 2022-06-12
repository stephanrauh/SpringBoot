package de.beyondjava.employees;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto entityToDTO(Employee employee);

    List<EmployeeDto> entityToDTO(Iterable<Employee> employee);

    Employee dtoToEntity(EmployeeDto employee);

    List<Employee> dtoToEntity(Iterable<EmployeeDto> employees);

}