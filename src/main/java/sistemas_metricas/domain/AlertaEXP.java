package sistemas_metricas.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlertaEXP {
	
	@Autowired
	AlertaControl repository;
	
	public List<Alerta> getAlertas() {
		return repository.getAlertas();
		
	}
	
	public List<Alerta> getAlerta(String id) {
		
		return repository.getAlerta(id);
		
	}
	
	public List<Alerta> getAlertaBy_MetricaID(String id) {
		
		return repository.getAlertaBy_MetricaID(id);
		
	}

	public Alerta createAlerta(String nomeAlerta, String idMetrica, String valores) {
		
		return repository.createAlerta(nomeAlerta, idMetrica, valores);
		
	}
	
	
}
