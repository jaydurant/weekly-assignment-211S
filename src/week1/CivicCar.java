package week1;

public class CivicCar extends CarModel {
	// M2 HOMEWORK STATIC
	private static String MAKE = "Honda";
	private static String MODEL = "Civic Basic";
	private static int WHEELS = 4;
	
	public CivicCar(int numberOfDoors, String fuelType, int milesPerFuelType, String color) {
		super(WHEELS, numberOfDoors, fuelType,milesPerFuelType, MAKE, MODEL, color);
	}
	
	public CivicCar(int numberOfDoors, String fuelType, int milesPerFuelType, String model, String color) {
		super(WHEELS, numberOfDoors, fuelType,milesPerFuelType, MAKE, model, color);
	}

	public void displayCivicModel() {
		System.out.println("The "+ this.getMake() + " " + this.getModel() + " was produced.");
	}
}

