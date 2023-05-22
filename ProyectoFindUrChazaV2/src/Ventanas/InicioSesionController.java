package Ventanas;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
    private void switchToRegistroDatosUsuario() throws IOException {
        App.setRoot("registroDatosUsuario");
    }

    @FXML
    private AnchorPane Panel1;
    

}
