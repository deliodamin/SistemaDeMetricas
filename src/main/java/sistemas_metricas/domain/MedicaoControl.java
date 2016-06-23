package sistemas_metricas.domain;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sistemas_metricas.persistence.*;



@Component
public class MedicaoControl {
	
	@Autowired
	MedicaoDao medicaoDAO;
	
	public List<Medicao> getMedicoes() {
		return this.medicaoDAO.getMedicoes();
	}
	
	public List<Medicao> getMedicao(String id) {
		return this.medicaoDAO.getMedicao(id);
	}

	public Medicao createMedicao(String nomeMedicao) {
		
		Medicao nova = new Medicao(null,nomeMedicao, new Date());
		medicaoDAO.createMedicao(nova);
		return nova;
	}

}
