package de.eggi.filebrowser.gui;

import de.eggi.filebrowser.gui.de.eggi.filebrowser.filetree.FileComparator;
import de.eggi.filebrowser.gui.de.eggi.filebrowser.filetree.FileTreeItem;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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
    private TreeView<File> fileTree;

    @FXML
    private ListView<File> folderList;

    @FXML
    private SplitPane splitPane;

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

    @SuppressWarnings("unused")
    public void initialize() {
        fileTree.setRoot(new FileTreeItem(new File("C:\\")));

        fileTree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            FileComparator fileComparator = new FileComparator();
            File[] filesInFolder = new File(observable.getValue().getValue().getAbsolutePath()).listFiles();
            Arrays.sort(filesInFolder != null ? filesInFolder : new File[0], fileComparator.compare);
            folderList.setItems(FXCollections.observableArrayList(filesInFolder));
        });
    }
}