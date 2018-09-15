package week1;

public class CivicExCar extends CivicCar {	
	private boolean selfCharging = false;
	private Mileage mileage;
	
	public CivicExCar(int numberOfDoors, String fuelType, int milesPerFuelType, String model, String color, boolean selfCharging, Mileage mileage) {
		super(numberOfDoors, fuelType,milesPerFuelType, model, color);
		this.selfCharging = selfCharging;
		this.mileage = mileage;
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
	
	public void adjustMileage(int newMileage) {
		int changedMilesPerFuelType = mileage.changeMileage(this.getMilesPerFuelType(), newMileage);
		this.setMilesPerFuelType(changedMilesPerFuelType);
	}
}