package finalAssignment;

import java.util.ArrayList;

public class Box {
	public double capacity;
	public double remainingCapacity;
	public ArrayList<Item> items;
	
	public Box(double capacity) {
		this.capacity = capacity;
		this.remainingCapacity = capacity;
		this.items = new ArrayList<>();
	}
	
	public double getRemainingCapacity() {
		return remainingCapacity;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	//Method to add an item into the box
	public boolean addItem(Item item) {
		if(item.getVolume() <= remainingCapacity) { //Check if item fits
			items.add(item);                       //Add item to the box
			remainingCapacity -= item.getVolume(); //reduce remaining capacity
			return true;
		}
		return false; //Item does not fit
	}
	
	//Calculate total volume of items inside the box
	public double calculateTotalVolume() {
		double totalVolume = 0.0;
		for(Item item : items)
			totalVolume += item.getVolume();
		return totalVolume;
	}
	
	//Calculate total weight of items inside the box
	public double calculateTotalWeight() {
		double totalWeight = 0.0;
		for(Item item : items)
			totalWeight +=  item.getWeight();
		return totalWeight;
	}
	
	//Calculate posting fee based on total weight of each box contents
	public double calculatePostingFee(double totalWeight) {
		double totalPayment = 0;
		
		if (totalWeight == 0) {
			totalPayment = 0;
		}else if ((totalWeight <=0.5)) {
			totalPayment  = totalWeight*0.65;
			
		} else if ((totalWeight >=0.501)&&(totalWeight < 1)) {
			totalPayment = totalWeight*0.7;
			
		}else if ((totalWeight >=1)&&(totalWeight < 2 )) {
			totalPayment = totalWeight*1.00;
			
		}else if ((totalWeight >= 2)&&(totalWeight < 5)) {
			totalPayment = totalWeight *1.5;
			
		}else if ((totalWeight >= 5)&&(totalWeight < 10)) {
			totalPayment = totalWeight *2.00;
			
		}else if ((totalWeight >= 10) && (totalWeight < 15)) {
			totalPayment  = totalWeight *3.00;
			
		}else if ((totalWeight >=15) && (totalWeight <= 20)) {
			totalPayment = totalWeight * 28;
		}
		return totalPayment;
	}
	
	//Calculate the remaining capacity percentage
	public double remainingCapacityPercent() {
		return (remainingCapacity / capacity) * 100;
	}
}
