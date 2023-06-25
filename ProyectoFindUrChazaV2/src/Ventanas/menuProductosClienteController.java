package Ventanas;

import Logica.*;
import Modelo.*;
import java.io.IOException;
import java.net.URL;
import java.security.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import java.sql.Connection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;



public class menuProductosClienteController implements Initializable{
    
    private Connection conexion = BaseDeDatos.Conexion.conectar();
    private PreparedStatement pst;
    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private Cliente clienteActual = InicioSesionController.getClienteLog();
    public Orden ordenActual = new Orden();
    public static Chaza chazaEscogida = new Chaza();
    private ControladorProducto controladorProducto = App.bdPro.getControladorProducto();
    private ControladorOrden controladorOrden = App.bdOrd.getControladorOrden();
    private ControladorFactura controladorFactura = App.bdFac.getControladorFactura();
    public Mensaje mensaje = new Mensaje();
    private ObservableList<Producto> cardListProducto = FXCollections.observableArrayList();
    private static long valorBaseOrden = 100;

   @FXML
    private Button BotonRegresar;

    @FXML
    private ImageView F2;

    @FXML
    private Button Factura;

    @FXML
    private AnchorPane Panel;

    @FXML
    private Button Productos;

    @FXML
    private ImageView Tienda;

    @FXML
    private TextField descripcionChaza;

    @FXML
    private ImageView elgato;

    @FXML
    private ImageView elgatoPerfil;

    @FXML
    private Label labelEstado;

    @FXML
    private Label nombreChaza;

    @FXML
    private Label nombreUsuario;

    @FXML
    private Label nombreVendedor;

    @FXML
    private AnchorPane productoForm;

    @FXML
    private GridPane producto_GridPane;

    @FXML
    private ScrollPane scrollGridPane;

    @FXML
    private Separator separador;

    @FXML
    private Label textEstado;

   
    @FXML
    private void switchToDatosDelUsuarioCliente() throws IOException {
        App.setRoot("DatosDelUsuarioCliente");
    }
    
    
    
    @FXML
    private void switchToMenuChazas() throws IOException {
        Factura[] facturasRegistradas = controladorFactura.buscarFacturasPorOrden(ordenActual);
        if(facturasRegistradas.length == 0){
            App.setRoot("menuChazas");
        }else{
            int opcionE = mensaje.mensajeConfirmacion("¿Desea cancelar la orden con los productos escogidos?");
            if(opcionE == JOptionPane.YES_OPTION){
                eliminarOrdenFacActual(ordenActual);
                App.setRoot("menuChazas");
            }
        }
    }
    
    
    
    @FXML
    void generarFacturaOrden() throws IOException {
        int opcionD = mensaje.mensajeConfirmacion("¿Está seguro de los productos seleccionados?");
        if(opcionD == JOptionPane.YES_OPTION){
            FacturaOrdenesClienController.setOrden(ordenActual);
            App.setRoot("FacturaOrdenesCliente");
        }else{
            mensaje.mensajeInformacion("Realice las modificaciones debidas");
        }
    }
    
    public void eliminarOrdenFacActual(Orden orden){
        Factura[] facturasOrden = controladorFactura.buscarFacturasPorOrden(orden);
        for(int i = 0; i < facturasOrden.length;i++){
            controladorFactura.eliminarFactura(facturasOrden[i].getNumReferencia());
        }
        controladorOrden.eliminarOrden(ordenActual.getNumOrden());
    }
    
    
    
    public ObservableList<Producto> productoGetData(){
        ObservableList<Producto> listProducto = FXCollections.observableArrayList();
        Producto[] productos = controladorProducto.buscarProductosPorChaza(chazaEscogida);
        
        for(int i = 0; i < productos.length; i++){
            listProducto.add(productos[i]);
        }
        
        return listProducto;
    }
    
    public void productoDisplayCard(){
        cardListProducto.clear();
        cardListProducto.addAll(productoGetData());
        
        
        int row = 0;
        int column = 0;
        producto_GridPane.getChildren().clear();
        producto_GridPane.getRowConstraints().clear();
        producto_GridPane.getColumnConstraints().clear();
        for (int i = 0; i < cardListProducto.size(); i++) {
            try {
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("Productos.fxml"));
                AnchorPane pane = load.load();
                ProductosController cardC = load.getController();
                cardC.setOrden(ordenActual);
                cardC.setData(cardListProducto.get(i));

                if (column == 3) {
                    column = 0;
                    row += 1;
                }

                producto_GridPane.add(pane, column++, row);
                
                GridPane.setMargin(pane, new Insets(10));
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }
    
    
     @FXML
    private void primerEstilo() {
        BotonRegresar.getStylesheets().clear();
        BotonRegresar.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        Factura.getStylesheets().clear();
        Factura.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        Productos.getStylesheets().clear();
        Productos.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }
    
   private String estadoChaza(Chaza chaza){
       String estado = "";
       if(chaza.getEstadoChaza() == 1){
           estado = "Abierto";
       }else{
           estado = "Cerrado";
       }
       return estado;
   }
   
   public Orden generarNuevaOrden(){
       long idOrden = numeroIdOrden();
       Date fechaProcesoOrden = new Date();
       ordenActual = new Orden(idOrden, fechaProcesoOrden, clienteActual, chazaEscogida);
       System.out.println("Se ha generado la orden " + ordenActual.getNumOrden());
       java.sql.Date fechaSQL = new java.sql.Date(fechaProcesoOrden.getTime());
       if(idOrden != 0 || fechaProcesoOrden != null || ordenActual != null || clienteActual != null || chazaEscogida != null){
           try{
               pst = conexion.prepareStatement("insert into orden values(?,?,?,?)");
               pst.setLong(1, idOrden);
               pst.setDate(2, fechaSQL);
               pst.setString(3, clienteActual.getCorreo());
               pst.setInt(4, chazaEscogida.getIdChaza());
               pst.executeUpdate();
           }catch(SQLException e){
               System.out.println("Error en el insertado de la BD" + e);
           }
       }else{
           mensaje.mensajeAdvertencia("Ha sucedido un error en la asignacion de valores, contacta al administrador.");
       }
       
       return ordenActual;
   }
   
   
   private long numeroIdOrden(){
       /*
       long numeroDeOrdenes = controladorOrden.numeroOrden();
       long numOrden = 100 + numeroDeOrdenes;
       return numOrden;
        */
       valorBaseOrden += controladorOrden.numeroOrden();
       return valorBaseOrden;
   }

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
        nombreVendedor.setText(chazaEscogida.getVendedor().getNombre());
        nombreChaza.setVisible(true);
        nombreChaza.setText(chazaEscogida.getNombreChaza());
        labelEstado.setVisible(true);
        nombreUsuario.setVisible(true);
        nombreUsuario.setText(clienteActual.getNombre()+ " "+ clienteActual.getApellido());
        textEstado.setVisible(true);
        textEstado.setText(estadoChaza(chazaEscogida));
        descripcionChaza.setVisible(true);
        descripcionChaza.setText(chazaEscogida.getNombreChaza());
        productoForm.setVisible(true);
        producto_GridPane.setVisible(true);
        scrollGridPane.setVisible(true);
        separador.setVisible(true);
        generarNuevaOrden();
        productoDisplayCard();
        
    }
 }   

