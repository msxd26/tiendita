package pe.jsaire.gestion.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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


    @GetMapping("/all")
    public ResponseEntity<Page<?>> findAll(@RequestParam(required = false) String field,
                                        @RequestParam(required = false) Boolean desc,
                                        @RequestParam Integer page){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.findAll(field, page, desc));
    }

    @GetMapping("/search")
    public ResponseEntity<?> findName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.findByName(name));
    }

}
