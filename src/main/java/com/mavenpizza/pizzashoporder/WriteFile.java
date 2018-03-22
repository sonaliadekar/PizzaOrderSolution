/**
 *
 */
package com.mavenpizza.pizzashoporder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Sonali
 *
 */
public class WriteFile {

    public boolean writeFile(File file, ArrayList<PizzaOutputFile> pizzaOrderFinalOutput) {
     OrderNumberSorter ordernumbersorter = new OrderNumberSorter(pizzaOrderFinalOutput);
          
     pizzaOrderFinalOutput = ordernumbersorter.getSortedOrderTime();
     
        try {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("OrderName" + "\t" + "Orderdate");
                //fileWriter = new FileWriter(file);
                for (PizzaOutputFile PizzaOutputFile : pizzaOrderFinalOutput) {
                    writer.newLine();
                    writer.write(PizzaOutputFile.orderName + "\t\t");
                    String formateDate = getDateFromSeconds(PizzaOutputFile.orderDate);
                    writer.write(formateDate + "\t");
                }
                // Close Writer
            }
            //fileWriter = new FileWriter(file);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return true;
    }
    public static String getDateFromSeconds(java.util.Date orderDate) {
        DateFormat formatter;
        formatter = new SimpleDateFormat("MMM.dd.yyyy HH:mm:ss");
        return formatter.format(orderDate);
    }
}
