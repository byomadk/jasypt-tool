package com.jasypt.jasypt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        AnchorPane page = fxmlLoader.load();
//        Scene scene = new Scene(fxmlLoader.load(), 540, 640);
        Scene scene = new Scene(page);
        stage.setTitle("Jasypt Tools GUI v0.3.1");
        stage.setScene(scene);
        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("kopra-logo-blue.jpg")));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}