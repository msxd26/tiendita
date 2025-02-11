package pe.jsaire.gestion.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private LocalDate fecha;

    private BigDecimal total;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles;


    @PrePersist
    public void prePersist() {

        this.fecha = LocalDate.now();
    }

    public BigDecimal calcularTotal() {
        return detalles.stream().map(DetallePedido::getPrecio).
                reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addPedidoDetalle(DetallePedido detalle) {
        this.detalles.add(detalle);
        detalle.setPedido(this);
        this.total = calcularTotal();
    }

    public void removePedidoDetalle(DetallePedido detalle) {
        detalles.remove(detalle);
        detalle.setPedido(null);
        this.total = calcularTotal();
    }
}
