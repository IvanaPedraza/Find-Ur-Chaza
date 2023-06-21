package Ventanas;

import Logica.*;
import Modelo.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class menuChazasController implements Initializable{
    
    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private Cliente clienteActual = InicioSesionController.getClienteLog();
    public Mensaje mensaje = new Mensaje();
    
    @FXML
    private ImageView Wallpaper;

    @FXML
    private Button botonChazas;

    @FXML
    private Button botonOrdenesCliente;

    @FXML
    private ImageView inicioSesion;

    @FXML
    private Label labelDatosCliente;

    @FXML
    private AnchorPane panel;

    @FXML
    void retornarInicioSesion() throws IOException {
        App.setRoot("InicioSesion");
    }

    @FXML
    void verChazas() throws IOException {
        App.setRoot("menuProductosCliente");
    }

    @FXML
    void verInfoCliente() throws IOException {
        App.setRoot("DatosDelUsuarioCliente");
    }

    @FXML
    void verOrdenesCliente() {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Wallpaper.setVisible(true);
        botonChazas.setVisible(true);
        botonOrdenesCliente.setVisible(true);
        inicioSesion.setVisible(true);
        labelDatosCliente.setVisible(true);
        panel.setVisible(true);
        labelDatosCliente.setText("¡Bienvenido " + clienteActual.getNombre() + " " + clienteActual.getApellido() + "!");
        
    }
    
    

        
 }   

