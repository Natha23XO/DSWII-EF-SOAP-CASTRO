package pe.edu.cibertec.dswii_ef_soap_castro.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_ef_soap_castro.exception.NotFoundException;
import pe.edu.cibertec.dswii_ef_soap_castro.model.Especialidad;
import pe.edu.cibertec.dswii_ef_soap_castro.repository.EspecialidadRepository;
import pe.edu.cibertec.dswii_ef_soap_castro.service.IEspecialidadService;
import pe.edu.cibertec.dswii_ef_soap_castro.util.convert.EspecialidadConvert;
import pe.edu.cibertec.ws.object.*;

@RequiredArgsConstructor
@Service
public class EspecialidadService implements IEspecialidadService {
    private final EspecialidadRepository especialidadRepository;
    private final EspecialidadConvert especialidadConvert;

    @Override
    public PostEspecialidadResponse registrarEspecialidad(PostEspecialidadRequest request) {
        PostEspecialidadResponse postEspecialidadResponse = new PostEspecialidadResponse();
        Especialidad nuevaEspecialidad = especialidadRepository.save(
                especialidadConvert.mapearAEspecialidad(request.getEspecialidad())
        );
        postEspecialidadResponse.setEspecialidad(
                especialidadConvert.mapearAEspecialidadws(nuevaEspecialidad)
        );
        return postEspecialidadResponse;
    }

    @Override
    public PutEspecialidadResponse actualizarEspecilidad(PutEspecialidadRequest request) {
        PutEspecialidadResponse putEspecialidadResponse = new PutEspecialidadResponse();
        Especialidad especialidad = especialidadRepository.findById(request.getEspecialidad().getId()).orElse(null);
        if(especialidad == null){
            throw new NotFoundException("Especialidad con el ID "+request.getEspecialidad().getId()+" no encontrado");
        }else {
            putEspecialidadResponse.setEspecialidad(
                    especialidadConvert.mapearAEspecialidadws(especialidadRepository.save(
                            especialidadConvert.mapearAEspecialidad(request.getEspecialidad())
                    ))
            );
        }
        return putEspecialidadResponse;
    }

    @Override
    public GetEspecialidadesResponse buscarEspecialidades() {
        GetEspecialidadesResponse getEspecialidadesResponse = new GetEspecialidadesResponse();
        getEspecialidadesResponse.getEspecialidades().addAll(
                especialidadConvert.mapearAEspecialidadwsList(especialidadRepository.findAll())
        );
        return getEspecialidadesResponse;
    }

    @Override
    public GetEspecialidadResponse buscarEspecialidadXId(Integer id) {
        GetEspecialidadResponse getEspecialidadResponse = new GetEspecialidadResponse();
        Especialidad especialidad = especialidadRepository.findById(id).orElse(null);
        if(especialidad==null){
            throw new NotFoundException("Especialidad con el ID "+id+" no encontrado");
        }else {
            getEspecialidadResponse.setEspecialidad(
                    especialidadConvert.mapearAEspecialidadws(especialidad)
            );
        }
        return getEspecialidadResponse;
    }
}
