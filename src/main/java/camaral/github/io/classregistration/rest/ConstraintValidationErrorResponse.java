package camaral.github.io.classregistration.rest;

import java.util.List;

public record ConstraintValidationErrorResponse(List<FieldConstraintValidationError> errors) {
}
