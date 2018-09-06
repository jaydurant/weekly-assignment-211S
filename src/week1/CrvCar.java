package week1;

public class CrvCar extends CarModel {
	private static String MAKE = "Honda";
	private static String MODEL = "CRV";
	private static Integer WHEELS = 4;
	
	private String crvType;
	
	public CrvCar(Integer numberOfDoors, String fuelType, Integer milesPerFuelType, String color, String crvType) {
		super(WHEELS, numberOfDoors, fuelType, milesPerFuelType, MAKE, MODEL, color);
		this.crvType = crvType;
	}

	public String getCrvType() {
		return crvType;
	}

	public void setCrvType(String crvType) {
		this.crvType = crvType;
	}
	
	
	public void displayCrvType() {
		System.out.println("The " + this.getMake() + " " + this.getModel() + " " + this.getCrvType() +   " was produced");
	}

}
