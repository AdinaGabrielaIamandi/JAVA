package homework;

public class Dipendente {
	private static double stipendioBase = 1000;
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	public enum Livello {
		OPERAIO, IMPIEGATO, QUADRO, DIRIGENTE
	}
	
	public enum Dipartimento {
		PRODUZIONE, AMMINISTRAZIONE, VENDITE
	}
	
	public Dipendente(String matricola, Dipartimento dipartimento) {
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 1.2;
		this.livello = Livello.OPERAIO;
	}
	
	public Dipendente(String matricola, Dipartimento dipartimento, double stipendio, double importoOrarioStraordinario, Livello livello) {
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public double getStipendio() {
		return stipendio;
	}
	
	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}
	
	public Livello getLivello() {
		return livello;
	}
	
	public Dipartimento getDipartimento() {
		return dipartimento;
	}
	
	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}
	
	public void setDipartimento (Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	public void stampaDatiDipendente() {
		System.out.println("Matricola: " + matricola);
		System.out.println("Stipendio: " + stipendio);
		System.out.println("Livello: " + livello);
		System.out.println("Dipartimento: " + dipartimento);
	}
	
	public Livello promuovi() {
		switch (livello) {
		case OPERAIO: 
			livello = Livello.IMPIEGATO;
			stipendio = stipendioBase * 1.2;
			break;
		case IMPIEGATO:
			livello = Livello.QUADRO;
			stipendio = stipendioBase*1.5;
			break;
		case QUADRO:
			livello = Livello.DIRIGENTE;
			stipendio = stipendioBase * 2;
			break;
		case DIRIGENTE:
			System.out.println("Non è possibile promuovere ulteriormente un dipendente di livello dirigente");
		}
		return livello;
	}
	
	public static double calcolaPaga(Dipendente dipendente) {
		return dipendente.getStipendio();
	}
	
	public static double calcolaPaga(Dipendente dipendente, int oreStraordinario) {
		double stipendio = dipendente.getStipendio();
		double importoOriarioStraordinario = dipendente.getImportoOrarioStraordinario();
		double stipendioStraordinario = oreStraordinario * importoOriarioStraordinario;
		double stipendioTotale = stipendio + stipendioStraordinario;
		return stipendioTotale;
	}
	
}
