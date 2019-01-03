package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static sample.GameCode.timer;

public class Main extends Application
{

    public static int level = 1;
    public static Button green = new Button();
    public static Button blue = new Button();
    public static Button red = new Button();
    public static Button yellow = new Button();
    public static boolean showing = false;
    private static long timeStep;
    private static List<Button> order = new ArrayList<Button>();


   @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Simon Says");

        //Button green = new Button();
        green.setStyle("-fx-background-color: green;");
        green.setMinSize(50,50);
        green.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {showing = true; timer(green);
            }
        });

        //Button blue = new Button();
        blue.setStyle("-fx-background-color: blue;");
        blue.setMinSize(50,50);

        //Button red = new Button();
        red.setStyle("-fx-background-color: red;");
        red.setMinSize(50,50);

        //Button yellow = new Button();
        yellow.setStyle("-fx-background-color: yellow;");
        yellow.setMinSize(50,50);

        Button start = new Button("Start Game");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {createOrder();}
        });

        HBox hbox1 = new HBox(green, blue, red, yellow, start);

        Scene scene1 = new Scene(hbox1,400, 400);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void createOrder()
    {
        showing = true;
        Button btn;
        btn = pickRandomColor();
        order.add(btn);
        timer(btn);
        level++;
    }

    public static Button pickRandomColor()
    {
        int num = (int)(Math.random()*4);
        if(num == 0)
        {
            return green;
        }
        else if(num == 1)
        {
            return blue;
        }
        else if(num == 2)
        {
            return red;
        }
        else
        {
            return yellow;
        }
    }

    public static void timer(Button btn)
    {
        timeStep = System.nanoTime() + 100000000L;
        new AnimationTimer()
        {
            public void handle(long now)
            {
                if(now > timeStep)
                {
                    timeStep = now + 1000000000L;
                    showing = !showing;
                }
                if(showing)
                {
                    btn.setStyle("-fx-background-color: lightgreen;");
                }
                else
                {
                    btn.setStyle("-fx-background-color: green;");
                    this.stop();
                }

            }
        }.start();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}