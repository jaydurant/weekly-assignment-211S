package storeinventory;

public class StoreInventoryTester {

	public static void main(String[] args) {
		Store store =  new Store();
		
		String[] names = {"walkman", "pen","ruler"};
		int [] skus = {111,222,333};
		float[] costs = {12.04F, 1.94F, 2.40F};
		String[] types = {"electronic", "craft","misc"};
		
		for (int i = 0 ;i < 3 ;i++ ) {
			
			Product newProduct = ProductFactory.newProduct(names[i], skus[i], costs[i], types[i]);
			store.addProduct(newProduct);
		}
		
		store.displayProducts()
	}

}
