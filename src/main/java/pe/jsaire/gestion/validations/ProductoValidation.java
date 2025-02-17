package pe.jsaire.gestion.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pe.jsaire.gestion.dto.ProductoDTO;


@Component
public class ProductoValidation  implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return ProductoDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductoDTO producto = (ProductoDTO) target;
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","NotBlank.productoDTO.nombre","El nombre del producto no puede estar vacio");

        if(producto.getNombre() == null || producto.getNombre().isEmpty()) {
            errors.rejectValue("nombre",null,"Es requerido");
        }
    }
}
