package builder;
import java.io.File;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.scene.text.*;

public class DisplayImage extends Application {

	public void start(Stage primaryStage) {
		VBox mainBox = new VBox();
		mainBox.setAlignment(Pos.CENTER);
		mainBox.setSpacing(70);
		
		Image catImage  = new Image("cat.jpg", 1000, 700, true, true);
		ImageView catImageView = new ImageView(catImage);
		mainBox.getChildren().add(catImageView);
		
		Text catDesc = new Text("My cat Charlie");
		catDesc.setFont(Font.font(20));
		mainBox.getChildren().add(catDesc);
		
		Scene scene = new Scene(mainBox, 1000, 1000, Color.TRANSPARENT);
		primaryStage.setTitle("Display Cat Image");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
