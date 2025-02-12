package pe.jsaire.gestion.services;

import pe.jsaire.gestion.dto.PedidoDTO;

public interface PedidoService extends CrudService<PedidoDTO, Integer>{

    PedidoDTO addPedido(Integer idPedido, Integer idProducto, Integer cantidad);

    PedidoDTO removePedidoDetalle(Integer idPedido, Integer idProducto);
}
