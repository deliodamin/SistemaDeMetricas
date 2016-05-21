package sistemas_metricas.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	@POST
	public Response createMetrica(Metrica metrica) {
		
		Metrica nova = service.createMetrica(metrica.getNome());
		System.out.println("Xélby");
		return Response
				.accepted(nova)
				//.ok(nova)
				.build();
	}
	
	
}
