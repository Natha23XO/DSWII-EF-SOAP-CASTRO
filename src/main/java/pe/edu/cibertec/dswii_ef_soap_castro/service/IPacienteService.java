package pe.edu.cibertec.dswii_ef_soap_castro.service;

import pe.edu.cibertec.ws.object.*;

public interface IPacienteService {
    PostPacienteResponse registrarPaciente(PostPacienteRequest request);
    PutPacienteResponse actualizarPaciente(PutPacienteRequest request);
    GetPacientesResponse buscarPacientes();
    GetPacienteResponse buscarPacienteXId(Integer id);
}
