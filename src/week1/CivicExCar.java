package week1;

public class CivicExCar extends CivicCar {	
	private boolean selfCharging = false;
	
	public CivicExCar(int numberOfDoors, String fuelType, int milesPerFuelType, String model, String color, boolean selfCharging) {
		super(numberOfDoors, fuelType,milesPerFuelType, model, color);
		this.selfCharging = selfCharging;
	}
	
	public void displayIfSelfCharging() {
		System.out.println( "SelfCharging: " + this.isSelfCharging() );
	}

	public boolean isSelfCharging() {
		return selfCharging;
	}

	public void setSelfCharging(boolean selfCharging) {
		this.selfCharging = selfCharging;
	}
}