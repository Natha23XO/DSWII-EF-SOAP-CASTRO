//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.22 a las 10:42:33 PM PET 
//


package pe.edu.cibertec.ws.object;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="medicamento" type="{http://www.cibertec.edu.pe/ws/object}medicamentows"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "medicamento"
})
@XmlRootElement(name = "postMedicamentoRequest")
public class PostMedicamentoRequest {

    @XmlElement(required = true)
    protected Medicamentows medicamento;

    /**
     * Obtiene el valor de la propiedad medicamento.
     * 
     * @return
     *     possible object is
     *     {@link Medicamentows }
     *     
     */
    public Medicamentows getMedicamento() {
        return medicamento;
    }

    /**
     * Define el valor de la propiedad medicamento.
     * 
     * @param value
     *     allowed object is
     *     {@link Medicamentows }
     *     
     */
    public void setMedicamento(Medicamentows value) {
        this.medicamento = value;
    }

}
