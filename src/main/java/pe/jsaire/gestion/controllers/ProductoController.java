package pe.jsaire.gestion.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.jsaire.gestion.dto.ProductoDTO;
import pe.jsaire.gestion.entities.Producto;
import pe.jsaire.gestion.services.ProductoService;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;


    @GetMapping("{id}")
    public ResponseEntity<?> readById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductoDTO producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        productoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
