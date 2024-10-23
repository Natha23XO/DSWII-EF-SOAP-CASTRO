package pe.edu.cibertec.dswii_ef_soap_castro.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_ef_soap_castro.model.Paciente;
import pe.edu.cibertec.ws.object.Pacientews;

import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteConvert {

    public Paciente mapearAPaciente(Pacientews pacientews){
        Paciente paciente = new Paciente();
        paciente.setId(pacientews.getId());
        paciente.setNombre(pacientews.getNombre());
        paciente.setDireccion(pacientews.getDireccion());
        paciente.setTelefono(pacientews.getTelefono());
        paciente.setFechanacimiento(pacientews.getFechanacimiento());
        return paciente;
    }
    public Pacientews mapearAPacientews(Paciente paciente){
        Pacientews pacientews = new Pacientews();
        pacientews.setId(paciente.getId());
        pacientews.setNombre(paciente.getNombre());
        pacientews.setDireccion(paciente.getDireccion());
        pacientews.setTelefono(paciente.getTelefono());
        pacientews.setFechanacimiento(paciente.getFechanacimiento());
        return pacientews;
    }

    public List<Paciente> mapearAPacienteList(List<Pacientews> pacientewsList){
        List<Paciente> pacienteList = new ArrayList<>();
        for(Pacientews pacientews : pacientewsList){
            pacienteList.add(mapearAPaciente(pacientews));
        }
        return pacienteList;
    }

    public List<Pacientews> mapearAPacientewsList(List<Paciente> pacienteList){
        List<Pacientews> pacientewsList = new ArrayList<>();
        for(Paciente paciente : pacienteList){
            pacientewsList.add(mapearAPacientews(paciente));
        }
        return pacientewsList;
    }
}
