package pe.edu.cibertec.dswii_ef_soap_castro.service;

import pe.edu.cibertec.ws.object.*;

public interface IEspecialidadService {
    PostEspecialidadResponse registrarEspecialidad(PostEspecialidadRequest request);
    PutEspecialidadResponse actualizarEspecilidad(PutEspecialidadRequest request);
    GetEspecialidadesResponse buscarEspecialidades();
    GetEspecialidadResponse buscarEspecialidadXId(Integer id);
}
