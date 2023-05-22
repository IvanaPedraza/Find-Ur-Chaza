package Ventanas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class registroDatosUsuarioController {

    @FXML
    private ImageView HeaderRegistro;

    @FXML
    private ImageView Pasta;

    @FXML
    private ImageView Wallpaper;

    @FXML
    private Button nuevoVendedor;

    @FXML
    private Button nuevoCliente;

    @FXML
    private PasswordField passwordFieldContraseña;

    @FXML
    private TextField textFieldApellido;

    @FXML
    private TextField textFieldCorreo;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldTelefono;

    @FXML
    private void primerEstilo() {
        nuevoVendedor.getStylesheets().clear();
        nuevoVendedor.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        nuevoCliente.getStylesheets().clear();
        nuevoCliente.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }

}
