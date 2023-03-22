package homework;
import java.io.*;

public class Es1_MyThread extends Thread{
	
	int n;
	String simbolo;
	
	public Es1_MyThread(String simbolo, int n) {
		this.simbolo = simbolo;
		this.n = n;
	}
	
	public void run() {
		System.out.println("Sono MyThread: ");
		for(int i = 0; i < n; i++) {
			System.out.println(i + simbolo);
			try {
				sleep(1000);
			} catch (InterruptedException e) {}
		}
		System.out.println("MyThread finito!!!");
	}
}
