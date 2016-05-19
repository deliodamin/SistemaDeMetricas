package sistemas_metricas.domain;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sistemas_metricas.persistence.*;



@Component
public class MetricaControl {
	
	@Autowired
	MetricaDao metricaDao;
	
	public List<Metrica> getMetricas() {
		return this.metricaDao.getMetricas();
	}

	public Metrica createMetrica(String nomeMetrica) {
		
		Metrica nova = new Metrica(null,nomeMetrica, new Date());
		metricaDao.createMetrica(nova);
		return nova;
	}

}
