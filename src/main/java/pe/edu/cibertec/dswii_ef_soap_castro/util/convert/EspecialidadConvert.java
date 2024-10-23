package pe.edu.cibertec.dswii_ef_soap_castro.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_ef_soap_castro.model.Especialidad;
import pe.edu.cibertec.ws.object.Especialidadws;

import java.util.ArrayList;
import java.util.List;

@Component
public class EspecialidadConvert {

    public Especialidad mapearAEspecialidad(Especialidadws especialidadws){
        Especialidad especialidad = new Especialidad();
        especialidad.setId(especialidadws.getId());
        especialidad.setNombre(especialidadws.getNombre());
        especialidad.setDescripcion(especialidadws.getDescripcion());
        return especialidad;
    }
    public Especialidadws mapearAEspecialidadws(Especialidad especialidad){
        Especialidadws especialidadws = new Especialidadws();
        especialidadws.setId(especialidad.getId());
        especialidadws.setNombre(especialidad.getNombre());
        especialidadws.setDescripcion(especialidad.getDescripcion());
        return especialidadws;
    }
    public List<Especialidad> mapearAEspecialidadList(List<Especialidadws> especialidadwsList){
        List<Especialidad> especialidadList = new ArrayList<>();
        for(Especialidadws especialidadws : especialidadwsList){
            especialidadList.add(mapearAEspecialidad(especialidadws));
        }
        return especialidadList;
    }
    public List<Especialidadws> mapearAEspecialidadwsList(List<Especialidad> especialidadList){
        List<Especialidadws> especialidadwsList = new ArrayList<>();
        for(Especialidad especialidad : especialidadList){
            especialidadwsList.add(mapearAEspecialidadws(especialidad));
        }
        return especialidadwsList;
    }

}
