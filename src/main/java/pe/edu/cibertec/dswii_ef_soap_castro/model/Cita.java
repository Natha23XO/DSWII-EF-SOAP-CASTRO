package pe.edu.cibertec.dswii_ef_soap_castro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Cita")
@Getter
@Setter
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "idpaciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "iddoctor", nullable = false)
    private Doctor doctor;
}
