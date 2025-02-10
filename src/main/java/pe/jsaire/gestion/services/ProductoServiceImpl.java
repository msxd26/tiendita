package pe.jsaire.gestion.services;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.jsaire.gestion.dto.ProductoDTO;
import pe.jsaire.gestion.entities.Producto;
import pe.jsaire.gestion.repositories.ProductoRepository;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService{

    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;



    @Override
    public ProductoDTO findById(Integer id) {
        Producto producto = productoRepository.findById(id).orElseThrow();
        return convertToDto(producto);
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = productoRepository.save(convertToEntity(productoDTO));
        return convertToDto(producto);
    }

    @Override
    public void delete(Integer id) {
        var producto = findById(id);
        productoRepository.deleteById(id);

    }

    private ProductoDTO convertToDto(Producto entity) {
        return modelMapper.map(entity, ProductoDTO.class);
    }

    private Producto convertToEntity(ProductoDTO dto) {
        return modelMapper.map(dto, Producto.class);
    }
}
