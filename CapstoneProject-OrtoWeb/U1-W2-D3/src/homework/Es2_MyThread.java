package homework;

public class Es2_MyThread extends Thread{
	
	private int[] array;
	private int startIndex;
	private int endIndex;
	private int s;
	
	public Es2_MyThread(int[] array, int startIndex, int endIndex) {
		this.array = array;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.s = 0;
	}
	
	public void run() {
		for (int i = startIndex; i < endIndex; i++) {
			s += array[i];
		}
	}
	
	public int getSomma() {
		return s;
	}
}
