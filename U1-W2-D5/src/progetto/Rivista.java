package progetto;

@SuppressWarnings("serial")
public class Rivista extends ElementoDellaBiblioteca {

	private Periodicita periodicita;
	
	public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}
	
	public Periodicita getPeriodicita() {
		return periodicita;
	}
	
    @Override
    public String toString() {
        return "Rivista{" +
                "ISBN='" + codiceISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", periodicita=" + periodicita +
                '}';
    }
	
}
