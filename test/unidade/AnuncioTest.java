package unidade;
import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import models.Anuncio;
import models.dao.GenericDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import play.db.jpa.JPA;

public class AnuncioTest {

	 GenericDAO dao = new GenericDAO();
	 List<Anuncio> anuncios;
	 
	 @Test
	 public void deveSalvarAnuncio(){
		 
//		 anuncios = dao.findAllByClass(Anuncio.class); 
//		 assertThat(anuncios.size()).isEqualTo(0);
//		 
//		 Anuncio novoAnuncio = new Anuncio("Violoncelista", "Cello Eagle CE200", "João Pessoa", "Altiplano", "antoniolucio_@hotmail.com", "www.facebook.com/antonio.lucio.58");
//		 dao.persist(novoAnuncio);
//		 
//		 anuncios = dao.findAllByClass(Anuncio.class); 
//		 assertThat(anuncios.size()).isEqualTo(1);
//		 assertThat(anuncios.get(0).getTitulo()).isEqualTo("Vendo Cello");
		 
	 }
	
	
	
}
