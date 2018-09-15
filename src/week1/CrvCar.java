package week1;

public class CrvCar extends CarModel {
	private static final String MAKE = "Honda";
	private static final String MODEL = "CRV";
	private static int wheels = 4;
	private String crvType = "suv";
	
		
	public CrvCar(int numberOfDoors, String fuelType, int milesPerFuelType, String color, String crvType) {
		super(wheels, numberOfDoors, fuelType, milesPerFuelType, MAKE, MODEL, color);
		this.crvType = crvType;
	}
	public CrvCar(int numberOfDoors, String fuelType, int milesPerFuelType, String color) {
		super(wheels, numberOfDoors, fuelType, milesPerFuelType, MAKE, MODEL, color);	
	}
	
	public String getCrvType() {
		return crvType;
	}

	public void setCrvType(String crvType) {
		this.crvType = crvType;
	}
	
	
	public void displayCrvType() {
		System.out.println("The " + this.getMake() + " " + MODEL + " " + this.getCrvType() +   " was produced");
	}

	public static void setWheels(int newWheels) {
		wheels = newWheels;
	}
	
	public static class CrvCarBuilder{
		private int nestedNumberOfDoors;
		private String nestedFuelType;
		private int nestedMilesPerFuelType;
		private String nestedColor;
		private String nestedCrvType;
		
		
		public CrvCarBuilder(final int newNumberOfDoors, final String  newFuelType, final int newMilesPerFuelType) {
			this.nestedNumberOfDoors = newNumberOfDoors;
			this.nestedFuelType = newFuelType;
			this.nestedMilesPerFuelType = newMilesPerFuelType;
		}
		
		public CrvCarBuilder numberOfDoors(int newNumberOfDoors) {
			this.nestedNumberOfDoors = newNumberOfDoors;
			return this;
		}
		
		public CrvCarBuilder fuelType(String newFuelType) {
			this.nestedFuelType = newFuelType;
			return this;
		}
		
		public CrvCarBuilder milesPerFuelType(int newMilesPerFuelType) {
			this.nestedMilesPerFuelType = newMilesPerFuelType;
			return this;
		}
		
		public CrvCarBuilder color(String newColor) {
			this.nestedColor = newColor;
			return this;
		}
		
		public CrvCarBuilder crvType(String newCrvType) {
			this.nestedCrvType = newCrvType;
			return this;
		}
		
		public CrvCar createCrvCar() {
			return new CrvCar(nestedNumberOfDoors, nestedFuelType, nestedMilesPerFuelType, nestedColor, nestedCrvType);
		}
		
	}
}
