package storeinventory;

public class ProductFactory {
	
	public static Product  newProduct(String name, int sku, float cost, String type) {
		Product= p
		if (type.equals("electronic")) {
			p = new ElectronicProduct(name, sku, cost);
		}
		else if(type.equals("craft")) {
			p = new CraftProduct(name, sku, cost);
		}
		else {
			p = new MiscProduct(name, sku, cost);
		}
		
		return p;
	}

}
