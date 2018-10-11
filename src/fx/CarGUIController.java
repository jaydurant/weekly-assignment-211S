package fx;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CarGUIController extends Application {
	private CarGUIView carView;
	private ArrayList<CarModel> carModels =  new ArrayList<>();
	
	public CarGUIController() {
		carView =  new CarGUIView();
		
		carView.setProcessAction(this::processCarModels);
		carView.setDisplayCarAction(this::displayCarModels);
		carView.setAddCarAction(this::addCarModels);
	}

	@Override
	public void start(Stage primaryStage) {
		CarGUIController controller = new CarGUIController();
		Scene scene = new Scene(controller.carView.getParent(), 450, 500, Color.TRANSPARENT);
		
		primaryStage.setTitle("Car Model Ordering System");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void addCarModels(ActionEvent event) {
		String errorMessage = "";
		
		try {
			String make = carView.getMakeField();
			if (make.isEmpty()) {
				errorMessage = "Make cannot be empty.";
				throw new IllegalArgumentException();
			}
			try {
				String model = carView.getModelField();
				if (model.isEmpty()) {
					errorMessage = "Model cannot be empty.";
					throw new IllegalArgumentException();
				}
				
				try {
					String price = carView.getPriceField();
					if (price.isEmpty()) {
						errorMessage = "Price cannot be empty.";
						throw new IllegalArgumentException();
					}
					int priceInt = Integer.parseInt(price);
					String color = carView.getColorField();
					CarModel carModel = new CarModel(make,model, color, priceInt);
					carModels.add(carModel);
					
				}catch(NumberFormatException ex) {
					errorMessage = "Price must be integer.";
					throw new IllegalArgumentException();
				}
				
			}catch (IllegalArgumentException ex) {
				throw new IllegalArgumentException();
			}
		}catch (IllegalArgumentException ex) {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Error");
			error.setHeaderText(null);
			error.setContentText(errorMessage);
			error.showAndWait();
		}finally {
			carView.clearInputs(); // update the view- we clear it out for new input
			carView.hideResultText();
		}
	}
	
	private void processCarModels(ActionEvent event) {
		String results = "";
		
		for (CarModel carModel: carModels) {
			results += "$" +  carModel.priceMultiplier() + ";";
		}
		carView.displayResultText("Processing Prices", results);
	}
	
	private void displayCarModels(ActionEvent event) {
		String results = "";
		for (CarModel carModel: carModels) {
			results += carModel.toString() + ";";
		}
		
		carView.displayResultText("Display CarModels", results);
	}

}
