package Ventanas;

import EstructurasDeDatos.HashCliente;
import Logica.ControladorCliente;
import Modelo.Cliente;
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
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class registroDatosClienteController {
    
    private ControladorCliente controladorCliente = InicioSesionController.getControladorCliente();
    private HashCliente hashCliente = controladorCliente.getHashCliente();
    public static Cliente clienteActual = new Cliente();
    public Mensaje mensaje = new Mensaje();
    
    @FXML
    private ImageView Pasta;

    @FXML
    private ImageView Wallpaper;

    @FXML
    private Text apellido;

    @FXML
    private Text contrasena;

    @FXML
    private Text correoElectronico;

    @FXML
    private Text nombre;

    @FXML
    private Button nuevoCliente;

    @FXML
    private AnchorPane panel;

    @FXML
    private PasswordField passwordFieldContraseña;

    @FXML
    private Text telefono;

    @FXML
    private TextField textFieldApellido;

    @FXML
    private TextField textFieldCorreo;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldTelefono;

    @FXML
    private Button volverAInicio;

    @FXML
    private void switchToIniciarSesion() throws IOException{
        App.setRoot("InicioSesion");
    }
   
    @FXML
    void registrarCliente() throws IOException {
        String correo = textFieldCorreo.getText().trim();
        String nombre = textFieldNombre.getText().trim();
        String apellido = textFieldApellido.getText().trim();
        String telefono = textFieldTelefono.getText().trim();
        String contrasena = passwordFieldContraseña.getText().trim();
        
        if (!correo.equals("") || !nombre.equals("") || !apellido.equals("") || !telefono.equals("") || !contrasena.equals("")) {
            clienteActual = new Cliente(correo, nombre, apellido, telefono, contrasena);
            
            hashCliente.insert(correo, clienteActual);
            hashCliente.printHashTable();
            mensaje.mensajeInformacion("Se ha insertado correctamente \n"
                    + clienteActual.getNombre() + " \n" + clienteActual.getApellido());
            clienteActual.toString();
            App.setRoot("InicioCliente");
        }else{
            mensaje.mensajeAdvertencia("Debes llenar todos los campos para continuar! :)");
        }
    }
        

 }   


