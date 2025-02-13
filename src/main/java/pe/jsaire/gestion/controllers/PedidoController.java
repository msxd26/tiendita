package pe.jsaire.gestion.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.jsaire.gestion.dto.PedidoDTO;
import pe.jsaire.gestion.entities.Pedido;
import pe.jsaire.gestion.services.PedidoService;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;


    @GetMapping("{id}")
    public ResponseEntity<?> readById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody PedidoDTO pedidoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedidoDTO));
    }

    @PatchMapping("{id}/addProducto/{idProducto}")
    public ResponseEntity<?> addProducto(@PathVariable Integer id,@PathVariable Integer idProducto ,@RequestParam Integer cantidad) {
        try {
            PedidoDTO updatedPedido = pedidoService.addPedido(id, idProducto, cantidad);

            return ResponseEntity.status(HttpStatus.OK).body(updatedPedido);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("{id}/removeProducto/{idProducto}")
    public ResponseEntity<?>removeProducto(@PathVariable Integer id,@PathVariable Integer idProducto) {

        PedidoDTO updatePedido= pedidoService.removePedidoDetalle(id,idProducto);
        return ResponseEntity.status(HttpStatus.OK).body(updatePedido);
    }



}
