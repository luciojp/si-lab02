package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Estilo {
	
	@Id
	@GeneratedValue
	private long Id;
	
	@Column
	private String nome;
	
	public Estilo() {
		
	}
	
	public Estilo(String nome){
		this();
		this.nome = nome;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
