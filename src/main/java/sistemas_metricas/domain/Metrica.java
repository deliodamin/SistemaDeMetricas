package sistemas_metricas.domain;

import java.util.Date;

public class Metrica {
	
	private Long id;
	private String nome;
	private Date created;
	private String medicoes;
	
	public Metrica() {
	}
	
	
	
	public Metrica(Long id, String nome, Date created, String medicoes) {
		this.id = id;
		this.nome = nome;
		this.created = created;
		this.medicoes = medicoes;
	}



	public Metrica(Long id, String nome, Date created) {
		this.id = id;
		this.nome = nome;
		this.created = created;
	}

	public String getMedicoes() {
		return medicoes;
	}

	public void setMedicoes(String medicoes) {
		this.medicoes = medicoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
