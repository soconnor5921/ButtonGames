package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application
{

    public static int level = 1;
    public static Button green = new Button();


   @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Simon Says");

        //Button green = new Button();
        green.setStyle("-fx-background-color: green; ");
        green.setMinSize(50,50);
        green.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameCode.checkGreen("green");
            }
        });

        Button blue = new Button();
        blue.setStyle("-fx-background-color: blue; ");
        blue.setMinSize(50,50);

        Button red = new Button();
        red.setStyle("-fx-background-color: red; ");
        red.setMinSize(50,50);

        Button yellow = new Button();
        yellow.setStyle("-fx-background-color: yellow; ");
        yellow.setMinSize(50,50);

        Button start = new Button("Start Game");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameCode.createOrder();
            }
        });

        HBox hbox1 = new HBox(green, blue, red, yellow, start);

        Scene scene1 = new Scene(hbox1,400, 400);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}