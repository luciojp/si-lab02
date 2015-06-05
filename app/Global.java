import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Anuncio;
import models.Estilo;
import models.Instrumento;
import models.dao.GenericDAO;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;

public class Global extends GlobalSettings {
	private static GenericDAO dao = new GenericDAO();

	public void onStart(Application app) {
		Logger.info("Aplicação inicializada...");

		JPA.withTransaction(new play.libs.F.Callback0() {
			@SuppressWarnings("resource")
			@Override
			public void invoke() throws Throwable {
				/*
				 * Cadastrar estilos no Bando de Dados
				 */
				Scanner in;
				in = new Scanner(new FileReader(new File("app/estilos.dat")
						.getCanonicalPath()));
				while (in.hasNextLine()) {
					String nomeEstilo = in.nextLine();
					dao.persist(new Estilo(nomeEstilo));
				}

				dao.flush();

				/*
				 * Cadastrar instrumentos no Bandode Dados
				 */
				in = new Scanner(new FileReader(
						new File("app/instrumentos.dat").getCanonicalPath()));
				while (in.hasNextLine()) {
					String nomeInstrumentos = in.nextLine();
					dao.persist(new Instrumento(nomeInstrumentos));
				}

				dao.flush();

				
			}
		});
	}

	public void onStop(Application app) {
		Logger.info("Aplicação desligada...");
	}
}
