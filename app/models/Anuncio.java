package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.common.base.Objects;

@Entity
public class Anuncio {
	
	@Id
	@GeneratedValue
	private long id;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Instrumento> instrumentos;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Estilo> estilos;
	
	@Column
	private String titulo, descricao, cidade, bairro, email, facebook;
	
	@Column
	private boolean procuraBanda;
	
	@Temporal(TemporalType.DATE)
	@Column
	private static Calendar data;
	
	
	public Anuncio() {
		this.instrumentos = new ArrayList<Instrumento>();
		this.estilos = new ArrayList<Estilo>();
		setData(Calendar.getInstance());
	}
	
	public Anuncio(String titulo, String descricao, String cidade, String bairro, String email, String facebook){
		this();
		this.titulo = titulo;
		this.descricao = descricao;
		this.cidade = cidade;
		this.bairro = bairro;
		this.email = email;
		this.facebook = facebook;
		
	}
	
	public String getDataCriacao(){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataCriacao = formato.format(getData().getTime());
		return dataCriacao;
	}
	
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Anuncio)){
			return false;
		}
	
		Anuncio outroAnuncio = (Anuncio) obj;
		return Objects.equal(outroAnuncio.getTitulo(), this.getTitulo());
		
	}
	
	
	
	public List<Estilo> getEstilos() {
		return estilos;
	}

	public void setEstilos(List<Estilo> estilos) {
		this.estilos = estilos;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getTitulo());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(List<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public boolean isProcuraBanda() {
		return procuraBanda;
	}

	public void setProcuraBanda(boolean procuraBanda) {
		this.procuraBanda = procuraBanda;
	}
	
	
	
	
}
