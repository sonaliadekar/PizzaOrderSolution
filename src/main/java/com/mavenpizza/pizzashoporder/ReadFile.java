/**
 *
 */
package com.mavenpizza.pizzashoporder;

/**
 * @author Sonali
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReadFile {

    ArrayList<PizzaOutputFile> pizzorderRecords = new ArrayList<PizzaOutputFile>();

    /**
     * @param InputFile
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    public void readFileData(PizzInputFile InputFile) throws IOException, ParseException{
        // Creating BufferedReader object to read the input text file
        Date orderDate;

        // Get File Name
        String FileName = InputFile.getFileName();
        // Reading PizzaOrder records one by one
        try ( // Creating ArrayList to hold final Pizza Order information
        // Read file
                BufferedReader reader = new BufferedReader(new FileReader(FileName))
        // Creating ArrayList to hold final Pizza Order information
        ) {
            // Reading PizzaOrder records one by one
            String currentLine = reader.readLine();
            int i;
            i = 0;
            while (currentLine != null) {
                String[] pizzorderDetail = currentLine.split("\t+");
                
                if (pizzorderDetail.length == 2 )
                {
                // Get Order Name
                String orderName = pizzorderDetail[0];
                // Get Order Time in Long
                String orderTime = pizzorderDetail[1];
                
                // Header Of File. Validate Header and continue
                if (i == 0) {
                    boolean invalidHeader = ValidateFileHeader(orderName, orderTime);
                    if (invalidHeader == false) {
                        break;
                    }
                    i++;
                } else // Check if any blank line exist in file. If exist then ignore that line
                    if (orderTime != null && orderName != null) {
                        // Order Time in Human readable format
                        orderDate = new Date(Long.parseLong(orderTime) * 1000);
                        // Fill Final ArrayList
                        pizzorderRecords.add(new PizzaOutputFile(orderName, orderDate));
                    }
                }
                currentLine = reader.readLine();
            }
            // Sort By order time                        
        }
    }

    public static boolean ValidateFileHeader(String orderName, String orderTime) {
        // Validate Order Column
        if (!"ORDER".equals(orderName.toUpperCase())) {
            return true;
        }
        // Validate Time Column
        if (!"TIME".equals(orderTime.toUpperCase())) {
            return true;
        }
        return true;
    }  
}
