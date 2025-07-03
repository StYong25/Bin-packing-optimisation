package finalAssignment;

public class Item {
	public double weight;
	public double volume;
	public String productName;
	
	public Item(String productName, double volume, double weight) {
		this.productName = productName;
		this.volume = volume;
		this.weight = weight;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public double getVolume() {
		return volume;
	}
	
	public double getWeight() {
		return weight;
	}
}
