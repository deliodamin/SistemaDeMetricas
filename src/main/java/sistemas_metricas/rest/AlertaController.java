package sistemas_metricas.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.boot.json.JsonJsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import sistemas_metricas.domain.*;


@Component
@Produces("application/json")
@Consumes("application/json")
@Path("Alerta")
public class AlertaController {
	
	@Autowired
	AlertaEXP service;
	
	@GET
	public Response getAlertas() {
		System.out.println("test");
		return Response
			.ok(service.getAlertas())
			.build();
	}
	
	@POST
	@Path("/{id}")
	public Response createAlerta(@PathParam("id") final String identifier, String json) throws JsonProcessingException, IOException {

		
		ObjectMapper objectMapper = new ObjectMapper();

	
        JsonNode jsonNode = objectMapper.readTree(json);
        
        String nome = jsonNode.get("nome").asText();
        String metrica_id = jsonNode.get("metrica_id").asText();
        String valores = jsonNode.get("valores").asText();
        

        //JsonNode resultNode = jsonNode.get("results");
       
		
		Alerta Alerta=null;
		Alerta nova =  service.createAlerta(nome, metrica_id, valores);
	
		return Response
				.accepted(nova)
				//.ok(nova)
				.build();
	}
}
