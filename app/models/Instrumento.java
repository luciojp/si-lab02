package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.common.base.Objects;

@Entity
public class Instrumento {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String nome;

	public Instrumento() {
	}

	public Instrumento(String nome) {
		this();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Instrumento)) {
			return false;
		}

		Instrumento outroInstrumento = (Instrumento) obj;
		return Objects.equal(outroInstrumento.getNome(), this.getNome());

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.nome);
	}

}
