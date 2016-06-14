package sistemas_metricas.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicaoEXP {
	
	@Autowired
	MedicaoControl repository;
	
	public List<Medicao> getMedicao() {
		
		return repository.getMedicoes();
		
	}

	public Medicao createMedicao(String nomeMedicao) {
		
		return repository.createMedicao(nomeMedicao);
		
	}
	
	
}
