package pe.jsaire.gestion.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.jsaire.gestion.entities.Producto;

public interface ProductoRepository extends GenericRepository<Producto, Integer> {

    Page<Producto> findAll(Pageable pageable);
}
