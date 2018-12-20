package finaltest;



public class Run {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new ThreadExample("Jason Durant", 10));  
		Thread thread2 = new Thread(new ThreadExample("winter!", 100));
		
		thread1.start();
		thread2.start();
	}

}
