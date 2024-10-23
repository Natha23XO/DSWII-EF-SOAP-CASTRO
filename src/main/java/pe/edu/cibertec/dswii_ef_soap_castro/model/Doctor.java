package pe.edu.cibertec.dswii_ef_soap_castro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "idespecialidad", nullable = false)
    private Especialidad especialidad;
    private String telefono;
    private String correo;
}
