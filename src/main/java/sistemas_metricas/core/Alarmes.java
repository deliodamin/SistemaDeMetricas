package sistemas_metricas.core;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sistemas_metricas.domain.Medicao;
import sistemas_metricas.domain.MedicaoEXP;
import sistemas_metricas.domain.Metrica;
import sistemas_metricas.persistence.MedicaoDao;
import sistemas_metricas.persistence.MetricaDao;

import java.util.Random;

public class Alarmes {

	private String mensagem;

	public Alarmes(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
