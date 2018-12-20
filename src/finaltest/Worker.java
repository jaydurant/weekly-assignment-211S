package finaltest;


public final class Worker {
	private final String name;
	private final double salary;
	private final Manager boss;
	
	public Worker(String name, double salary, Manager boss) {
		this.name = name;
		this.salary = salary;
		this.boss = boss;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Manager getBoss() {
		return new Manager(this.boss.getName(), this.boss.getSalary());
	}

}
