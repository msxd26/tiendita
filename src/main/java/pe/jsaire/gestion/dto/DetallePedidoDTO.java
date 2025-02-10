package pe.jsaire.gestion.dto;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.jsaire.gestion.entities.Pedido;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoDTO {

    private Integer idDetallePedido;
    @JsonBackReference
    private PedidoDTO pedido;
    private ProductoDTO producto;
    private Integer cantidad;
    private BigDecimal precio;
}
