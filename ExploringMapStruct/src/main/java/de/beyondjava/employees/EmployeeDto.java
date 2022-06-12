package de.beyondjava.employees;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class EmployeeDto {
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;
}
