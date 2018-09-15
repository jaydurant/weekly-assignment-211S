package week1;

import java.util.Comparator;

public class CivicCar extends CarModel{
	// M2 HOMEWORK STATIC
	private static final String MAKE = "Honda";
	private static final String MODEL = "Civic Basic";
	private static final int WHEELS = 4;
	
	public static Comparator<CivicCar> Mileage_Comparator =  new CivicMileageComparator();
	
	public CivicCar(int numberOfDoors, String fuelType, int milesPerFuelType, String color) {
		super(WHEELS, numberOfDoors, fuelType,milesPerFuelType, MAKE, MODEL, color);
	}
	
	public CivicCar(int numberOfDoors, String fuelType, int milesPerFuelType, String model, String color) {
		super(WHEELS, numberOfDoors, fuelType,milesPerFuelType, MAKE, model, color);
	}

	public void displayCivicModel() {
		System.out.println("The "+ this.getMake() + " " + this.getModel() + " was produced.");
	}
	
	private static class CivicMileageComparator implements Comparator<CivicCar>{
		@Override
		public int compare(CivicCar car1, CivicCar car2) {
			if (car1.getMilesPerFuelType() < car2.getMilesPerFuelType()){
				return -1;
			}
			if (car1.getMilesPerFuelType() > car2.getMilesPerFuelType()){
				return 1;
			}else {
				return 0;
			}
		}
	}
	
	
}

