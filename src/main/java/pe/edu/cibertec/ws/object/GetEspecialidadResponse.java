//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.22 a las 11:09:23 PM PET 
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
 *         &lt;element name="especialidad" type="{http://www.cibertec.edu.pe/ws/object}especialidadws"/&gt;
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
    "especialidad"
})
@XmlRootElement(name = "getEspecialidadResponse")
public class GetEspecialidadResponse {

    @XmlElement(required = true)
    protected Especialidadws especialidad;

    /**
     * Obtiene el valor de la propiedad especialidad.
     * 
     * @return
     *     possible object is
     *     {@link Especialidadws }
     *     
     */
    public Especialidadws getEspecialidad() {
        return especialidad;
    }

    /**
     * Define el valor de la propiedad especialidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Especialidadws }
     *     
     */
    public void setEspecialidad(Especialidadws value) {
        this.especialidad = value;
    }

}
