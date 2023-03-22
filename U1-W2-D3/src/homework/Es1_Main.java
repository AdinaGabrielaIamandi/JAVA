package homework;

public class Es1_Main {
	public static void main(String[] args) {
		
		Es1_MyThread t1, t2;
		
		t1= new Es1_MyThread("*", 10);
		t2 = new Es1_MyThread("#", 10);
		
		t1.start();
		t2.start();
	}
}
