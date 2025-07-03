package finalAssignment;

import java.util.ArrayList;

public abstract class AbstractBinPacking implements BinPacking {

	protected ArrayList<Item> items;
	
	public AbstractBinPacking() {
		// Initialize the items list
		this.items = new ArrayList<>();
	}
	
	@Override
	public abstract ArrayList<Box> FirstFitPacking(ArrayList<Item> items, double boxCapacity);
	

}
