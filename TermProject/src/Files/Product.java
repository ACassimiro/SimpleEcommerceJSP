package Files;

public class Product {
	private String name;
	private double price;
	private String imageURL;
	private int amount;
	
	public Product(String name, double price, String imageURL) {
		setName(name);
		setPrice(price);
		setImageURL(imageURL);
		setAmount(1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
