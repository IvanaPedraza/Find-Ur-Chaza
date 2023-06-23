package Ventanas;

import Logica.*;
import Modelo.Chaza;
import Modelo.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class menuProductosClienteController implements Initializable{
    
    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private Cliente clienteActual = InicioSesionController.getClienteLog();
    public Chaza chazaEscogida = menuChazasController.chazaEscogida;
    private ControladorProducto controladorProducto = App.bdPro.getControladorProducto();
    

   @FXML
    private ImageView F2;
   
   @FXML
    private ImageView Tienda;
   
   @FXML 
    private ImageView elgato;
   
   @FXML
    private ImageView elgatoPerfil;
   
    @FXML
    private void switchToDatosDelUsuarioCliente() throws IOException {
        App.setRoot("DatosDelUsuarioCliente");
    }
    
    @FXML
    private Button BotonRegresar;
    
    @FXML
    private void switchToMenuChazas() throws IOException {
        App.setRoot("menuChazas");
    }
    
    @FXML
    private Button TusOrdenes;
    
    @FXML
    private void switchToFacturaOrdenesCliente() throws IOException {
        App.setRoot("FacturaOrdenesCliente");
    }
    
    @FXML
    private Button Productos;
    
     @FXML
    private void primerEstilo() {
        BotonRegresar.getStylesheets().clear();
        BotonRegresar.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        TusOrdenes.getStylesheets().clear();
        TusOrdenes.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        Productos.getStylesheets().clear();
        Productos.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }
    
   @FXML
    private AnchorPane Panel;
   
   @FXML
    private AnchorPane Panel2;
   
   @FXML
    private Separator separador;
   
   @FXML
    private Label nombreVendedor;
   
   @FXML
    private Label nombreChaza;
   
  @FXML
    private Label Estado;
  
  @FXML
    private TextField DescripcionChaza;
  
  @FXML
    private ScrollPane PanelcrollProductos;
  
  @FXML
    private GridPane GrillaProductos;
      

  @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        F2.setVisible(true);
        Tienda.setVisible(true);
        elgato.setVisible(true);
        elgatoPerfil.setVisible(true);
        BotonRegresar.setVisible(true);
        Productos.setVisible(true);
        Panel.setVisible(true);
        separador.setVisible(true);
        nombreVendedor.setVisible(true);
        nombreChaza.setVisible(true);
        Estado.setVisible(true);
        DescripcionChaza.setVisible(true);
        PanelcrollProductos.setVisible(true);
        GrillaProductos.setVisible(true);
    }
 }   

