package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

import static java.util.Collections.sort;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Integer I = new Integer(15);
        boolean i = I.equals(new Integer(15));
        ArrayList<Integer> al = new ArrayList<Integer>();

        sort(al);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
