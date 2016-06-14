package sistemas_metricas.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sistemas_metricas.domain.*;;

public class MedicaoRowMapper implements RowMapper<Medicao> {

	public Medicao mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Medicao(rs.getLong("id"),rs.getString("nome"),rs.getDate("created"));
	}
	
}
