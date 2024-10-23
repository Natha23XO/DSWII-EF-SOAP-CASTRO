package pe.edu.cibertec.dswii_ef_soap_castro.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "RecetaMedica")
public class RecetaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idcita", nullable = false)
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "idmedicamento", nullable = false)
    private Medicamento medicamento;

    private String instrucciones;

}
