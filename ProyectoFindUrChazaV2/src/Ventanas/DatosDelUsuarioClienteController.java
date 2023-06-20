package Ventanas;

import EstructurasDeDatos.HashCliente;
import Logica.*;
import Modelo.Cliente;
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
    private HashCliente hashCliente = controladorCliente.getHashCliente();
    public static Cliente clienteActual = new Cliente();

    @FXML
    private TextField textFieldApellido;

    @FXML
    private TextField textFieldCorreo;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldTelefono;

    
    
    @FXML
    private void retornarInicioCli() throws IOException {
        App.setRoot("InicioCliente");
    }

    @FXML
    private Button botonRetornoCli;
    

     
 }   

