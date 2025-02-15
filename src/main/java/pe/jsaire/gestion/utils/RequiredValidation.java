package pe.jsaire.gestion.utils;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class RequiredValidation implements ConstraintValidator<isRequired,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        return StringUtils.hasText(value);
        // return value != null && !value.isBlank();
    }
}
