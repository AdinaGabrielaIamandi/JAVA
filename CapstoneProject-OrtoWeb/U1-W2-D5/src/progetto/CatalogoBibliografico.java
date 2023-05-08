package progetto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatalogoBibliografico {
	
	private List<ElementoDellaBiblioteca> elementiCatalogo;
	
	public CatalogoBibliografico(ElementoDellaBiblioteca elemento) {
		elementiCatalogo = new ArrayList<>();
	}
	
	public void aggiungiElemento(ElementoDellaBiblioteca elemento) {
		elementiCatalogo.add(elemento);
	}
	
	public void rimuoviElemento(String codiceISBN) {
		elementiCatalogo.removeIf(elemento -> elemento.getCodiceISBN().equals(codiceISBN));
	}
	
	public Optional<ElementoDellaBiblioteca> ricercaPerCodice(String codiceISBN) {
		return elementiCatalogo.stream().filter(elemento -> elemento.getCodiceISBN().equals(codiceISBN)).findFirst();
	}
	
	public List<Libro> ricercaPerAutore(String autore) {
		return elementiCatalogo.stream().filter(elemento -> elemento instanceof Libro).map(elemento -> (Libro) elemento).filter(libro -> libro.getAutore().equals(autore)).toList();
	}
	
	public List<ElementoDellaBiblioteca> ricercaPerAnno(int annoPubblicazione) {
		return elementiCatalogo.stream().filter(elemento -> elemento.getAnnoPubblicazione() == annoPubblicazione).toList();
	}
	
	public void salvaSuDisco(File file) throws IOException {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
			outputStream.writeObject(elementiCatalogo);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void caricaDaDisco(File file) throws IOException, ClassNotFoundException {
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
			elementiCatalogo = (List<ElementoDellaBiblioteca>) inputStream.readObject();
		}
	}
}
