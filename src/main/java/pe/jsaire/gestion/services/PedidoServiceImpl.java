package pe.jsaire.gestion.services;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.jsaire.gestion.dto.DetallePedidoDTO;
import pe.jsaire.gestion.dto.PedidoDTO;
import pe.jsaire.gestion.entities.DetallePedido;
import pe.jsaire.gestion.entities.Pedido;
import pe.jsaire.gestion.entities.Producto;
import pe.jsaire.gestion.entities.Usuario;
import pe.jsaire.gestion.repositories.PedidoRepository;
import pe.jsaire.gestion.repositories.ProductoRepository;
import pe.jsaire.gestion.repositories.UsuarioRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public PedidoDTO findById(Integer id) {
        return convertToDto(repository.findById(id).orElseThrow());
    }

    @Override
    public PedidoDTO save(PedidoDTO entity) {

        Usuario usuario = usuarioRepository.findById(convertToEntity(entity).getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);

        BigDecimal totalAmount = BigDecimal.ZERO;
        List<DetallePedido> detalles = new ArrayList<>();

        for (DetallePedidoDTO detalleDto : entity.getDetalles()) {
            Producto producto = productoRepository.findById(detalleDto.getProducto().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            DetallePedido detalle = new DetallePedido();
            detalle.setProducto(producto);
            detalle.setCantidad(detalleDto.getCantidad());
            detalle.setPrecio(producto.getPrecio());
            detalle.setPedido(pedido);

            BigDecimal subtotal = detalle.getPrecio().multiply(BigDecimal.valueOf(detalle.getCantidad()));
            totalAmount = totalAmount.add(subtotal);

            detalles.add(detalle);
        }

        pedido.setTotal(totalAmount);
        pedido.setDetalles(detalles);
        pedido.setFecha(LocalDate.now());

        pedido = repository.save(pedido);

        return convertToDto(pedido);
    }

    @Override
    public PedidoDTO addPedido(Integer idPedido, Integer idProducto, Integer cantidad) {

        var pedido = repository.findById(idPedido).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        var producto = productoRepository.findById(idProducto).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        DetallePedido detalle = new DetallePedido();
        detalle.setProducto(producto);
        detalle.setCantidad(cantidad);
        detalle.setPrecio(producto.getPrecio());

        detalle.setPedido(pedido);

        pedido.addPedidoDetalle(detalle);

        repository.save(pedido);

        return convertToDto(pedido);
    }

    @Override
    public PedidoDTO removePedidoDetalle(Integer idPedido, Integer idProducto) {


        var pedido = repository.findById(idPedido).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));


        DetallePedido detalleEliminar = null;


        for (DetallePedido detalle : pedido.getDetalles()) {
            if (detalle.getProducto().getId().equals(idProducto)) {
                detalleEliminar = detalle;
                break;
            }
        }

        pedido.removePedidoDetalle(detalleEliminar);

        repository.save(pedido);

        /*
        DetallePedido detalleAEliminar = pedido.getDetalles().stream()
                .filter(detalle -> detalle.getProducto().getId().equals(idProducto))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));

        pedido.removePedidoDetalle(detalleAEliminar);

        */

        return convertToDto(pedido);
    }


    @Override
    public void delete(Integer id) {
        Pedido entity = repository.findById(id).orElseThrow();
        repository.delete(entity);
    }


    private Pedido convertToEntity(PedidoDTO dto) {
        return modelMapper.map(dto, Pedido.class);
    }
    private PedidoDTO convertToDto(Pedido entity) {
        return modelMapper.map(entity, PedidoDTO.class);
    }
}
