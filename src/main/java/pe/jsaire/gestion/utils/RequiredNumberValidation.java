package pe.jsaire.gestion.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class RequiredNumberValidation implements ConstraintValidator<isRequiredNumber,Number> {
    @Override
    public boolean isValid(Number number, ConstraintValidatorContext constraintValidatorContext) {

        if (number instanceof BigDecimal bd) {
            return bd.compareTo(BigDecimal.ZERO) > 0;
        }
        return true;
    }
}
