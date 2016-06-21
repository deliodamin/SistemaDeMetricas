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
	
public List<Metrica> getMetrica(String id) {
		
		return repository.getMetrica(id);
		
	}
	
	public List<Metrica> getMetricasFull() {
		
		return repository.getMetricasFull();
		
	}

	public Metrica createMetrica(String nomeMetrica, String idsMedicoes, String host) {
		
		return repository.createMetrica(nomeMetrica, idsMedicoes, host);
		
	}

	
	
}
