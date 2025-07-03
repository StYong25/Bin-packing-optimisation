package finalAssignment;

import java.util.*;

public interface BoxAllocator {
	public Stack<Box> allocateItem(ArrayList<Item> item, double binCapacity);
	
	public void printBin(Stack<Box> bins);
}
