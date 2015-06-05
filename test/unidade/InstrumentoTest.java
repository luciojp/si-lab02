package unidade;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import models.Anuncio;
import models.Instrumento;
import models.dao.GenericDAO;

import org.junit.Test;

public class InstrumentoTest {
	
	List<Instrumento> instrumentos;
	GenericDAO dao = new GenericDAO();
	
	
	@Test
	public void deveSalvarInstrumento(){
		
//		instrumentos = dao.findAllByClass(Instrumento.class); //consulta o bd
//		assertThat(instrumentos.size()).isEqualTo(0);
//		
//		Instrumento novoInstrumento = new Instrumento("Violoncelo");
//		dao.persist(novoInstrumento);
//		
//		instrumentos = dao.findAllByClass(Anuncio.class); //consulta o bd
//		assertThat(instrumentos.size()).isEqualTo(1);
//		assertThat(instrumentos.get(0).getNome()).isEqualTo("Violoncelo");
		
	}

}
