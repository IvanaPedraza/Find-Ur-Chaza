package Ventanas;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.util.Duration;

public class InicioSesionController {

    @FXML
    private Button IniciarSesion;

    @FXML
    private Button botonUnir;

    @FXML
    private void primerEstilo() {
        IniciarSesion.getStylesheets().clear();
        IniciarSesion.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        botonUnir.getStylesheets().clear();
        botonUnir.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }

    @FXML
    private PasswordField PasswordFieldContraseña;

    @FXML
    private ImageView Tazon;

    @FXML
    private TextField TextFieldCorreoE;

    @FXML
    private ImageView Wallpaper;

    @FXML
    private ImageView wevo;

    @FXML

    private void Agrandar() {
        wevo.getTransforms().add(new Scale(1.05, 1.05));

    }

    @FXML
    private void Achiquitar() {
        wevo.getTransforms().clear();
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

}
