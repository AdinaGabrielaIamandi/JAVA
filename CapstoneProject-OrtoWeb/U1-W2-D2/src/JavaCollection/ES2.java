package JavaCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ES2 {
	
	public static List<Integer> generaListaCasuale(int N) {
		
		List<Integer> lista = new ArrayList<Integer>();
		Random rand = new Random();
		
		for (int i = 0; i < N; i++) {
			lista.add(rand.nextInt(101));
		}
		
		Collections.sort(lista);
		return lista;
	}
	
	public static List<Integer> inverteLista(List<Integer> lista) {
		
		List<Integer> listaInvertita = new ArrayList<Integer>(lista);
		Collections.reverse(listaInvertita);
		lista.addAll(listaInvertita);
		return lista;
	}
	
	public static void stampaElementi(List<Integer> lista, boolean pari) {
		
		for (int i = 0; i < lista.size(); i++) {
			if ((pari && i % 2 == 0) || (!pari && i % 2 != 0)) {
				System.out.println(lista.get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		
		List<Integer> listaCasuale = generaListaCasuale(10);
		System.out.println("Lista casuale: " + listaCasuale);
		
		List<Integer> listaInvertita = inverteLista(listaCasuale);
		System.out.println("Lista invertita: " + listaInvertita);
		
		System.out.println("Elementi in posizione pari:");
		stampaElementi(listaCasuale, true);
		
		System.out.println("Elementi in posizione dispari:");
		stampaElementi(listaCasuale, false);
	}
}
