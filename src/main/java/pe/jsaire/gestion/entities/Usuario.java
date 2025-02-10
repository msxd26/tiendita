package pe.jsaire.gestion.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @Column(unique = true)
    private String email;
    private String password;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;


    @PrePersist
    public void prePersist() {
        fechaCreacion = LocalDate.now();
    }
}
