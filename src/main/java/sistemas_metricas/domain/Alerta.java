package sistemas_metricas.domain;

import java.util.Date;

public class Alerta {
	
	private Long id;
	private String nome;
	private Date created;
	private String metrica;
	private String valores;
	
	
	public Alerta() {
	}
	
	public Alerta(Long id, String nome, Date created, String metrica, String valores) {
		super();
		this.id = id;
		this.nome = nome;
		this.created = created;
		this.metrica = metrica;
		this.valores = valores;
	}







	public Alerta(Long id, String nome, Date created) {
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

	public String getMetrica() {
		return metrica;
	}


	public void setMetrica(String metrica) {
		this.metrica = metrica;
	}







	public String getValores() {
		return valores;
	}







	public void setValores(String valores) {
		this.valores = valores;
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
