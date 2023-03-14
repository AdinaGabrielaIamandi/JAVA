package homework;

public class SIM {
	long numero;
	int credito= 0;
	long chiamate[] = new long [5];
	
	
	public SIM(int a) {
		this.numero= a;
	}
	
	public long[] chiama(int numChiamato, int durataChiamata) {
		long[] chiamata = {numChiamato, durataChiamata};
		this.credito = this.credito -1;for(int i=0 ; i<chiamate.lenght ; i++) {
		chiamate[i] = chiamata
	}
		return chiamata;
	}
	
	public int riarica(int euro) {
		return credito = euro;
	}
	
	
	
	public static void stampaInfoSim(SIM s) {
		System.out.println("Il tuo numero" + s.numero);
		System.out.println("Le tue ultime 5 chiamate");
		for (int i=0 ; i<5 ; i++) {
			System.out.println("Numero: " + s.chiamate.);
		}
	}

}
