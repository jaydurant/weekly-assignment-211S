package midterm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Animal implements Comparable<Animal> {

	   private String name;
	   private int age;
	   private Feeder feeder;
	   private AnimalStatus animalStatus;

	   public Animal(String name, int age, Feeder feeder) {
	      this.name = name;
	      this.feeder = feeder;
	      this.age = age;
	   }
	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	     this.name = name;
	  }
	 
	   public int getAge() {
	     return age;
	   }

	  public void setAge(int age) {
	     if (age >= 0) {
	       this.age = age;
	     }
	  }

	  public Feeder getFeeder() {
	     return feeder;
	  }
	 
	  public void setFeeder(Feeder feeder) {
	     this.feeder = feeder;
	  }
	  
	  public AnimalStatus getStatus() {
		  return this.animalStatus;
	  }

	  @Override
	  public String toString() {
	      return name + " (Age: " + age + ")";
	  }

	  @Override
	  public boolean equals(Object animal){
	    if (animal instanceof Animal){
	        Animal animalObject = (Animal)animal;
	        return animalObject.getName().equals(this.getName()) && this.getAge() == animalObject.getAge();
	    } else{
	        return false;
	    }
	  }
	  
	  @Override
	  public int compareTo(Animal animal){
		 int nameResult = this.getName().compareToIgnoreCase(animal.getName());
		 
		 if (nameResult == 0){
			 return Integer.compare(this.getAge(),animal.getAge());
		 }else {
			 return nameResult;
		 }
	  }
	  
	  public void feedAnimal() {
		  this.feeder.feed();
	  }
	  
	  public static void printAnimalsToFile(List<Animal> animals, String fileName){
		  PrintWriter fileOutput = null;
		  try {
			  BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName));
			  fileOutput = new PrintWriter(buffer);
			  
			  
			  ArrayList<Animal> newList= (ArrayList<Animal>) animals;
			  
			  for(Animal animal : newList) {
				  fileOutput.println(animal.getName());
			  }
			  
		  } catch(IOException ex) {
			  ex.printStackTrace();
		  } finally{
			  if(fileOutput != null) {
				  fileOutput.close();
			  }
		  }
	 }
	

	public static int countAdoptableAnimals(List<Animal> animals) {
	    int count = 0;
	    for (int i = 0; i < animals.size(); i++) {
	    	AnimalStatus animalStatus = animals.get(i).getStatus();
	    	if (animalStatus.getAdoptionStatus()) {
	    		count++;
	    	}
	    }
	    
	    return count;
	}
	
	public static void birthdayUpdates(Map<String, Animal> animalMap, List<String> animalNameList) {

		for (int i = 0; i < animalNameList.size(); i++) {
			String animalName = animalNameList.get(i);
			
			if (animalMap.containsKey(animalName)) {
				Animal currAnimal = animalMap.get(animalName);
				int newAge = currAnimal.getAge() + 1;
				currAnimal.setAge(newAge);
			}
		}
	}
}
