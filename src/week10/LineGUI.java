package week10;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class LineGUI extends Application {

    private Pane pane;
    private BorderPane borderPane, interactivePane;
    private VBox buttonBox;
    private Circle startPoint, endPoint, midPoint;
    private Line line;
    private Button distanceButton, midpointButton, vertHorzButton, levelButton;
    private Text displayInfo;
    private double xLength, yLength, distance;

    private static final int CIRCLE_RADIUS = 5;

    public void start(Stage primaryStage) {
        borderPane = new BorderPane();
        interactivePane = new BorderPane();
        borderPane.setBottom(interactivePane);

        buttonBox =  new VBox();
        buttonBox.setPrefWidth(200);

        pane = new Pane();
        pane.setOnMouseClicked(this::handleMouseClicks);
        borderPane.setCenter(pane);

        displayInfo = new Text();
        displayInfo.setTextAlignment(TextAlignment.LEFT);
        displayInfo.setTextOrigin(VPos.TOP);

        levelButton = new Button("Check true level");
        levelButton.setPrefWidth(200);
        levelButton.setOnAction(
                (ActionEvent event) -> {
                    if (line != null) {
                        DisplayLineInfo displayLineInfo = DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.DisplayType.DisplayTrueLevel);
                        String displayString = displayLineInfo.getInfo(line);
                        displayInfo.setText(displayString);
                    }
                }
        );
        distanceButton = new Button("Calculate Distance");
        distanceButton.setPrefWidth(200);
        distanceButton.setOnAction(
                (ActionEvent event) -> {
                    if (line != null) {
                        DisplayLineInfo displayLineInfo = DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.DisplayType.DisplayDistanceInfo);
                        String displayString = displayLineInfo.getInfo(line);
                        displayInfo.setText(displayString);
                    }
                }
        );
        midpointButton = new Button("Calculate Midpoint");
        midpointButton.setPrefWidth(200);
        midpointButton.setOnAction(
                (ActionEvent event) -> {
                    if (line != null) {
                        double midPointX = (startPoint.getCenterX()+endPoint.getCenterX())/2;
                        double midPointY = (startPoint.getCenterY()+endPoint.getCenterY())/2;

                        midPoint = new Circle(midPointX,midPointY,CIRCLE_RADIUS);
                        pane.getChildren().add(midPoint);
                        addCoordinateString(midPointX,midPointY);

                        DisplayLineInfo displayLineInfo = DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.DisplayType.DisplayMidPointInfo);
                        String displayString = displayLineInfo.getInfo(line);
                        displayInfo.setText(displayString);
                    }
                }
        );
        vertHorzButton = new Button("Determine Vertical/Horizontal");
        vertHorzButton.setPrefWidth(200);
        vertHorzButton.setOnAction(
                (ActionEvent event) -> {
                    if (line != null) {
                        DisplayLineInfo displayLineInfo = DisplayLineInfo.createDisplayLineInfo(DisplayLineInfo.DisplayType.DisplayVertHorzInfo);
                        String displayString = displayLineInfo.getInfo(line);
                        displayInfo.setText(displayString);
                    }

                }
        );

        buttonBox.getChildren().addAll(levelButton, distanceButton, vertHorzButton, midpointButton);
        interactivePane.setLeft(buttonBox);
        interactivePane.setCenter(displayInfo);

        Scene scene = new Scene(borderPane, 500, 500, Color.WHITE);
        primaryStage.setTitle("Line Characteristics");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void handleMouseClicks(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        if(startPoint==null ) { // no start point yet
            startPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(startPoint);
            addCoordinateString(x,y);
            line = null;
        } else if(endPoint==null) { // start point, but not end point yet
            endPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(endPoint);
            addCoordinateString(x,y);

            line = new Line(startPoint.getCenterX(), startPoint.getCenterY(), endPoint.getCenterX(), endPoint.getCenterY());
            pane.getChildren().add(line);

        } else { // startPoint != null && endPoint !=null
            // both start and end are there, so this is starting a new line
            // clear out everything from the last line
            pane.getChildren().clear();
            endPoint = null;
            line = null;
            displayInfo.setText("");

            // start the new line
            startPoint = new Circle(x,y,CIRCLE_RADIUS);
            pane.getChildren().add(startPoint);
            addCoordinateString(x,y);
        }
    }
    private void addCoordinateString(double x, double y) {
        String coordinateString = "(" + x + ", " + y + ")";
        Text coordinates = new Text(x-CIRCLE_RADIUS, y-CIRCLE_RADIUS-2, coordinateString);
        pane.getChildren().add(coordinates);
    }
    public static void main(String[] args) {
        launch(args);
    }

}