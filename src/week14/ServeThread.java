package week14;
import java.util.concurrent.BlockingQueue;

public class ServeThread implements Runnable {
	private BlockingQueue<Food> foodQueue;
	private int numOfFood;

	public ServeThread(BlockingQueue<Food> foodQueue, int numOfFood) {
		this.foodQueue = foodQueue;
		this.numOfFood = numOfFood;
	}

	@Override
	public void run() {
		for (int i = 0; i < numOfFood ; i++) {
			try {
				System.out.println("Server Ready");
				Food food = foodQueue.take();
				System.out.println("Server Starting:" + food.toString());
				Thread.sleep(food.getServeTime() * 1000);
				System.out.println("Server Ending:" + food.toString());
			}
			catch (InterruptedException ex) { }
		}
		
	}

}
