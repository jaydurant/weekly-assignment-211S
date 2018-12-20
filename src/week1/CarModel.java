package week1;

import java.util.List;

public class CarModel implements Comparable<CarModel> {
	private int numberOfWheels;
	private int numberOfDoors;
	private String fuelType;
	private int milesPerFuelType;
	private String make;
	private String model;
	private String color;
	
	// M2 HOMEWORK ENUM USE
	private SeatType seatType = SeatType.Nylon;
	
	public CarModel(int numberOfWheels, int numberOfDoors, String fuelType, int milesPerFuelType, String make, String model, String color) {
		this.numberOfWheels = numberOfWheels;
		this.numberOfDoors = numberOfDoors;
		this.fuelType = fuelType;
		this.milesPerFuelType = milesPerFuelType;
		this.make = make;
		this.model = model;
		this.color = color;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(Integer numberOfWheels) {
		this.numberOfWheels = numberOfWheels >= 4 ?  numberOfWheels : 4;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(Integer numberOfDoors) {
		this.numberOfDoors = numberOfDoors <= 4 && numberOfDoors >= 2  ? numberOfDoors : 2 ;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getMilesPerFuelType() {
		return milesPerFuelType;
	}

	public void setMilesPerFuelType(Integer milesPerFuelType) {
		this.milesPerFuelType = milesPerFuelType >= 10 ? milesPerFuelType : 10 ;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	
	public static void readCars(List<CarModel> list) {
		for(CarModel car: list) {
			System.out.println(car);
		}
	}
	

	@Override
	public String toString() {
		return this.getMake() + " " + this.getModel() + " " + this.getMilesPerFuelType() + " per " + this.getFuelType() + "SeatType: " + this.getSeatType().toString();
	}
	
	@Override
	public boolean equals(Object car) {
		if(car instanceof CarModel){
			CarModel carModel = (CarModel) car;
			
			return carModel.getModel().equals(this.getModel()) && carModel.getMake().equals(this.getMake());
		}else {
			return false;
		}
	}
	
	public int compareTo(CarModel carModel){
		if(this.getMilesPerFuelType() < carModel.getMilesPerFuelType()) {
			return -1;
		}
		else if (this.getMilesPerFuelType() == carModel.getMilesPerFuelType()) {
			return 0;
		}
		
		else {
			return 1;
		}
	}
	
	
}
