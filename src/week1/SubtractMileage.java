package week1;

public class SubtractMileage implements Mileage {

	@Override
	public int changeMileage(int originalMileage, int newMileage) {
		return originalMileage - newMileage;
	}

}
