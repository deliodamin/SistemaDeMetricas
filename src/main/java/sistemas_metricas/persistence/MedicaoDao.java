package sistemas_metricas.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import sistemas_metricas.domain.Medicao;

@Component
public class MedicaoDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MedicaoDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
//	public Metrica getMetrica(Long id) {
//		return this.jdbcTemplate
//			.queryForObject(
//				"select * from metrica where id = ?", 
//				Metrica.class, id);
//	}
	
	public List<Medicao> getMedicoes() {
		return this.jdbcTemplate
			.query(
				"select * from medicao order by id", 
				new MedicaoRowMapper());
	}
	
	public List<Medicao> getMedicao(String id) {
		return this.jdbcTemplate
			.query(
				"select * from medicao where id = '"+id+"' order by id", 
				new MedicaoRowMapper());
	}

	public int createMedicao(Medicao medicao) {
		System.out.println(medicao.getNome());
		return jdbcTemplate.update(
			"insert into medicao (nome,created) values (?,?)", 
			medicao.getNome(),  
			
			medicao.getCreated());
	}
	
}
