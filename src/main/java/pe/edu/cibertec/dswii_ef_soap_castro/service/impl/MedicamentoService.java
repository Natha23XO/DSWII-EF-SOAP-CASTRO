package pe.edu.cibertec.dswii_ef_soap_castro.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_ef_soap_castro.exception.NotFoundException;
import pe.edu.cibertec.dswii_ef_soap_castro.model.Medicamento;
import pe.edu.cibertec.dswii_ef_soap_castro.model.Paciente;
import pe.edu.cibertec.dswii_ef_soap_castro.repository.MedicamentoRepository;
import pe.edu.cibertec.dswii_ef_soap_castro.service.IMedicamientoService;
import pe.edu.cibertec.dswii_ef_soap_castro.util.convert.MedicamentoConvert;
import pe.edu.cibertec.ws.object.*;

@RequiredArgsConstructor
@Service
public class MedicamentoService implements IMedicamientoService {
    private final MedicamentoRepository medicamentoRepository;
    private final MedicamentoConvert medicamentoConvert;

    @Override
    public PostMedicamentoResponse registrarMedicamento(PostMedicamentoRequest request) {
        PostMedicamentoResponse postMedicamentoResponse = new PostMedicamentoResponse();
        Medicamento nuevoMedicamento = medicamentoRepository.save(
                medicamentoConvert.mapearAMedicamento(request.getMedicamento())
        );
        postMedicamentoResponse.setMedicamento(
                medicamentoConvert.mapearAMedicamentows(nuevoMedicamento)
        );
        return postMedicamentoResponse;
    }

    @Override
    public PutMedicamentoResponse actualizarMedicamento(PutMedicamentoRequest request) {
        PutMedicamentoResponse putMedicamentoResponse = new PutMedicamentoResponse();
        Medicamento medicamento = medicamentoRepository.findById(request.getMedicamento().getId()).orElse(null);
        if(medicamento==null) {
            throw new NotFoundException("Medicamento con el ID " + request.getMedicamento().getId() + " no encontrado");
        }else {
            putMedicamentoResponse.setMedicamento(
                    medicamentoConvert.mapearAMedicamentows(medicamentoRepository.save(
                            medicamentoConvert.mapearAMedicamento(request.getMedicamento())
                    ))
            );
        }
        return putMedicamentoResponse;
    }

    @Override
    public GetMedicamentosResponse buscarMedicamentos() {
        GetMedicamentosResponse getMedicamentosResponse = new GetMedicamentosResponse();
        getMedicamentosResponse.getMedicamentos().addAll(
                medicamentoConvert.mapearAMedicamentowsList(medicamentoRepository.findAll())
        );
        return getMedicamentosResponse;
    }

    @Override
    public GetMedicamentoResponse buscarMedicamentoXId(Integer id) {
        GetMedicamentoResponse getMedicamentoResponse = new GetMedicamentoResponse();
        Medicamento medicamento = medicamentoRepository.findById(id).orElse(null);
        if(medicamento==null){
            throw new NotFoundException("Medicamento con el ID "+id+" no encontrado");
        }else{
            getMedicamentoResponse.setMedicamento(
                    medicamentoConvert.mapearAMedicamentows(medicamento)
            );
        }
        return getMedicamentoResponse;
    }
}
