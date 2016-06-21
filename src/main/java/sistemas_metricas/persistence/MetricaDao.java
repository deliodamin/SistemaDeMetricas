package sistemas_metricas.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import sistemas_metricas.domain.*;

@Component
public class MetricaDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MetricaDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
//	public Metrica getMetrica(Long id) {
//		return this.jdbcTemplate
//			.queryForObject(
//				"select * from metrica where id = ?", 
//				Metrica.class, id);
//	}
	
	public List<Metrica> getMetricas() {
		
		return this.jdbcTemplate
			.query("select * from metrica order by id",	new MetricaRowMapper());
	}
	
public List<Metrica> getMetrica(String id) {
		
		return this.jdbcTemplate
			.query("select * from metrica where id = '"+ id + "'order by id",	new MetricaRowMapper());
	}
	
	public List<Metrica> getMetricasFull() {
		return this.jdbcTemplate
			.query(
				"select * from metrica order by id", 
				new MetricaRowMapper());
	}

	public int createMetrica(Metrica metrica) {
		return jdbcTemplate.update(
			"insert into metrica (nome,created,medicoes, host) values (?,?,?,?)", 
			metrica.getNome(), 
			metrica.getCreated(), 
			metrica.getMedicoes(),
	     	metrica.getHost()
	     	);
	}
	
}
