package pe.jsaire.gestion.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class ErrorDTO {

    private String message;
    private String error;
    private int status;
    private LocalDateTime timestamp;
}
