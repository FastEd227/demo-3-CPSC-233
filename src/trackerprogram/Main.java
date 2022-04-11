package trackerprogram;

//Name: Eddie Longeway
//UCID: 30041605
//Date: 2022/04/11
//Tutorial: t03


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Main extends Application {



    

    /**
     * A program-wide random number generator
     */

    public static void main(String[] args) {
        launch(args);
    }




    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("testrun1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("About");


        //Students edit here to set up the scene
        stage.setScene(scene);
        stage.show();
    }
}
