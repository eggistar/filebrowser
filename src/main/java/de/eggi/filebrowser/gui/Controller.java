package de.eggi.filebrowser.gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Controller {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private BorderPane borderPane;

    @FXML
    private MenuBar menuBar;

     @FXML
    private Menu file_menu;

    @FXML
    private MenuItem file_menu_item_close;


    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}