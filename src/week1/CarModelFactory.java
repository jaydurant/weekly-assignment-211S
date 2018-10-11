package week1;

public class CarModelFactory {

	public static CarModel newCarModel(String type, int door, String fuelType, int milesPerFuelType, String color) {
		CarModel carModel;
		if (type.equals("civic")) {
			carModel = new CivicCar(door, fuelType,milesPerFuelType, color);
		}
		else if(type.equals("crv")) {
			carModel = new CrvCar(door, fuelType,milesPerFuelType, color);
		}else {
			throw new IllegalArgumentException();
		}
		
		return carModel;
	}

}
