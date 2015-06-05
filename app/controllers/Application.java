package controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import models.Anuncio;
import models.Estilo;
import models.Instrumento;
import models.dao.GenericDAO;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class Application extends Controller {
	
	private static final GenericDAO dao = new GenericDAO();
	
	private static List<Estilo> listaDeEstilos = dao.findAllByClass(Estilo.class);
	private static List<Instrumento> listaDeInstrumentos = dao.findAllByClass(Instrumento.class);
	

	@Transactional
    public static Result index() {
		
		List<Anuncio> listaDeAnuncios = dao.findAllByClass(Anuncio.class);
        return ok(views.html.index.render(listaDeAnuncios, listaDeEstilos, listaDeInstrumentos));
    }
    
    @Transactional
    public static Result cadastrarAnuncio(){
    	
    	Anuncio anuncio = new Anuncio();
    	
    	DynamicForm requestData = Form.form().bindFromRequest();
	    
    	anuncio.setTitulo(requestData.get("titulo"));
    	System.out.println(anuncio.getTitulo());
    	anuncio.setDescricao(requestData.get("descricao"));
    	anuncio.setCidade(requestData.get("cidade"));
    	anuncio.setBairro(requestData.get("bairro"));
    	anuncio.setEmail(requestData.get("email"));
    	anuncio.setFacebook(requestData.get("facebook"));
    	anuncio.setInstrumentos(getSelecionadosInstrumentos());
    	anuncio.setEstilos(getSelecionadosEstilos());
    	
    	
    	dao.persist(anuncio);
    	dao.merge(anuncio);
    	dao.flush();
    	
    	
    	
    	return redirect(routes.Application.index());
    	
    }
    
	@Transactional
	private static List<Instrumento> getSelecionadosInstrumentos() {
		Map<String, String[]> map = request().body().asFormUrlEncoded();

		String[] checkedInstrumentos = map.get("checkInstrumento");
		List<Instrumento> listInstrumentos = new ArrayList<>();

		if (checkedInstrumentos != null) {
			List<String> listaIdInstrumentos = Arrays
					.asList(checkedInstrumentos);
			for (String id : listaIdInstrumentos) {
				Long idInstrumento = Long.parseLong(id);
				Instrumento instrumento = dao.findByEntityId(Instrumento.class,
						idInstrumento);
				if (instrumento != null) {
					listInstrumentos.add(instrumento);
				}
			}
		}

		return listInstrumentos;
	}
	
	@Transactional
	private static List<Estilo> getSelecionadosEstilos() {
		Map<String, String[]> map = request().body().asFormUrlEncoded();

		String[] checkedEstilo = map.get("checkEstilo");
		List<Estilo> listEstilos = new ArrayList<>();

		if (checkedEstilo != null) {
			List<String> listaIdEstilos = Arrays
					.asList(checkedEstilo);
			for (String id : listaIdEstilos) {
				Long idEstilo = Long.parseLong(id);
				Estilo estilo = dao.findByEntityId(Estilo.class,
						idEstilo);
				if (estilo != null) {
					listEstilos.add(estilo);
				}
			}
		}

		return listEstilos;
	}
	
	
	
}
