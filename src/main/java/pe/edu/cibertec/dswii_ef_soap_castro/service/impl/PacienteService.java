package pe.edu.cibertec.dswii_ef_soap_castro.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_ef_soap_castro.exception.NotFoundException;
import pe.edu.cibertec.dswii_ef_soap_castro.model.Paciente;
import pe.edu.cibertec.dswii_ef_soap_castro.repository.PacienteRepository;
import pe.edu.cibertec.dswii_ef_soap_castro.service.IPacienteService;
import pe.edu.cibertec.dswii_ef_soap_castro.util.convert.PacienteConvert;
import pe.edu.cibertec.ws.object.*;

@RequiredArgsConstructor
@Service
public class PacienteService implements IPacienteService {
    private final PacienteRepository pacienteRepository;
    private final PacienteConvert pacienteConvert;

    @Override
    public PostPacienteResponse registrarPaciente(PostPacienteRequest request) {
        PostPacienteResponse postPacienteResponse = new PostPacienteResponse();
        Paciente nuevoPaciente = pacienteRepository.save(
                pacienteConvert.mapearAPaciente(request.getPaciente())
        );
        postPacienteResponse.setPaciente(
                pacienteConvert.mapearAPacientews(nuevoPaciente)
        );
        return postPacienteResponse;
    }

    @Override
    public PutPacienteResponse actualizarPaciente(PutPacienteRequest request) {
        PutPacienteResponse putPacienteResponse = new PutPacienteResponse();
        Paciente paciente = pacienteRepository.findById(request.getPaciente().getId()).orElse(null);
        if(paciente==null) {
            throw new NotFoundException("Paciente con el ID " + request.getPaciente().getId() + " no encontrado");
        }else {
            putPacienteResponse.setPaciente(
                    pacienteConvert.mapearAPacientews(pacienteRepository.save(
                            pacienteConvert.mapearAPaciente(request.getPaciente())
                    ))
            );
        }
        return putPacienteResponse;
    }

    @Override
    public GetPacientesResponse buscarPacientes() {
        GetPacientesResponse getPacientesResponse = new GetPacientesResponse();
        getPacientesResponse.getPacientes().addAll(
                pacienteConvert.mapearAPacientewsList(pacienteRepository.findAll())
        );
        return getPacientesResponse;
    }

    @Override
    public GetPacienteResponse buscarPacienteXId(Integer id) {
        GetPacienteResponse getPacienteResponse = new GetPacienteResponse();
        Paciente paciente = pacienteRepository.findById(id).orElse(null);
        if(paciente==null){
            throw new NotFoundException("Domicilio con el ID "+id+" no encontrado");
        }else{
            getPacienteResponse.setPaciente(
                    pacienteConvert.mapearAPacientews(paciente)
            );
        }

        return getPacienteResponse;
    }

}
