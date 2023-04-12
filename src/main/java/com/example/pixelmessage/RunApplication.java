package com.example.pixelmessage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class RunApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUpScene.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("PixaText");
        stage.setScene(scene);
        stage.show();
        Image AppIcon = new Image(DataController.IconImage);
        stage.getIcons().add(AppIcon);
    }

    public static void main(String[] args) {
        launch(args);




    }
}