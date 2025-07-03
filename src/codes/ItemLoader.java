package finalAssignment;

import java.util.*;
import java.io.*;

public class ItemLoader {
	public static ArrayList<Item> loadFile(String filename){
		ArrayList<Item> items = new ArrayList<>();
		try {
			//read items from text file
			Scanner in = new Scanner(new File(filename));
			//header
			if (in.hasNextLine())
				in.nextLine();
			
			while (in.hasNextLine()) {
				String line  = in.nextLine();
				if (line.isEmpty()) continue; //skip empty lines
				
				try {
					String[] parts = line.split("\t");
					String name = parts[0];
					double volume = Double.parseDouble(parts[1]);
					double weight = Double.parseDouble(parts[2]);
					//initialize the data into items
					Item item = new Item(name, volume, weight);
					//store the item into array list
					items.add(item);
				}
				catch(NumberFormatException ex) {
					System.out.println("Invalid number format in line: " + line);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return items;
		
	}
}
