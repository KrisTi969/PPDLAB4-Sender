package com.sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ActionEvent actionEvent = null;
      //  @FXML
        //private TextArea id
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("com/sample/sample.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("PPDL4");
        primaryStage.setScene(new Scene(root, 860,960 ));
        primaryStage.show();
        Controller controller = fxmlLoader.getController();
        controller.initialPopulation();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
