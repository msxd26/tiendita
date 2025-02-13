package pe.jsaire.gestion.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.jsaire.gestion.dto.ProductoDTO;
import pe.jsaire.gestion.entities.Producto;


public interface ProductoService extends CrudService<ProductoDTO, Integer> {
    Page<ProductoDTO> findAll(String field, Integer page);
}
