package Ventanas;

import EstructurasDeDatos.HashCliente;
import Logica.*;
import Modelo.Vendedor;
import com.sun.javafx.logging.PlatformLogger.Level;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.System.Logger;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class DatosDelUsuarioClienteController {

    private ControladorCliente controladorCliente = InicioSesionController.getControladorCliente();
    //private ArregloDinamicoConColaVendedor arregloVendedor = controladorVendedor.getArregloDinamicoVendedor();
    private HashCliente hashCliente = controladorCliente.getHashVendedor();
    public static Vendedor vendedorActual = new Vendedor();
  



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
    private void switchToIniciarSesion() throws IOException {
        App.setRoot("InicioSesion");
    }

     
 }   

