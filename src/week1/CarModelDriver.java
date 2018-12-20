package week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarModelDriver {

	public static void main(String[] args) {
		List<CivicExCar> carModelArray = new ArrayList<>();
		CivicExCar car1 = new CivicExCar( 2,  "electricity",  250,  "CivicEx",  "blue",  true, new AddMileage());
		carModelArray.add(car1);
		

		
		//M3 USING STRATEGY
		CivicExCar car7 = new CivicExCar( 2,  "electricity",  250,  "CivicEx",  "blue",  true, new AddMileage());
		car7.adjustMileage(50);
		System.out.println(car7.getMilesPerFuelType());
				 
		
		// M2 HOMEWORK Sort
		Collections.sort(carModelArray);
		
		
		
		CarModel.readCars(carModelArray);
	}

}
