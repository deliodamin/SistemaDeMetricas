package sistemas_metricas.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sistemas_metricas.domain.*;;

public class MetricaRowMapperFull implements RowMapper<Metrica> {

	public Metrica mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Metrica(rs.getLong("id"),rs.getString("nome"),rs.getDate("created"),rs.getString("medicoes"));
	}
	
}
