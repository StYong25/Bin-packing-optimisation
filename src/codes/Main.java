package finalAssignment;

public class Main  {

	public static void main(String[] args) {
		System.out.println("\t_________________________________________");
        System.out.println("\t|   Skincare products packing result     |");
        System.out.println("\t-----------------------------------------");
        System.out.println("\n░▒▓█ First fit with ArrayList█▓▒░");
        //call the first fit algorithm 
        FirstFitAlgorithm.FirstFitMain();
        
        System.out.println("\n░▒▓█ Next fit with stack █▓▒░");
        //call the next fit algorithm
        NextFitAlgorithm.NextFitMain();

	}
}
