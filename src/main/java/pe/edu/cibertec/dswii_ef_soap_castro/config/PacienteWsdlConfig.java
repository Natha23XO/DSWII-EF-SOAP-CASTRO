package pe.edu.cibertec.dswii_ef_soap_castro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class PacienteWsdlConfig {

    @Bean(name = "pacientes")
    public DefaultWsdl11Definition domicilioWsdl11Definition(XsdSchema pacientesEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PacientesPort");
        wsdl11Definition.setLocationUri("/ws/paciente");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/object");
        wsdl11Definition.setSchema(pacientesEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema pacientesEsquema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/paciente.xsd"));
    }
}
