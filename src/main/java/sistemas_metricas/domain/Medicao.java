package sistemas_metricas.domain;

import java.util.Date;

public class Medicao {
	
	private Long id;
	private String nome;
	private Date created;
	
	public Medicao() {
	}
	
	public Medicao(Long id, String nome, Date created) {
		this.id = id;
		this.nome = nome;
		this.created = created;
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
