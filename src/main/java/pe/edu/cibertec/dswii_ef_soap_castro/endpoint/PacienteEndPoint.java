package pe.edu.cibertec.dswii_ef_soap_castro.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_ef_soap_castro.service.IPacienteService;
import pe.edu.cibertec.ws.object.*;

@Endpoint
public class PacienteEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/object";

    @Autowired
    private IPacienteService pacienteService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPacientesRequest")
    @ResponsePayload
    public GetPacientesResponse getPacientes(@RequestPayload GetPacientesRequest request){
        return pacienteService.buscarPacientes();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPacienteRequest")
    @ResponsePayload
    public GetPacienteResponse getPaciente(@RequestPayload GetPacienteRequest request){
        return pacienteService.buscarPacienteXId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putPacienteRequest")
    @ResponsePayload
    public PutPacienteResponse actualizarPaciente(@RequestPayload PutPacienteRequest request){
        return pacienteService.actualizarPaciente(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postPacienteRequest")
    @ResponsePayload
    public PostPacienteResponse savePaciente(@RequestPayload PostPacienteRequest request){
        return pacienteService.registrarPaciente(request);
    }


}
