package pe.edu.cibertec.dswii_ef_soap_castro.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_ef_soap_castro.service.IMedicamientoService;
import pe.edu.cibertec.dswii_ef_soap_castro.service.IPacienteService;
import pe.edu.cibertec.ws.object.*;

@Endpoint
public class MedicamentoEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/object";

    @Autowired
    private IMedicamientoService medicamientoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMedicamentosRequest")
    @ResponsePayload
    public GetMedicamentosResponse getMedicamentos(@RequestPayload GetMedicamentosRequest request){
        return medicamientoService.buscarMedicamentos();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMedicamentoRequest")
    @ResponsePayload
    public GetMedicamentoResponse getMedicamento(@RequestPayload GetMedicamentoRequest request){
        return medicamientoService.buscarMedicamentoXId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putMedicamentoRequest")
    @ResponsePayload
    public PutMedicamentoResponse actualizarMedicamento(@RequestPayload PutMedicamentoRequest request){
        return medicamientoService.actualizarMedicamento(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postMedicamentoRequest")
    @ResponsePayload
    public PostMedicamentoResponse saveMedicamento(@RequestPayload PostMedicamentoRequest request){
        return medicamientoService.registrarMedicamento(request);
    }
}
