package fx;

public class CarModel {
	private String make;
	private String model;
	private String color;
	private int price;
		
	public CarModel(String make, String model, String color, int price) {

		this.make = make;
		this.model = model;
		this.color = color;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price > 0) {
			this.price = price;
		}else {
			this.price = 500;
		}
		
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

	@Override
	public String toString() {
		return this.getMake() + " " + this.getModel();
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
	
	public String priceMultiplier() {
		int increasedPrice = this.price * 2;
		return String.valueOf(increasedPrice);
	}
	
	
}