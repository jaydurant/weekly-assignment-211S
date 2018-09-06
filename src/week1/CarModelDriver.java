package week1;

import java.util.ArrayList;
import java.util.Collections;

public class CarModelDriver {

	public static void main(String[] args) {
		ArrayList<CarModel> carModelArray = new ArrayList<>();
		CarModel car1 = new CivicExCar( 2,  "electricity",  250,  "CivicEx",  "blue",  true);
		carModelArray.add(car1);
		
		CarModel car2 = new CrvCar( 4,  "gas", 60, "grey", "suv");
		carModelArray.add(car2);
		
		CarModel car3 = new CivicCar(4, "gas", 80, "red");
		
		// M2 HOMEWORK ENUM USE
		car3.setSeatType(SeatType.Leather);
		carModelArray.add(car3);
		
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
