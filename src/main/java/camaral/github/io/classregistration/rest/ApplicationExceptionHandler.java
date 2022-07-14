package camaral.github.io.classregistration.rest;

import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleValidationExceptions(
            ConstraintViolationException ex,
            WebRequest request) {

        List<FieldConstraintValidationError> errors = ex.getConstraintViolations()
                .stream()
                .map(validation -> new FieldConstraintValidationError(
                        validation.getPropertyPath().toString(),
                        validation.getMessage()))
                .toList();

        return this.handleExceptionInternal(ex, new ConstraintValidationErrorResponse(errors),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(RepositoryConstraintViolationException.class)
    public ResponseEntity<Object> handleRepositoryConstraintViolationException(
            RepositoryConstraintViolationException ex,
            WebRequest request
    ) {
        List<FieldConstraintValidationError> errors = ex.getErrors().getAllErrors()
                .stream()
                .map(objectError -> new FieldConstraintValidationError(
                        objectError.getObjectName(),
                        objectError.getDefaultMessage()))
                .toList();

        return this.handleExceptionInternal(ex, new ConstraintValidationErrorResponse(errors),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
