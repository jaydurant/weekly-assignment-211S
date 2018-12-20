package midterm;

import java.util.Comparator;

import week1.CivicCar;

public static class ReverseAgeComparator implements Comparator<Animal> {

	
	@Override
	public int compare(Animal animal1, Animal animal2) {
		int returnAgeCompare= Integer.compare(animal1.getAge(), animal2.getAge());
		
		if (returnAgeCompare > 0 ) {
			return -1;
		}
		else if(returnAgeCompare < 0) {
			return 1;
		}else {
			return returnAgeCompare;
		}
	}

}
