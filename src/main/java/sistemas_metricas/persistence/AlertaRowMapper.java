package sistemas_metricas.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sistemas_metricas.domain.*;;

public class AlertaRowMapper implements RowMapper<Alerta> {

	public Alerta mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Alerta(rs.getLong("id"),rs.getString("nome"),rs.getDate("created"),rs.getString("metrica"),rs.getString("valores"));
	}
	
}
