package App;

import java.util.ArrayList;
import java.util.Comparator;

public class Inventory implements Comparator<Product> {
	private ArrayList<Product> products;

	public Inventory(ArrayList<Product> Inventories) {
		super();
		this.products = new ArrayList<Product>();
	}

	public ArrayList<Product> getInventories() {
		return products;
	}

	@Override
	public int compare(Product i1, Product i2) {
		if (i1.getProductName().equalsIgnoreCase(i2.getProductName())) {
			return 1;
		} else {
			return 0;
		}
	}

}
