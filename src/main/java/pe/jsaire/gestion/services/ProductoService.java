package pe.jsaire.gestion.services;

import org.springframework.data.domain.Page;

import pe.jsaire.gestion.dto.ProductoDTO;



public interface ProductoService extends CrudService<ProductoDTO, Integer> {
    Page<ProductoDTO> findAll(String field, Integer page);
}
