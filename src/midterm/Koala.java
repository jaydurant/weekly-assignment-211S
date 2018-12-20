package midterm;

public class Koala extends Animal {
	
	public Koala(String name, int age) {
		super(name, age, new VegetableFeeder() );
	}
}
