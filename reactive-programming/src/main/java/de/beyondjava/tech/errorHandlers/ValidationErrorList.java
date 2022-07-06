package de.beyondjava.tech.errorHandlers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class ValidationErrorList {
    private final int status;
    private final String message;
    private final List<ValidationError> fieldErrors = new ArrayList<>();
}