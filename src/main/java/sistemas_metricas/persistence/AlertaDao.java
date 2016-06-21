package sistemas_metricas.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import sistemas_metricas.domain.*;

@Component
public class AlertaDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AlertaDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
//	public Metrica getMetrica(Long id) {
//		return this.jdbcTemplate
//			.queryForObject(
//				"select * from metrica where id = ?", 
//				Metrica.class, id);
//	}
	
	public List<Alerta> getAlertas() {
		
		return this.jdbcTemplate
			.query("select * from Alerta order by id",	new AlertaRowMapper());
	}
	
	public List<Alerta> getAlerta(String id) {
		
		return this.jdbcTemplate
			.query("select * from Alerta where id = '"+id+"' order by id",	new AlertaRowMapper());
	}
	
	public List<Alerta> getAlertasFull() {
		return this.jdbcTemplate
			.query(
				"select * from Alerta order by id", 
				new AlertaRowMapper());
	}

	public int createAlerta(Alerta Alerta) {
		return jdbcTemplate.update(
			"insert into Alerta (nome,created,metrica_id, valores) values (?,?,?,?)", 
			Alerta.getNome(), 
			Alerta.getCreated(), 
			Alerta.getMetrica(),
			Alerta.getValores()
			);
	}
	
}
