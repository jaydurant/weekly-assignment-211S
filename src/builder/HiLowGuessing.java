package builder;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Orientation;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.util.Random;



public class HiLowGuessing extends Application {
	private Text messageText;
	private TextField answerField;
	private Button enterButton;
	private Button newGameButton;
	private int randomNumber;
	
	public void start(Stage primaryStage) {
		randomNumber = this.generateRandomNumber(1, 100);
		
		FlowPane pane = new FlowPane();
		pane.setStyle("-fx-background-color: null;");
		pane.setVgap(20);
		pane.setOrientation(Orientation.VERTICAL);
		
		messageText = new Text("Choose a number between 1 and 100");
		messageText.setFont(Font.font(18));
		messageText.setFill(Color.BLACK);
		pane.getChildren().add(messageText);
		
		
		answerField = new TextField();
		pane.getChildren().add(answerField);
		
		enterButton = new Button("Enter A Guess " + String.valueOf(randomNumber));
		enterButton.setOnAction(this::handleButtonGuess);
		enterButton.setVisible(true);
		pane.getChildren().add(enterButton);
		
		newGameButton = new Button("Yes");
		newGameButton.setOnAction(this::playNewGame);
		newGameButton.setVisible(false);
		pane.getChildren().add(newGameButton);
		
		
		Scene scene = new Scene(pane, 400, 500, Color.BEIGE);
		
		primaryStage.setTitle("HiLow Game!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void playNewGame(ActionEvent event) {
		randomNumber = generateRandomNumber(1,100);
		messageText.setText("Choose a number between 1 and 100");
		enterButton.setVisible(true);
		newGameButton.setVisible(false);
	}
	
	private void handleButtonGuess(ActionEvent event) {
		String guessStr = answerField.getText();
		answerField.setText("");
		
		int guessInt = Integer.parseInt(guessStr);
		String resultStr = this.guessComparedToRandomNumber(guessInt);
		
		if (resultStr == "Correct") {
			messageText.setText("Play Again");
			newGameButton.setVisible(true);
			enterButton.setVisible(false);
		}else {
			messageText.setText("Your number " + guessStr  +  " is " + resultStr);
		}
	}
	
	private int generateRandomNumber(int low, int high) {
		Random rand = new Random();

		int  n = rand.nextInt(high) + low;
		return n;
	}
	
	private String guessComparedToRandomNumber(int guessInt) {
		String message = "Correct";
		
		if (guessInt > this.randomNumber ) {
			message = "High";
		}
		else if(guessInt < this.randomNumber) {
			message = "Low";
		}
		
		return message;
	}

}
