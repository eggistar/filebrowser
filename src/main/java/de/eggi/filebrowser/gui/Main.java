package de.eggi.filebrowser.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/filebrowser.fxml"));

        primaryStage.setTitle("filebrowser");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/File-Explorer-256.png")));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.getScene().getStylesheets().add(
                getClass().getResource("/css/main.css").toExternalForm());

        primaryStage.show();
    }
}
