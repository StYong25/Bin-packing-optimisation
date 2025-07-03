package finalAssignment;

import java.util.*;
import java.io.*;

public abstract class AbstractBinAllocator implements BoxAllocator{
	protected double binCapacity;
	
	public AbstractBinAllocator(double binCapacity) {
		this.binCapacity = binCapacity;
	}
	
	//create new box for next items
	protected Box createNewBin() {
		return new Box(binCapacity);
	}
	
	//print the remaining space and total weight of each box
	//print the average percentage of remaining space, total weight and total payment of all bins
	public void printBin(Stack<Box> bins) {
	    double totalRemaining = 0;
	    double totalWeight = 0;
	    double totalPostage = 0;
	    double binWeight = 0;
	    int binCount = bins.size();
	    int binCounter = 1;
	    for (Box bin : bins) {
	        binWeight = (bin.calculateTotalWeight())/1000;
	    	System.out.println("Box " + binCounter +":");
	        System.out.println("Remaining space: " + bin.getRemainingCapacity()+"cm³");
	        System.out.printf("Total weight of items: %.2f kg\n" , binWeight);
	        System.out.println();
	        totalRemaining += bin.remainingCapacityPercent();
	        totalWeight += binWeight;
	        totalPostage += bin.calculatePostingFee(binWeight);
	        binCounter ++;
	    }

	    double avgRemaining = totalRemaining / binCount;
	    double avgWeight = totalWeight / binCount;
	    System.out.printf("Average Remaining Space: %.2f%%\n", avgRemaining);
	    System.out.printf("Average Weight of all boxes: %.2f kg\n", avgWeight);
	    System.out.printf("Total payment of postage for all boxes: RM" + String.format("%.2f",totalPostage));
	}
}
