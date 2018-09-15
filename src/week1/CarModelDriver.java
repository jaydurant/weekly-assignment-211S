package week1;

import java.util.ArrayList;
import java.util.Collections;

public class CarModelDriver {

	public static void main(String[] args) {
		ArrayList<CarModel> carModelArray = new ArrayList<>();
		CarModel car1 = new CivicExCar( 2,  "electricity",  250,  "CivicEx",  "blue",  true, new AddMileage());
		carModelArray.add(car1);
		
		CarModel car2 = new CrvCar( 4,  "gas", 60, "grey", "suv");
		carModelArray.add(car2);
		
		CarModel car3 = new CivicCar(4, "gas", 80, "red");
		
		// M2 HOMEWORK ENUM USE
		car3.setSeatType(SeatType.Leather);
		carModelArray.add(car3);
		
		// M3 USING BUILDER
		CarModel car4= new CrvCar.CrvCarBuilder(2,"gas", 350)
				.color("green")
				.crvType("excursion")
				.createCrvCar();
		carModelArray.add(car4);
		
		// M3 USING FACTORY
		CarModel car5 = CarModelFactory.newCarModel("civic", 4, "hybrid", 255, "turquoise");
		CarModel car6 = CarModelFactory.newCarModel("crv", 6, "hybrid", 275, "black");
		carModelArray.add(car5);
		carModelArray.add(car6);
		
		//M3 USING STRATEGY
		CivicExCar car7 = new CivicExCar( 2,  "electricity",  250,  "CivicEx",  "blue",  true, new AddMileage());
		car7.adjustMileage(50);
		System.out.println(car7.getMilesPerFuelType());
				 
		
		// M2 HOMEWORK Sort
		Collections.sort(carModelArray);
		
		
		
		for (CarModel car : carModelArray) {
			System.out.println(car.toString());
			
			if (car instanceof CivicExCar) {
				CivicExCar civicexcar = (CivicExCar)car;
				civicexcar.displayIfSelfCharging();
			}
			else if(car instanceof CrvCar) {
				CrvCar crvcar = (CrvCar)car;
				crvcar.displayCrvType();
			}else{
				CivicCar civiccar = (CivicCar)car;
				civiccar.displayCivicModel();
			}
		}
	}

}
