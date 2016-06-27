package sistemas_metricas.rest;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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

import sistemas_metricas.core.ExecuteMedicao;
import sistemas_metricas.core.WriteTXT;
import sistemas_metricas.domain.*;
import sistemas_metricas.core.WriteTXT;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;




@Component
@Produces("application/json")
@Consumes("application/json")
@Path("app")
public class AppController {
	
	@Autowired
	MedicaoEXP medicao_service;
	
	@Autowired
	MetricaEXP metrica_service;
	
	@Autowired
	AlertaEXP alerta_service;
	
	
	@GET
	public Response startApp() throws Throwable {
		ExecuteMedicao exeMedicao= new ExecuteMedicao();
		
		List<Metrica> lista_metricas = metrica_service.getMetricas();
		
		LinkedList<String> lista_medicoes = new LinkedList<>();
		LinkedList<Integer> lista_valores = new LinkedList<>();
		
		WriteTXT callTXT = new WriteTXT();
		String valor = "";

	
		
		exeMedicao.doMedicao(medicao_service.getMedicoes());
		
		for(int i=0;i<lista_metricas.size();i++){
			String medicoes_ids = lista_metricas.get(i).getMedicoes();
			String[] ids = medicoes_ids.split(",");
			
			System.out.println(lista_metricas.get(i).getNome());
			
			for(int j=0;j<ids.length;j++){
				if(medicao_service.getMedicao(ids[j]).size()>0){
					lista_medicoes.add(medicao_service.getMedicao(ids[j]).get(0).getNome());
				}
			}
			
			lista_valores = exeMedicao.getMedicaoListName(lista_medicoes);
			for(int j=0;j<lista_medicoes.size();j++){
				System.out.println(lista_medicoes.get(j) +" = "+lista_valores.get(j));
			}
			
			/*alertas TODO*/
			List<Alerta> lista_alertas = alerta_service.getAlertaBy_MetricaID(String.valueOf(lista_metricas.get(i).getId()));

			for(int j=0;j<lista_alertas.size();j++){
				System.out.println("Nome alerta = "+lista_alertas.get(j).getNome());
				String[] condicao_alerta = lista_alertas.get(j).getValores().split(",");
				
				for(int k=0;k<condicao_alerta.length;k++){
					int valor_medicao = exeMedicao.getMedicaoByName(lista_medicoes.get(k));
					System.out.println(valor_medicao+" e "+condicao_alerta[k]);
					
					if(condicao_alerta[k].contains(">=")){
						int valor_condicao = Integer.parseInt(condicao_alerta[k].replace(">=", "").trim());
						if(valor_medicao>=valor_condicao){
							//callTXT.WriteArchive(dateFormat.format(date) + " Nome do Alerta: "+ lista_alertas.get(j).getNome() +  " Nome da métrica: "+ lista_metricas.get(i).getNome() + " Nome da medição: " + lista_medicoes.get(j) + " Condição: " + valor_medicao +" >= " + valor_condicao);
						valor = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()) + " Nome do Alerta: "+ lista_alertas.get(j).getNome() +  " Nome da métrica: "+ lista_metricas.get(i).getNome() + " Nome da medição: " + lista_medicoes.get(k) + " Condição: " + valor_medicao +" >= " + valor_condicao + System.getProperty("line.separator");
						callTXT.WriteArchive(valor);
							System.out.println("Escreve arquivo >=");	
							
						}
					}
					else if(condicao_alerta[k].contains("<=")){
						int valor_condicao = Integer.parseInt(condicao_alerta[k].replace("<=", "").trim());
						if(valor_medicao<=valor_condicao){
//							callTXT.WriteArchive(dateFormat.format(date) + " Nome do Alerta AA: "+ lista_alertas.get(j).getNome() +  " Nome da métrica: "+ lista_metricas.get(i).getNome() + " Nome da medição: " + lista_medicoes.get(j) + " Condição: " + valor_medicao +" >= " + valor_condicao);
							valor =  new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()) + " Nome do Alerta: "+ lista_alertas.get(j).getNome() +  " Nome da métrica: "+ lista_metricas.get(i).getNome() + " Nome da medição: " + lista_medicoes.get(k) + " Condição: " + valor_medicao +" <= " + valor_condicao + System.getProperty("line.separator");
							callTXT.WriteArchive(valor);
							System.out.println("Escreve arquivo <=");
						}
					}else if(condicao_alerta[k].contains("<")){
						int valor_condicao = Integer.parseInt(condicao_alerta[k].replace("<", "").trim());
						if(valor_medicao<valor_condicao){
//							callTXT.WriteArchive(dateFormat.format(date) + " Nome do Alerta: "+ lista_alertas.get(j).getNome() +  " Nome da métrica: "+ lista_metricas.get(i).getNome() + " Nome da medição: " + lista_medicoes.get(j) + " Condição: " + valor_medicao +" >= " + valor_condicao);
							valor = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()) + " Nome do Alerta: "+ lista_alertas.get(j).getNome() +  " Nome da métrica: "+ lista_metricas.get(i).getNome() + " Nome da medição: " + lista_medicoes.get(k) + " Condição: " + valor_medicao +" < " + valor_condicao + System.getProperty("line.separator");
							callTXT.WriteArchive(valor);
							System.out.println("Escreve arquivo <");
						}
					}else if(condicao_alerta[k].contains(">")){
						int valor_condicao = Integer.parseInt(condicao_alerta[k].replace(">", "").trim());
						if(valor_medicao>valor_condicao){
//							callTXT.WriteArchive(dateFormat.format(date) + " Nome do Alerta: "+ lista_alertas.get(j).getNome() +  " Nome da métrica: "+ lista_metricas.get(i).getNome() + " Nome da medição: " + lista_medicoes.get(j) + " Condição: " + valor_medicao +" >= " + valor_condicao);
							valor =  new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()) + " Nome do Alerta: "+ lista_alertas.get(j).getNome() +  " Nome da métrica: "+ lista_metricas.get(i).getNome() + " Nome da medição: " + lista_medicoes.get(k) + " Condição: " + valor_medicao +" > " + valor_condicao + System.getProperty("line.separator");
							callTXT.WriteArchive(valor);
							System.out.println("Escreve arquivo >");
						}
					}else if(condicao_alerta[k].contains("=")){
						int valor_condicao = Integer.parseInt(condicao_alerta[k].replace("=", "").trim());
						if(valor_medicao==valor_condicao){
//							callTXT.WriteArchive(dateFormat.format(date) + " Nome do Alerta: "+ lista_alertas.get(j).getNome() +  " Nome da métrica: "+ lista_metricas.get(i).getNome() + " Nome da medição: " + lista_medicoes.get(j) + " Condição: " + valor_medicao +" >= " + valor_condicao);
							valor = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date()) + " Nome do Alerta: "+ lista_alertas.get(j).getNome() +  " Nome da métrica: "+ lista_metricas.get(i).getNome() + " Nome da medição: " + lista_medicoes.get(k) + " Condição: " + valor_medicao +" = " + valor_condicao + System.getProperty("line.separator");
							callTXT.WriteArchive(valor);
							System.out.println("Escreve arquivo =");
						}
					}
				
					else {
						
							System.out.println("Erro formato");
						
					}
				}
				
			}
			
			lista_medicoes.clear();
			lista_valores.clear();
			
			

			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
//		for(int i=0;i<valores.size();i++){
//			System.out.println(teste.get(i)+" = "+valores.get(i));
//		}
//		
//		for(int i=0;i<exeMedicao.listaMedicoes.size();i++){
//			System.out.println(exeMedicao.listaMedicoes.get(i)+" = "+exeMedicao.listaValores.get(i));
//		}
		
		
		return Response
			.ok(medicao_service.getMedicoes())
			.build();
	}
	
	@POST
	public Response createMetrica(String json) throws JsonProcessingException, IOException {
		
		
		ObjectMapper objectMapper = new ObjectMapper();

	
        JsonNode jsonNode = objectMapper.readTree(json);
        
        String nome = jsonNode.get("nome").asText();


		Medicao Medicao=null;
		Medicao nova = medicao_service.createMedicao(nome);
	
		return Response
				.accepted(nova)
				//.ok(nova)
				.build();
	}
}
