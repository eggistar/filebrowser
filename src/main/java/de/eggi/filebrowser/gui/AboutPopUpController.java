package de.eggi.filebrowser.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutPopUpController implements Initializable {

    @FXML
    private AnchorPane popUpPane;

    @FXML
    private BorderPane popUpBorderPane;

    @FXML
    private WebView aboutText;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String url = Main.class.getResource("/html/about.html").toExternalForm();
        WebEngine engine = aboutText.getEngine();
        engine.load(url);
    }
}
