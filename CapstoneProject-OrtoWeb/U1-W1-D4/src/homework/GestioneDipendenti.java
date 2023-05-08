package homework;

import homework.Dipendente.Dipartimento;
import homework.Dipendente.Livello;

public class GestioneDipendenti {
	public static void main(String[] args) {
		Dipendente operaio1 = new Dipendente("op1", Dipartimento.PRODUZIONE);
		Dipendente operaio2 = new Dipendente("op2", Dipartimento.PRODUZIONE);
		Dipendente impiegato1 = new Dipendente("im1", Dipartimento.AMMINISTRAZIONE, 1500, 1.5, Livello.IMPIEGATO);
		Dipendente dirigente1 = new Dipendente("dr1", Dipartimento.VENDITE, 2000, 3, Livello.DIRIGENTE);
		
		operaio1.promuovi();
		impiegato1.promuovi();
		
		operaio1.stampaDatiDipendente();
		operaio2.stampaDatiDipendente();
		impiegato1.stampaDatiDipendente();
		dirigente1.stampaDatiDipendente();
		
		double stipendio1 = Dipendente.calcolaPaga(operaio1, 5);
		double stipendio2 = Dipendente.calcolaPaga(operaio2, 5);
		double stipendio3 = Dipendente.calcolaPaga(impiegato1, 5);
		double stipendio4 = Dipendente.calcolaPaga(dirigente1, 5);
		
		double sommaStipendi = stipendio1 + stipendio2 + stipendio3 + stipendio4;
		
		System.out.println("La somma degli stipendi dei dipendenti, comprensivi di 5 ore di straordinari, è: " + sommaStipendi);
		
	}
}
