package formula1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory; 

public class lapTime {

	private double file;
	private String race;
	private double laps;
	private double total;
	private String team;
		
	public double files(File file) {
		
	    double sum = 0.0;
	    int count = 0;

	    try {
	    	
	        File filePath = file;
	        FileInputStream file2 = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(file2);

	        // Access sheet #1 in the file
	        Sheet sheet = workbook.getSheetAt(0);

	        // Import all data from column 5
	        for (Row row : sheet) {
	            Cell cell = row.getCell(4); // Get the Cell at the Index / Column you want.

	            // Check the cell type and retrieve the value accordingly
	            if (cell != null) {
	                if (cell.getCellType() == CellType.NUMERIC) {
	                    double value = cell.getNumericCellValue();
	                    sum += value;
	                    count++;
	                } else if (cell.getCellType() == CellType.STRING) {
	                    String stringTime = cell.getStringCellValue();
	                    if (!stringTime.isEmpty()) {
	                        // Parse and convert the lap time string
	                        double value = parseLapTime(stringTime);
	                        sum += value;
	                        count++;
	                    }
	                }
	            }
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    double average = count > 0 ? sum / count : 0.0;
	    return average;
	    
	    
	    
	}

	// Helper method to parse lap time string in the format "1:39.000000"
	private double parseLapTime(String lapTime) {
	    String[] parts = lapTime.split(":");
	    int minutes = Integer.parseInt(parts[0]);
	    double seconds = Double.parseDouble(parts[1]);
	    return minutes * 60 + seconds;
	    
	}

	
	
}


