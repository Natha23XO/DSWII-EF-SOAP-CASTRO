package pe.edu.cibertec.dswii_ef_soap_castro.service;

import pe.edu.cibertec.ws.object.*;

public interface IMedicamientoService {
    PostMedicamentoResponse registrarMedicamento(PostMedicamentoRequest request);
    PutMedicamentoResponse actualizarMedicamento(PutMedicamentoRequest request);
    GetMedicamentosResponse buscarMedicamentos();
    GetMedicamentoResponse buscarMedicamentoXId(Integer id);
}
