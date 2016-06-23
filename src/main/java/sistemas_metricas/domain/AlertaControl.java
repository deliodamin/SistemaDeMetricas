package sistemas_metricas.domain;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sistemas_metricas.persistence.*;



@Component
public class AlertaControl {
	
	@Autowired
	AlertaDao AlertaDao;
	
	public List<Alerta> getAlertas() {
		return this.AlertaDao.getAlertas();
	}
	
	public List<Alerta> getAlerta(String id) {
		return this.AlertaDao.getAlerta(id);
	}
	public List<Alerta> getAlertaBy_MetricaID(String id) {
		return this.AlertaDao.getAlertaBy_MetricaID(id);
	}
	

	public Alerta createAlerta(String nomeAlerta, String idMetrica, String valores) {
		Alerta nova = new Alerta(null,nomeAlerta, new Date(), idMetrica, valores );
		AlertaDao.createAlerta(nova);
		return nova;
	}

}
