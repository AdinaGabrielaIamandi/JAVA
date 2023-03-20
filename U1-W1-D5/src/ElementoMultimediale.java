
public class ElementoMultimediale {
	public String titolo;
	public int durata;
	
	public ElementoMultimediale(String titolo, int durata) {
		this.titolo = titolo;
		this.durata = durata;
	}

	public boolean eRipoducibile() {
		return durata > 0;
	}
	
	public void esegui() {
		if (this instanceof Immagine) {
			((Immagine) this).show();
		} else if (eRipoducibile()) {
			((Riproducibile) this).play();
		}
	}
}
