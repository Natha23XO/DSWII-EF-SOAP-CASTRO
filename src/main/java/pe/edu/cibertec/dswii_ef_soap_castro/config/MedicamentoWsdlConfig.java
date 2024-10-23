package pe.edu.cibertec.dswii_ef_soap_castro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class MedicamentoWsdlConfig {

    @Bean(name = "medicamentos")
    public DefaultWsdl11Definition domicilioWsdl11Definition(XsdSchema medicamentosEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("MedicamentosPort");
        wsdl11Definition.setLocationUri("/ws/medicamento");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/object");
        wsdl11Definition.setSchema(medicamentosEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema medicamentosEsquema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/medicamento.xsd"));
    }
}
