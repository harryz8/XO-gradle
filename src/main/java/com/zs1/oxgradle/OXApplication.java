package com.zs1.oxgradle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class OXApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OXApplication.class.getResource("ox-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("OX Game");
        stage.getIcons().add(new Image(OXApplication.class.getResourceAsStream("OX.ico")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}