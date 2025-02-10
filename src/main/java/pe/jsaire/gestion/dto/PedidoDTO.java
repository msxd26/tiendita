package pe.jsaire.gestion.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Integer idPedido;
    private Integer usuarioId;
    private LocalDate fechaPedido;
    private BigDecimal totalPedido;
    @JsonManagedReference
    private List<DetallePedidoDTO> detalles;
}
