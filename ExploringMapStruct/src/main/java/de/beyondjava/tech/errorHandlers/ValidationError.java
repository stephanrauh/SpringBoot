package de.beyondjava.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ValidationError {
    private String object;
    private String field;
    private String message;
}
