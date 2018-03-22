package com.mavenpizza.pizzashoporder;
/**
 * @author Sonali
 *
 */
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class FXMLController implements Initializable {

    @FXML
    private Label label;
    private String pizzorderRecords;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String pizzaFile = null;
        ReadFile ReadFile = null;
        if (!ensureIndexIsSelected()) {
            return;
        }

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            String FileName = selectedFile.getPath();
            ArrayList<PizzaOutputFile> formatedOrders = null;
// Get File Name from user input
            PizzInputFile pizzaInputFile = new PizzInputFile();
            pizzaInputFile.setFileName(FileName);
// Read File in formated form            
            try {
                ReadFile = new ReadFile();
                ReadFile.readFileData(pizzaInputFile);

            } catch (IOException | ParseException ex) {
                // Display Error Message
                System.out.println(ex);
            }

// Show File Save Dialog            
            FileChooser saveFileChoser;
            saveFileChoser = new FileChooser();

            saveFileChoser.setTitle("Save Formatted file");
            String defaultFileName = null;
            saveFileChoser.setInitialFileName(defaultFileName);
            FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            saveFileChoser.getExtensionFilters().add(extFilter1);
            saveFileChoser.setInitialFileName("FormatedPizzaOrderFile.txt");
            Window savedStage = null;

            File savedFile = saveFileChoser.showSaveDialog(savedStage);
            if (savedFile != null) {
                SaveFile(savedFile, ReadFile.pizzorderRecords);
            }
        } else {
            // Display Error Message
            System.out.println("Please select file");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private boolean ensureIndexIsSelected() {

        return true;
    }

    private void SaveFile(File file, ArrayList<PizzaOutputFile> pizzaOrderFinalOutput) {
// Write File to User System
        WriteFile writeFileToPC  = new WriteFile();        
        writeFileToPC.writeFile(file, pizzaOrderFinalOutput);
        

    }

    public static String getDateFromSeconds(java.util.Date orderDate) {
        DateFormat formatter;
        formatter = new SimpleDateFormat("MMM.dd.yyyy HH:mm:ss");
        return formatter.format(orderDate);
    }
}
