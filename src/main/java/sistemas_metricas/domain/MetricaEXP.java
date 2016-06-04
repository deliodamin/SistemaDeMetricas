package sistemas_metricas.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetricaEXP {
	
	@Autowired
	MetricaControl repository;
	
	public List<Metrica> getMetricas() {
		
		return repository.getMetricas();
		
	}

	public Metrica createMetrica(String nomeMetrica) {
		
		return repository.createMetrica(nomeMetrica);
		
	}
	
	
}
