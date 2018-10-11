package week6;

import java.io.*;
import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class CustomerInput extends Application {

    private Stage primaryStage;
    private Text statusText, resultText;
    private Button uploadButton;
    private ArrayList<Customer> customerList = new ArrayList<>();

    private final static Font RESULT_FONT = Font.font("Helvetica", 24);
    private final static Font INPUT_FONT = Font.font("Helvetica", 20);

    @Override
    public void start(Stage primaryStage) {
    	
        this.primaryStage = primaryStage;

        VBox primaryBox = new VBox();
        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setSpacing(20);
        primaryBox.setStyle("-fx-background-color: white");

        VBox uploadBox = new VBox();
        uploadBox.setAlignment(Pos.CENTER);
        uploadBox.setSpacing(20);
        Text uploadLabel = new Text("Upload a comma-separated file with customer data.");
        uploadLabel.setFont(INPUT_FONT);
        uploadButton = new Button("Upload data");
        uploadButton.setOnAction(this::processDataUpload);

        uploadBox.getChildren().add(uploadLabel);
        uploadBox.getChildren().add(uploadButton);
        primaryBox.getChildren().add(uploadBox);

        VBox resultsBox = new VBox();
        resultsBox.setAlignment(Pos.CENTER);
        resultsBox.setSpacing(20);
        statusText = new Text("");
        statusText.setVisible(false);
        statusText.setFont(RESULT_FONT);
        statusText.setFill(Color.RED);
        resultText = new Text("");
        resultText.setVisible(false);
        resultText.setFont(RESULT_FONT);
        resultsBox.getChildren().add(statusText);
        resultsBox.getChildren().add(resultText);
        primaryBox.getChildren().add(resultsBox);

        Scene scene = new Scene(primaryBox, 700, 700, Color.TRANSPARENT);
        primaryStage.setTitle("Customer Data Upload");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void processDataUpload(ActionEvent event) {
        statusText.setVisible(false);
        resultText.setVisible(false);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        try {
	        parseFile(file);
	        
	        if (customerList.size() > 0) {
	        	displayResults();
		        disableButton(uploadButton);
	        }
	        
        }
        catch(IllegalArgumentException ex){
        	statusText.setText(ex.getMessage() + "integers are expected for order value");
        	statusText.setVisible(true);
        	customerList.clear();
        }
    	
    }
    
    private void disableButton(Button button) {
    	button.setDisable(true);
    }
    
    private void displayResults() {
    	int orderTotal = 0;
    	int customerCount = 0;
     	for (Customer customer : customerList) {
    		orderTotal += customer.getNumberOfOrders();
    		customerCount++;
    	}
     	
     	String customerText = customerCount == 0 || customerCount > 1 ? "Customers": "Customer";
    	
    	statusText.setText("Success! " + customerCount + " " +  customerText +" were created!");
    	statusText.setVisible(true);
    	
    	resultText.setText("Total Orders: " + orderTotal);
    	resultText.setVisible(true);
    }

    private void parseFile(File file) {
    	try {
    		Scanner fileScan =  new Scanner(new FileReader(file));
	              
	       while(fileScan.hasNext()) {
	    	   String oneLine = fileScan.nextLine();
	    	   
	    	   Scanner lineScan = new Scanner(oneLine);
	    	   
	    	   lineScan.useDelimiter(",");
	    	   
	    	   String id = lineScan.next();
	    	   if (id.contains("@")) {
		    		throw new InvalidCharacterException("New Error");
		    	}
	    	   
	    	   int numberOfOrders = Integer.parseInt(lineScan.next());
	    	   
	    	   Customer newCustomer = new Customer(id, numberOfOrders);
	    	   this.customerList.add(newCustomer);
	       }
    	}
    	catch(InvalidCharacterException ex) {
    		statusText.setText(ex.getMessage());
    		statusText.setVisible(true);
    		customerList.clear();
    	}
    	
    	catch(IOException ex) {
    		statusText.setText(ex.getMessage());
    		statusText.setVisible(true);
    	}
    }

    public static void main(String[] args) {
    	
        launch(args);
    }

}
