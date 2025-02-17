package pe.jsaire.gestion.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.jsaire.gestion.validations.isRequiredNumber;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Integer idPedido;

    @NotNull
    private Integer usuarioId;

    @NotNull
    private LocalDate fechaPedido;

    @isRequiredNumber
    private BigDecimal totalPedido;
    @JsonManagedReference
    private List<DetallePedidoDTO> detalles;
}
