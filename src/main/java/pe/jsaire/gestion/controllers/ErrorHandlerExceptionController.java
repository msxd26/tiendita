package pe.jsaire.gestion.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import pe.jsaire.gestion.dto.ErrorDTO;
import pe.jsaire.gestion.exceptions.ProductoNotFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandlerExceptionController {


    @ExceptionHandler({NullPointerException.class,ProductoNotFoundException.class})
    public ResponseEntity<ErrorDTO> handleException(Exception ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimestamp(LocalDateTime.now());
        errorDTO.setError("No Existe");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.internalServerError().body(errorDTO);
    }

    /*

    @ExceptionHandler({NoHandlerFoundException.class, ProductoNotFoundException.class})
    public ResponseEntity<ErrorDTO> handleException(NoHandlerFoundException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimestamp(LocalDateTime.now());
        errorDTO.setError("No Existe");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

     */



    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ErrorDTO> number(NoHandlerFoundException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimestamp(LocalDateTime.now());
        errorDTO.setError("No Existe");
        errorDTO.setMessage(ex.getMessage());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }



}
