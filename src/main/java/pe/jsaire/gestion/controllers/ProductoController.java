package pe.jsaire.gestion.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.jsaire.gestion.dto.ProductoDTO;
import pe.jsaire.gestion.entities.Producto;
import pe.jsaire.gestion.services.ProductoService;
import pe.jsaire.gestion.utils.ProductoValidation;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    //private final ProductoValidation validation;

    @GetMapping("{id}")
    public ResponseEntity<?> readById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductoDTO producto , BindingResult result){
      //  validation.validate(producto, result);
        if(result.hasFieldErrors()){
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }



    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        productoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/all")
    public ResponseEntity<?> findAll(@RequestParam(required = false) String field,
                                        @RequestParam(required = false) Boolean desc,
                                        @RequestParam Integer page){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.findAll(field, page, desc));
    }

    @GetMapping("/search")
    public ResponseEntity<?> findName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.findByName(name));
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(),"El campo " + error.getField() + " " + error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
