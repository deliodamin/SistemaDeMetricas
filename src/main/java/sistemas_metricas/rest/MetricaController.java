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
@Path("metricas")
public class MetricaController {
	
	@Autowired
	MetricaEXP service;
	
	@GET
	public Response getMetricas() {
		return Response
			.ok(service.getMetricas())
			.build();
	}
	
	
	@GET
	@Path("/{id}")
	public Response getMetrica(@PathParam("id") final String id) {
			return Response
			.ok(service.getMetrica(id))
			.build();
	}
	
	
	
	@POST
	//@Path("/{id}")
	public Response createMetrica(String json) throws JsonProcessingException, IOException {
//		System.out.println(json);
		
		ObjectMapper objectMapper = new ObjectMapper();

	
        JsonNode jsonNode = objectMapper.readTree(json);
        
        String nome = jsonNode.get("nome").asText();
        String medicoes_id = jsonNode.get("medicoes_id").asText();
        String host = jsonNode.get("host").asText();
        
		 
		Metrica metrica=null;
		Metrica nova = service.createMetrica(nome, medicoes_id, host);
	
		return Response
				.accepted(nova)
				//.ok(nova)
				.build();
	}
}
