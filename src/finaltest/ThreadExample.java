package finaltest;

public class ThreadExample implements Runnable {
	private String word;
	private int numTimes = 5;
	
	public ThreadExample(String word, int numTimes) {
		this.word = word;
		this.numTimes = numTimes;
	}
	
	@Override
	public void run() {
		for (int i= 0 ; i < numTimes; i++) {
			System.out.println(this.word);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
