package fx;

import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class CarGUIView {
	private ComboBox<String> colorComboBox;
	private TextField makeField, modelField, priceField;
	private Text introText, makeLabel, modelLabel, priceLabel, colorLabel, resultLabel;
	private TextArea result;
	private Button addButton, displayButton, processButton;
	private VBox primaryBox;

	private final static Font font = Font.font("Helvetica", 20);
	
	public CarGUIView() {
		System.setProperty("glass.accessible.force", "false");
		
		primaryBox = new VBox();
		primaryBox.setAlignment(Pos.CENTER);
		primaryBox.setSpacing(20);
		primaryBox.setStyle("-fx-background-color: white");

		introText = new Text("Create your new car!\n Input the car information.");
		introText.setFont(font);
		VBox introBox = new VBox(introText);
		introBox.setAlignment(Pos.CENTER);
		introBox.setSpacing(10);
		primaryBox.getChildren().add(introBox);
		
		makeLabel =  new Text("Enter the make of the car:");
		makeLabel.setFont(font);
		makeField = new TextField();
		VBox makeBox = new VBox(makeLabel, makeField);
		makeBox.setAlignment(Pos.CENTER);
		makeBox.setSpacing(15);
		primaryBox.getChildren().add(makeBox);
		
		modelLabel =  new Text("Enter the model of the car:");
		modelLabel.setFont(font);
		modelField = new TextField();
		VBox modelBox = new VBox(modelLabel, modelField);
		modelBox.setAlignment(Pos.CENTER);
		modelBox.setSpacing(15);
		primaryBox.getChildren().add(modelBox);
		
		priceLabel =  new Text("Enter your desired price for the car:");
		priceLabel.setFont(font);
		priceField = new TextField();
		VBox priceBox = new VBox(priceLabel, priceField);
		priceBox.setAlignment(Pos.CENTER);
		priceBox.setSpacing(15);
		primaryBox.getChildren().add(priceBox);
		
		colorLabel = new Text("Select the color:");
		colorLabel.setFont(font);
		String[] colors = {"Blue","Green","Yellow"};
		ObservableList<String> stringOptions = FXCollections.observableArrayList(colors);
		colorComboBox = new ComboBox<String>(stringOptions);
		VBox colorBox = new VBox(colorLabel, colorComboBox);
		colorBox.setAlignment(Pos.CENTER);
		colorBox.setSpacing(10);
		primaryBox.getChildren().add(colorBox);
		
		addButton = new Button("Add Car");
		displayButton =  new Button("Display Car");
		processButton = new Button("Process Car");
		
		HBox buttonBox = new HBox(addButton, displayButton, processButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		primaryBox.getChildren().add(buttonBox);
		
		resultLabel = new Text("");
		resultLabel.setFont(font);
		resultLabel.setFill(Color.GREEN);
		resultLabel.setVisible(false);
		result = new TextArea("");
		result.setVisible(false);
		result.setEditable(false);
		VBox resultBox = new VBox(resultLabel, result);
		resultBox.setAlignment(Pos.CENTER);
		resultBox.setSpacing(10);
		primaryBox.getChildren().add(resultBox);
		
	}
	
	public Parent getParent() {
		return primaryBox;
	}
	
	public void setAddCarAction(EventHandler<ActionEvent> handler) {
		addButton.setOnAction(handler);
	}
	
	public void setDisplayCarAction(EventHandler<ActionEvent> handler) {
		displayButton.setOnAction(handler);
	}
	
	public void setProcessAction(EventHandler<ActionEvent> handler) {
		processButton.setOnAction(handler);
	}
	
	public void displayResultText(String label, String output) {
		resultLabel.setVisible(true);
		resultLabel.setText(label);
		
		result.clear();
		result.setVisible(true);
		result.setText(output);
	}
	
	public void hideResultText() {
		result.clear();
		result.setVisible(false);
		resultLabel.setVisible(false);
	}
	
	public void clearInputs() {
		makeField.clear();
		modelField.clear();
		priceField.clear();
	}
	
	public String getMakeField() {
		return makeField.getText();
	}
	public String getModelField() {
		return modelField.getText();
	}
	public String getColorField() {
		return colorComboBox.getValue();
	}
	
	public String getPriceField() {
		return priceField.getText();
	}
	
	public void setMakeField(String text) {
		makeField.setText(text);
	}
	public void setModelField(String text) {
		modelField.setText(text);
	}
	
	public void setcolorField(String color) {
		colorComboBox.setValue(color);
	}
	
	public void setPriceField(String price) {
		priceField.setText(price);
	}

}
