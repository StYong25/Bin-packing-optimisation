package finalAssignment;

import java.util.*;

public class NextFitAlgorithm extends AbstractBinAllocator{
	public NextFitAlgorithm(double binCapacity) {
		super(binCapacity);
	}

	public static void NextFitMain() {
		String filename ="skincare_products_with_weight.txt";
		ArrayList<Item> items = ItemLoader.loadFile(filename);
		//run test case with different sizes of boxes: 500cm3, 700cm3, 900cm3, 1200cm3, 1500cm3
		runCase(items, 500);
		runCase(items, 700);
		runCase(items, 900);
		runCase(items, 1200);
		runCase(items, 1500);
	}
	
	public static void runCase(ArrayList<Item> items, double binCapacity) {
		//header of each test case
		System.out.println("=== Box Size: " + binCapacity + "cm³ (Bin capacity: " + binCapacity + "cm³) ===");
		NextFitAlgorithm allocator = new NextFitAlgorithm(binCapacity);
		
		//initialize the stack to store the bins and call the methods
		Stack<Box> bins = allocator.allocateItem(items, binCapacity);
		
		//print the allocation of each items in each bins
		allocator.printBin(bins);  
		//print the used box in next fit algorithm
		System.out.println("\nTotal active bin in stack: "+ bins.size());
		System.out.println();
	}
	
	@Override
	public Stack<Box> allocateItem(ArrayList<Item> items, double binCapacity){
		Stack<Box> binStack = new Stack<>();
		Box currentBin = new Box(binCapacity);
		//iterate through all the item
		for (Item item: items) {
			//add the item into bin
			if (!currentBin.addItem(item)) {
				//store current box that are cannot fit current item into stack
				binStack.push(currentBin);
				//create a new box to store the next items
				currentBin = createNewBin();
				//store the current item into the new current box
				currentBin.addItem(item);
				
			}
		}
		//store the last current bin into the stack 
		binStack.push(currentBin);
		return binStack;
			
	}

	
}
