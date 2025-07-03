package finalAssignment;

import java.util.ArrayList;



public class FirstFitAlgorithm extends AbstractBinPacking {

	public static void FirstFitMain() {
        // Load items from file
        String filename = "skincare_products_with_weight.txt";
        ArrayList<Item> items = ItemLoader.loadFile(filename);
        
        //Run test cases with different box capacities
        runTestCases(items, 500);
        runTestCases(items, 700);
        runTestCases(items, 900);
        runTestCases(items, 1200);
        runTestCases(items, 1500);
    }

    //First Fit algorithm to pack items into box
	@Override
    public ArrayList<Box> FirstFitPacking(ArrayList<Item> items, double boxCapacity) {
        ArrayList<Box> boxes = new ArrayList<>();
        //Iterate through each item to place it into box
        for (Item item : items) {
            boolean placed = false;
            //Try to place item in an existing box
            for (Box box : boxes) {
                if (box.addItem(item)) {
                    placed = true;
                    break; //Stop checking other box
                }
            }
            //If item does not fit in any existing box, create a new box
            if (!placed) {
                Box newBox = new Box(boxCapacity);
                newBox.addItem(item);
                boxes.add(newBox);
            }
        }

        return boxes;
    }
    
	public static void runTestCases(ArrayList<Item> items, double boxCapacity) {
      FirstFitAlgorithm ffp = new FirstFitAlgorithm();
      
      //Pack the items into boxes using First-Fit algorithm
      ArrayList<Box> packedBoxes = ffp.FirstFitPacking(items, boxCapacity);

      System.out.println("\n=== Box Size: " + boxCapacity + "cm³ (Bin capacity: " + boxCapacity + "cm³) ===");
      int numberOfBox = 1;
      double totalRemaining = 0;
      double totalWeight = 0;
      double totalPostage = 0;
      double boxWeight = 0;
      for (Box box : packedBoxes) {
    	  System.out.println("Box " + numberOfBox + ": ");
    	  boxWeight = box.calculateTotalWeight()/1000;
    	  System.out.println("Remaining space: "+ box.getRemainingCapacity()+"cm³");
	      System.out.printf("Total weight of items: %.2f kg\n", boxWeight);
          totalWeight += boxWeight;
          totalPostage += box.calculatePostingFee(boxWeight);
          totalRemaining += box.remainingCapacityPercent();
          System.out.println();
          numberOfBox++;
      }
      double AverageRemaining  = totalRemaining / (numberOfBox-1);
      double AverageWeight = totalWeight / (numberOfBox-1);
      System.out.println("Average Remaining Space: " + String.format("%.2f", AverageRemaining) + "%");
      System.out.println("Average Weight of All Items: " + String.format("%.2f", AverageWeight) + " kg");
      System.out.println("Total payment of postage for all boxes" + ": RM " + String.format("%.2f", totalPostage));
      System.out.println("Total active bin in ArrayList: "+ packedBoxes.size());
	}

}
