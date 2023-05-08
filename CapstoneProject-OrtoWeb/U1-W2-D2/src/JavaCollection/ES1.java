package JavaCollection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ES1 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci il numero di parole: ");
		int N = s.nextInt();
		
		Set<String> parole = new HashSet<>();
		Set<String> duplicate = new HashSet<>();
		
		System.out.println("Inserisci le parole: ");
		
		for (int i = 0; i < N; i++) {
			String parola = s.next();
			if (!parole.add(parola)) {
				duplicate.add(parola);
			}
		}
		
		System.out.println("Parole duplicate: ");
		for (String parola : duplicate) {
			System.out.println(parola);
		}
		
		System.out.println("Numero di parole distinte: " + parole.size());
		
		System.out.println("Elenco parole distinte: ");
		
		for (String parola : parole) {
			System.out.println(parola);
		}
	}
}
