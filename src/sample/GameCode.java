package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameCode extends Application
{
    static List<String> order = new ArrayList<String>();

    @Override
    public void start(Stage primaryStage)
    {

    }

    public static void createOrder()
    {
        for(int i = 0; i < Main.level; i++)
        {
            order.add(pickRandomColor());
        }
        for(int i = 0; i < order.size(); i++)
        {
            System.out.println(order.get(i));
        }
        Main.level++;
    }

    public static String pickRandomColor()
    {
        int num = (int)(Math.random()*4);
        if(num == 0)
        {
            return "green";
        }
        else if(num == 1)
        {
            return "blue";
        }
        else if(num == 2)
        {
            return "red";
        }
        else
        {
            return "yellow";
        }
    }

    public static void checkGreen(String color)
    {
        if(color.equals("green"))
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
