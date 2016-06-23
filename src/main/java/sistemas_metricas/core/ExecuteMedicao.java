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

public class ExecuteMedicao {

	public static LinkedList<String> listaMedicoes = new LinkedList<>();
	public static LinkedList<Integer> listaValores = new LinkedList<>();

	public static LinkedList<String> getListaMedicoes() {
		return listaMedicoes;
	}

	public static void setListaMedicoes(LinkedList<String> listaMedicoes) {
		ExecuteMedicao.listaMedicoes = listaMedicoes;
	}

	public int getMedicaoByName(String nome) {
		for (int i = 0; i < listaMedicoes.size(); i++) {
			if (nome.equalsIgnoreCase(listaMedicoes.get(i))) {
				return listaValores.get(i);
			}
		}
		return -1;
	}

	public LinkedList<Integer> getMedicaoListName(LinkedList<String> listaNomes) {
		LinkedList<Integer> lista_valor = new LinkedList<>();
		
		for (int i = 0; i < listaNomes.size(); i++) {
			for (int j = 0; j < listaMedicoes.size(); j++) {
				if (listaNomes.get(i).equalsIgnoreCase(listaMedicoes.get(j))) {
					lista_valor.add(listaValores.get(j));
					break;
				}
			}
		}
		return lista_valor;
	}

	public void doMedicao(List<Medicao> medicoes) {
		Random randomGenerator = new Random();
		for (int i = 0; i < medicoes.size(); i++) {
			listaMedicoes.add(medicoes.get(i).getNome());
			listaValores.add(randomGenerator.nextInt(100));
		}
	}

}
