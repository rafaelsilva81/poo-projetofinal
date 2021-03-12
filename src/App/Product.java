package App;

public class Product implements Comparable<Product> {
	private String productName;
	private int quantity;
	private String condition;
	private String category;

	public Product(String productName, int quantity, String condition, String category) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.condition = condition;
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String show() {
		return this.getProductName() + " - " + this.getCategory() + " - " + this.getCondition() + " - "
				+ this.getQuantity();

	}

	@Override
	public int compareTo(Product o) {
		return this.getProductName().compareTo(o.getProductName());
	}

}
