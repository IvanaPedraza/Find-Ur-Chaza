package Ventanas;

import com.sun.javafx.logging.PlatformLogger.Level;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.System.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class registroDatosClienteController {

   
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
    private Button Volver;
    
    @FXML
    private void switchToIniciarSesion() throws IOException{
        App.setRoot("InicioSesion");
    }
   
    
    @FXML
    private void primerEstilo() {
        nuevoVendedor.getStylesheets().clear();
        nuevoVendedor.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        nuevoCliente.getStylesheets().clear();
        nuevoCliente.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }
        

 }   


