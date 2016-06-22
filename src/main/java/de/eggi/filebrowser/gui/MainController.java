package de.eggi.filebrowser.gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private BorderPane borderPane;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu file_menu;

    @FXML
    private Menu help_menu;

    @FXML
    private MenuItem file_menu_item_close;

    @FXML
    private MenuItem help_menu_item_about;

    @FXML
    protected void handleCloseAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    protected void handleAboutAction(ActionEvent event) {
        Stage stage;
        Parent root;

        try {
            stage = new Stage();

            root = FXMLLoader.load(getClass().getResource("/aboutPopUp.fxml"));

            stage.setScene(new Scene(root));
            stage.setTitle("About filebrowser");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/File-Explorer-256.png")));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(mainPane.getScene().getWindow());
            stage.setResizable(false);
            stage.getScene().getStylesheets().add(
                    getClass().getResource("/css/about.css").toExternalForm());
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}