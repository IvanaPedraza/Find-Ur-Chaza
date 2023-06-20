package Ventanas;

import EstructurasDeDatos.ArregloDinamicoConColaVendedor;
import EstructurasDeDatos.HashVendedor;
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

public class vistaClienteFacturaController {

    private ControladorVendedor controladorVendedor = InicioSesionController.getControladorVendedor();
    //private ArregloDinamicoConColaVendedor arregloVendedor = controladorVendedor.getArregloDinamicoVendedor();
    private HashVendedor hashVendedor = controladorVendedor.getHashVendedor();
    public static Vendedor vendedorActual = new Vendedor();
  

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
    private void registrarVendedor() throws IOException {

        String correo = textFieldCorreo.getText().trim();
        String nombre = textFieldNombre.getText().trim();
        String apellido = textFieldApellido.getText().trim();
        String telefono = textFieldTelefono.getText().trim();
        String contrasena = passwordFieldContraseña.getText().trim();
        if (!correo.equals("") || !nombre.equals("") || !apellido.equals("") || !telefono.equals("") || !contrasena.equals("")) {
            vendedorActual = new Vendedor(correo, nombre, apellido, telefono, contrasena);
            //arregloVendedor.pushBack(vendedorActual);
            hashVendedor.insert(correo, vendedorActual);
            //arregloVendedor.imprimir();
            hashVendedor.printHashTable();
            App.setRoot("RegistroChaza");

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos para continuar! :)");

        }

    }

    @FXML
    private Button Volver;

    @FXML
    private void switchToIniciarSesion() throws IOException {
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

