package formula1;

import java.io.File;
import java.util.Scanner; 


public class formulaOne {
	
	public static void main(String [] args) {
		
		double laps;
		double total;
		
		//
		
		Scanner userInput = new Scanner(System.in);
		
		// add some sort of exception for if someone misspells any of the options below. Also adjust all strings to upperCase. 
		System.out.println("ENTER GRAND PRIX: ");
		String track = userInput.nextLine().toUpperCase();
		
		
		new formulaGUI();
		
		
		// Create a File object for the Excel file
		File file = new File(track + ".xlsx");
				
		// Check if the file exists
		if (!file.exists()) {
			System.out.println("The file does not exist.");
				return;}
				
		
		lapTime time = new lapTime();
		double lapAverage = time.files(file);
		System.out.println("\nThe average historical lap time is " + String.valueOf(lapAverage) + " seconds");
		
		
		System.out.println("\nEnter the last five lap times: ");
		
		System.out.println("ENTER LAP A: ");
		double lapA = userInput.nextDouble();
		System.out.println("ENTER LAP B: ");
		double lapB = userInput.nextDouble();
		System.out.println("ENTER LAP C: ");
		double lapC = userInput.nextDouble();
		System.out.println("ENTER LAP D: ");
		double lapD = userInput.nextDouble();
		System.out.println("ENTER LAP E: ");
		double lapE = userInput.nextDouble();
	
		laps = lapA + lapB + lapC + lapD + lapE;
		total = laps/5;
		
		if (total >= lapAverage) {
			System.out.println("\nYou Need a Pit Stop, BOX BOX BOX");
		}else { 
			System.out.println("\nDO NOT BOX, Stay out stay out");
		}
	
		
	
	}}






 
