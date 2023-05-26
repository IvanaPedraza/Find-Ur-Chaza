package Ventanas;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistroChazaController {

    @FXML
    private Button Registrar;

    @FXML
    private PasswordField PasswordFieldContraseña;

    @FXML
    private ImageView sushi;

    @FXML
    private ImageView Palillos2;

    @FXML
    private ImageView PlatilloRegistro;

    @FXML
    private ImageView TituloVendedor1;

    @FXML
    private ImageView TituloVendedor2;

    @FXML
    private ImageView F2;

    @FXML
    private TextField TextFieldNombre;

    @FXML
    private TextField TextFieldUbicacion;

    @FXML
    private TextField TextFieldDescripcion;

    @FXML
    private void primerEstilo() {
        Registrar.getStylesheets().clear();
        Registrar.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }

    @FXML
    private void switchToRegistroDatosVendedor() throws IOException {
        App.setRoot("registroDatosVendedor");
    }

    @FXML
    private Button Volver;


}
