package week14;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class CookThread implements Runnable{
	private BlockingQueue<Food> foodQueue;
	private List<Food> foodList;

	public CookThread(BlockingQueue<Food> foodQueue, List<Food> foodList) {
		this.foodList = foodList;
		this.foodQueue = foodQueue;
	}

	@Override
	public void run() {
		for(Food food : this.foodList) {
			try {
			System.out.println("Cook Ready");
			System.out.println("Cook Starting:" + food.toString());
			Thread.sleep(food.getCookTime() * 1000);
			System.out.println("Cook Ending" + food.toString());
			foodQueue.put(food);
			}catch(InterruptedException ex) { }
			
		}
	}

}
