package JavaCollection;

import java.util.HashMap;
import java.util.Map;

public class RubricaTelefonica {
	
	private Map<String, String> contatti;
	
	public RubricaTelefonica() {
		this.contatti = new HashMap<>();
	}
	
	public void inserisciContatto(String nome, String numero) {
		contatti.put(nome, numero);
	}
	
	public void cancellaContatto(String nome) {
		contatti.remove(nome);
	}
	 
	public String ricercaNome(String telefono) {
		for (Map.Entry<String, String> entry : contatti.entrySet()) {
			if (entry.getValue().equals(telefono)) {
				return entry.getKey();			}
		}
		return null;
	}
	
	public String ricercaTelefono(String nome) {
		return contatti.get(nome);
	}
	
	public void stampaRubrica() {
		System.out.println("Rubrica telefonica:");
		for (Map.Entry<String, String> entry : contatti.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		RubricaTelefonica rubrica = new RubricaTelefonica();
		rubrica.inserisciContatto("Mario", "123456789");
		rubrica.inserisciContatto("Luigi", "987654321");
		rubrica.stampaRubrica();
		rubrica.cancellaContatto("Mario Rossi");
		rubrica.inserisciContatto("Rossi", "555666777");
		System.out.println(rubrica.ricercaNome("987654321"));
		System.out.println(rubrica.ricercaTelefono("Rossi"));
	}

}
