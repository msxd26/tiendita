package pe.jsaire.gestion.repositories;

import org.springframework.data.repository.CrudRepository;
import pe.jsaire.gestion.entities.Pedido;

public interface PedidoRepository extends GenericRepository<Pedido, Integer> {
}
