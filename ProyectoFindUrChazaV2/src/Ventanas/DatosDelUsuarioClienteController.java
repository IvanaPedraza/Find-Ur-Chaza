package Ventanas;

import EstructurasDeDatos.HashCliente;
import Logica.*;
import Modelo.Cliente;
import com.sun.javafx.logging.PlatformLogger.Level;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class DatosDelUsuarioClienteController implements Initializable{

    private ControladorCliente controladorCliente = InicioSesionController.getControladorCliente();
    //private ArregloDinamicoConColaVendedor arregloVendedor = controladorVendedor.getArregloDinamicoVendedor();
    private HashCliente hashCliente = controladorCliente.getHashCliente();
    public static Cliente clienteActual = new Cliente();
    
    @FXML
    private ImageView Wallpaper;

    @FXML
    private Button actualizarDatos;

    @FXML
    private Text apellido;

    @FXML
    private Button botonRetornoCli;

    @FXML
    private Text correoElectronico;

    @FXML
    private Button eliminarDatos;

    @FXML
    private Label labelDatosCliente;

    @FXML
    private Text nombre;

    @FXML
    private AnchorPane panel;

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
    private void retornarInicioCli() throws IOException {
        App.setRoot("InicioCliente");
    }

    @FXML
    private void eliminarUsuarioCliente() throws IOException {
        App.setRoot("InicioCliente");
    }
    
    @FXML
    private void actualizarUsuarioCliente() throws IOException {
        App.setRoot("InicioCliente");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        panel.setVisible(true);
        Wallpaper.setVisible(true);
        labelDatosCliente.setText("¡Bienvenido " + clienteActual.getNombre()+ " " + clienteActual.getApellido()+"!");
        actualizarDatos.setVisible(true);
        apellido.setVisible(true);
        botonRetornoCli.setVisible(true);
        correoElectronico.setVisible(true);
        eliminarDatos.setVisible(true);
        labelDatosCliente.setVisible(true);
        nombre.setVisible(true);
        telefono.setVisible(true);
        textFieldApellido.setVisible(true);
        textFieldCorreo.setVisible(true);
        textFieldNombre.setVisible(true);
        textFieldTelefono.setVisible(true);
    }
     
 }   

