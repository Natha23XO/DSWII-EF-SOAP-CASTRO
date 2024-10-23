package pe.edu.cibertec.dswii_ef_soap_castro.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_ef_soap_castro.service.IEspecialidadService;
import pe.edu.cibertec.dswii_ef_soap_castro.service.IMedicamientoService;
import pe.edu.cibertec.ws.object.*;

@Endpoint
public class EspecialidadEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/object";

    @Autowired
    private IEspecialidadService especialidadService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEspecialidadesRequest")
    @ResponsePayload
    public GetEspecialidadesResponse getEspecialidades(@RequestPayload GetEspecialidadesRequest request){
        return especialidadService.buscarEspecialidades();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEspecialidadRequest")
    @ResponsePayload
    public GetEspecialidadResponse getEspecialidad(@RequestPayload GetEspecialidadRequest request){
        return especialidadService.buscarEspecialidadXId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putEspecialidadRequest")
    @ResponsePayload
    public PutEspecialidadResponse actualizarEspecialidad(@RequestPayload PutEspecialidadRequest request){
        return especialidadService.actualizarEspecilidad(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postEspecialidadRequest")
    @ResponsePayload
    public PostEspecialidadResponse saveEspecialidad(@RequestPayload PostEspecialidadRequest request){
        return especialidadService.registrarEspecialidad(request);
    }
}
