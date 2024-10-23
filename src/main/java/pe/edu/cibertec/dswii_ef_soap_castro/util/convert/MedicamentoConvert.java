package pe.edu.cibertec.dswii_ef_soap_castro.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_ef_soap_castro.model.Medicamento;
import pe.edu.cibertec.ws.object.Medicamentows;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedicamentoConvert {

    public Medicamento mapearAMedicamento(Medicamentows medicamentows) {
        Medicamento medicamento = new Medicamento();
        medicamento.setId(medicamentows.getId());
        medicamento.setNombre(medicamentows.getNombre());
        medicamento.setDescripcion(medicamentows.getDescripcion());
        medicamento.setPrecio(medicamentows.getPrecio());
        return medicamento;
    }
    public Medicamentows mapearAMedicamentows(Medicamento medicamento) {
        Medicamentows medicamentows = new Medicamentows();
        medicamentows.setId(medicamento.getId());
        medicamentows.setNombre(medicamento.getNombre());
        medicamentows.setDescripcion(medicamento.getDescripcion());
        medicamentows.setPrecio(medicamento.getPrecio());
        return medicamentows;
    }
    public List<Medicamento> mapearAMedicamentoList(List<Medicamentows> medicamentowsList) {
        List<Medicamento> medicamentoList = new ArrayList<>();
        for (Medicamentows medicamentows : medicamentowsList) {
            medicamentoList.add(mapearAMedicamento(medicamentows));
        }
        return medicamentoList;
    }
    public List<Medicamentows> mapearAMedicamentowsList(List<Medicamento> medicamentoList) {
        List<Medicamentows> medicamentowsList = new ArrayList<>();
        for (Medicamento medicamento : medicamentoList) {
            medicamentowsList.add(mapearAMedicamentows(medicamento));
        }
        return medicamentowsList;
    }

}
