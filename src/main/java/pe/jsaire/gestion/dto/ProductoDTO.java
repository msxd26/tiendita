package pe.jsaire.gestion.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.jsaire.gestion.utils.isRequired;
import pe.jsaire.gestion.utils.isRequiredNumber;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Integer id;

    @NotBlank(message = "{NotBlank.productoDTO.nombre}")
    private String nombre;

    @isRequired
    private String descripcion;

    @DecimalMin(value = "0.1", message = "El valor tiene que ser mayor a cero")
    @Positive
    //@isRequiredNumber
    private BigDecimal precio;

    @Min(value = 0,message = "El valor no tiene que ser negativo")
    @NotNull
    private Integer stock;
}
