package homework;

import java.util.Random;

public class Es2_Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		// Genera l'array di 3000 valori casuali
		int[] array = new int[3000];
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
		
		 // Crea tre thread e assegna ad ognuno una partizione dell'array
		Es2_MyThread[] t = new Es2_MyThread[3];
		for (int i = 0; i < t.length; i++) {
			t[i] = new Es2_MyThread(array, i * 1000, (i+1) * 1000);
			t[i].start();
		}
		
		 // Sincronizza il thread main sulla terminazione dei thread figli
		for (Es2_MyThread thread:t) {
			thread.join();
		}
		
		 // Somma i risultati parziali e li stampa su console
		int somma = 0;
		for (Es2_MyThread thread:t) {
			somma += thread.getSomma();
		}
		
		System.out.println("La somma totale è: " + somma);
			
	}
}
