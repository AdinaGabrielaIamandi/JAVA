import java.util.Scanner;

public class PlayerMultimediale {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ElementoMultimediale[] elementi = new ElementoMultimediale[5];
		
		for (int i = 0; i < elementi.length; i++) {
			System.out.println("Inserisci il tipo di elemento multimediale (1 = immagine, 2 = registrazione audio, 3 = video):");
			int tipo = input.nextInt();
			input.nextLine();
			
			System.out.println("Inserisci il titolo");
			String titolo = input.nextLine();
			
			switch (tipo) {
			case 1:
				System.out.println("Inserisci la luminosità:");
				int luminosita = input.nextInt();
				input.nextLine();
				elementi[i] = new Immagine(titolo, luminosita);
				break;
			case 2:
				System.out.println("Inserisci la durata:");
			     int durata1 = input.nextInt();
			     input.nextLine(); 
			     System.out.println("Inserisci il volume:");
			     int volume = input.nextInt();
			     input.nextLine();
			     elementi[i] = new RegistrazioneAudio(titolo, durata1, volume);
			     break;
		    case 3:
		        System.out.println("Inserisci la durata:");
		        int durata2 = input.nextInt();
		        input.nextLine();
		        System.out.println("Inserisci il volume:");
		        int volume2 = input.nextInt();
		        input.nextLine();
		        System.out.println("Inserisci la luminosità:");
		        int luminosita2 = input.nextInt();
		        input.nextLine();
		        elementi[i] = new Video(titolo, durata2, volume2, luminosita2);
		        break;
		      default:
		        System.out.println("Tipo non riconosciuto!");
			}
			}
		
		int scelta = -1;
		while (scelta != 0) {
		  System.out.println("Quale elemento multimediale vuoi eseguire? (0 per uscire)");
		  scelta = input.nextInt();

		  if (scelta > 0 && scelta <= elementi.length) {
		    ElementoMultimediale elemento = elementi[scelta-1];
		    elemento.esegui();
		  } else if (scelta != 0) {
		    System.out.println("Scelta non valida!");
		  }
		}
	}
}
