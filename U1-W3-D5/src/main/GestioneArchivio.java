package main;

import Dao.Archivio;
import JPA_util.JpaUtil;
import model.Elemento_Catalogo;
import model.Libro;
import model.Periodicità;
import model.Rivista;

public class GestioneArchivio {

	public static void main(String[] args) {
		
		/*Rivista r = new Rivista();
		r.setPeriodicità(Periodicità.SETTIMANALE);
		r.setAnnoPubblicazione("25/02/2023");
		r.setNumPagine(20);
		r.setTitolo("Cucina di Pasqua");
		
		/*Libro l = new Libro();
		l.setAnnoPubblicazione("21/07/1999");
		l.setAutore("Federico P.");
		l.setGenere("horror");
		l.setNumPagine(989);
		l.setTitolo("Suoni sotto il letto");
		Archivio.aggiungiLibro(l);*/
		
		//Archivio.aggiungiRivista(r);
		
		Elemento_Catalogo el = Archivio.trovaElementoISBN(1L);
		//System.out.println(el);
		
		Archivio.rimuoviElemento(el);

	}

}
