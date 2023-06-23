package Ventanas;

import EstructurasDeDatos.HashCliente;
import Logica.*;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Orden;
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
    private ControladorOrden controladorOrden = App.bdOrd.getControladorOrden();
    private ControladorFactura controladorFactura = App.bdFac.getControladorFactura();
    //private ArregloDinamicoConColaVendedor arregloVendedor = controladorVendedor.getArregloDinamicoVendedor();
    private HashCliente hashCliente = controladorCliente.getHashCliente();
    public static Cliente clienteActual = InicioSesionController.getClienteLog();
    public Mensaje mensaje = new Mensaje();
    
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
    private void eliminarUsuarioCliente() throws IOException {
        String correoAEliminar = textFieldCorreo.getText().trim();
        try {
            eliminarOrdenFacCliente();
            controladorCliente.eliminarCliente(correoAEliminar);
            mensaje.mensajeInformacion("Haz eliminado tu usuario ");
            App.setRoot("InicioSesion");
        } catch (Exception e) {
            mensaje.mensajeError("Ha sucedido un error, no fue posible eliminar :(");
        }
    }
    
    @FXML
    private void actualizarUsuarioCliente() throws IOException {
        String correoActual = textFieldCorreo.getText().trim();
        String nombreActual = textFieldNombre.getText().trim();
        String apellidoActual = textFieldApellido.getText().trim();
        String telefonoActual = textFieldTelefono.getText().trim();

        if (!correoActual.equals("") || !nombreActual.equals("") || !apellidoActual.equals("") || !telefonoActual.equals("")) {
            try {
                controladorCliente.actualizarClienteCom(correoActual, nombreActual, apellidoActual, telefonoActual);
                mensaje.mensajeInformacion("Haz actualizado tu usuario: " + nombreActual + " :D");
                App.setRoot("menuChazas");
            } catch (Exception e) {
                mensaje.mensajeError("Ha sucedio un error, no fue posible actualizar :(");
            }
        } else {
            mensaje.mensajeAdvertencia("Debe llenar todos los campos requeridos");
        }
    }
    
    private void eliminarOrdenFacCliente(){
        try{
            Orden[] ordenesCliente = controladorOrden.buscarOrdenesPorCliente(clienteActual);
            for(int i = 0; i < ordenesCliente.length;i++){
                Factura[] facturas = controladorFactura.buscarFacturasPorOrden(ordenesCliente[i]);
                for(int j = 0; j < facturas.length; j++){
                    controladorFactura.eliminarFactura(facturas[j].getNumReferencia());
                }
                controladorOrden.eliminarOrden(ordenesCliente[i].getNumOrden());
            }
        }catch(Exception e){
            mensaje.mensajeError("Ha ocurrido un error " + e.toString());
        }
    }
    
    @FXML
    private void retornarInicioCli() throws IOException {
        System.out.println("Hola");
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
        textFieldApellido.setText(clienteActual.getApellido());
        textFieldCorreo.setVisible(true);
        textFieldCorreo.setText(clienteActual.getCorreo());
        textFieldNombre.setVisible(true);
        textFieldNombre.setText(clienteActual.getNombre());
        textFieldTelefono.setVisible(true);
        textFieldTelefono.setText(clienteActual.getTelefono());
    }
     
 }   

