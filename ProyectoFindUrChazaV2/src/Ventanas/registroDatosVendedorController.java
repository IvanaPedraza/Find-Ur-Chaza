package Ventanas;
import Logica.*;
import com.sun.javafx.logging.PlatformLogger.Level;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.System.Logger;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;


import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class registroDatosVendedorController {
    
    private ControladorVendedor controladorVendedor = new ControladorVendedor();
   // private

   
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
    private void switchToRegistroChaza() throws IOException{
        App.setRoot("RegistroChaza");
    }
    
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


