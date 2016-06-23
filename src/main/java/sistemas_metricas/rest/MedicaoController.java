package sistemas_metricas.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import sistemas_metricas.domain.*;


@Component
@Produces("application/json")
@Consumes("application/json")
@Path("medicao")
public class MedicaoController {
	
	@Autowired
	MedicaoEXP service;
	
	@GET
	public Response getMetricas() {
		return Response
			.ok(service.getMedicoes())
			.build();
	}
	
	
	@GET
	@Path("/{id}")
	public Response getMetrica(@PathParam("id") final String id) {
			return Response
			.ok(service.getMedicao(id))
			.build();
	}
	
	@POST
	public Response createMetrica(String json) throws JsonProcessingException, IOException {
		
		
		ObjectMapper objectMapper = new ObjectMapper();

	
        JsonNode jsonNode = objectMapper.readTree(json);
        
        String nome = jsonNode.get("nome").asText();


		Medicao Medicao=null;
		Medicao nova = service.createMedicao(nome);
	
		return Response
				.accepted(nova)
				//.ok(nova)
				.build();
	}
}
