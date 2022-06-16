package de.beyondjava.tech.errorHandlers;

import lombok.val;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * Kudos https://stackoverflow.com/questions/33663801/how-do-i-customize-default-error-message-from-spring-valid-validation
 * Kudos http://www.petrikainulainen.net/programming/spring-framework/spring-from-the-trenches-adding-validation-to-a-rest-api/
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalMethodArgumentNotValidExceptionHandler {

    // @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorList methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var result = ex.getBindingResult();
        var fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private ValidationErrorList processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
        val error = new ValidationErrorList(BAD_REQUEST.value(), fieldErrors.size() + " validation error(s) found.");
        for (var fieldError : fieldErrors) {
            error.getFieldErrors().add(new ValidationError(fieldError.getObjectName(), fieldError.getField(),
                    fieldError.getDefaultMessage()));
        }
        return error;
    }
}