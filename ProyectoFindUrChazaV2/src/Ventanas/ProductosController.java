/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import Logica.ControladorFactura;
import Modelo.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author IVANA
 */
public class ProductosController implements Initializable {

    private Connection conexion = BaseDeDatos.Conexion.conectar();
    private PreparedStatement pst;
    private Producto productoActual = new Producto();
    private Orden ordenActual = new Orden();
    private ControladorFactura controladorFactura = App.bdFac.getControladorFactura();
    private Factura facturaActual = new Factura();
    private long numFactura = 0;
    public Mensaje mensaje = new Mensaje();
    private int cantidad;

    @FXML
    private ImageView anadirProducto;

    @FXML
    private ImageView botonOrdenarOprimido;

    @FXML
    private HBox Hbox1;

    @FXML
    private HBox Hbox2;

    @FXML
    private AnchorPane Panel;

    @FXML
    private AnchorPane PanelAñadir;

    @FXML
    private AnchorPane PanelFoto;

    @FXML
    private AnchorPane PanelSpinner;

    @FXML
    private Spinner<Integer> Spinner;

    @FXML
    private VBox Vbox1;

    @FXML
    private ImageView imagenComida;

    @FXML
    private Label nombreProducto;

    @FXML
    private Label precioProducto;

    private SpinnerValueFactory<Integer> spin;

    public void setQuantity() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);

    }

    public void setData(Producto producto) {
        this.productoActual = producto;
        nombreProducto.setText(productoActual.getNombre());
        precioProducto.setText("$" + String.valueOf(productoActual.getPrecio()));
        Spinner.setValueFactory(spin);

    }

    public void setOrden(Orden orden) {
        this.ordenActual = orden;
    }
    
    public Orden getOrden(){
        return this.ordenActual;
    }

    public void anadirProductoFac() throws Exception {
        cantidad = Spinner.getValue();
        if (!botonOrdenarOprimido.isVisible()) {
            long numeroFactura = numFactura();
            this.numFactura = numeroFactura;
            Date fechaFactura = new Date();
            if (cantidad != 0 && controladorFactura.existeFactura(numFactura) == false) {
                double costoTotal = cantidad * productoActual.getPrecio();
                facturaActual = controladorFactura.agregarNuevaFactura(numFactura, fechaFactura, productoActual, ordenActual, cantidad, costoTotal);
                insertarBdFactura(facturaActual);
                botonOrdenarOprimido.setVisible(true);
                anadirProducto.setVisible(false);
                System.out.println("La factura se creo como: " + facturaActual.getNumReferencia() + " " + facturaActual.getOrden().getNumOrden());
            }

        } else {
            if (controladorFactura.existeFactura(numFactura) == true && cantidad != controladorFactura.buscarFacturaPorId(numFactura).getCantidad()) {
                controladorFactura.actualizarFactura(numFactura, "Cantidad", String.valueOf(cantidad));
                System.out.println("La factura se actualizo " + controladorFactura.buscarFacturaPorId(numFactura).getCantidad());
            }
        }
    }

    public void eliminarFacturaProd() {
        try {
            controladorFactura.eliminarFactura(numFactura);
            spin.setValue(0);
        } catch (Exception e) {
            mensaje.mensajeError("Ha ocurrido un error en la eliminación del producto");
        }
    }

    private long numFactura() {
        long numeroFacturas = controladorFactura.cantidadFacturas();
        numFactura = 100 + numeroFacturas;
        return numFactura;
    }
    
    public void insertarBdFactura(Factura factura){
        java.sql.Timestamp fechaSQL = new java.sql.Timestamp(factura.getFechaFactura().getTime());
        if(factura != null){
            try{
                pst = conexion.prepareStatement("insert into factura values(?,?,?,?,?,?)");
                pst.setLong(1, factura.getNumReferencia());
                pst.setTimestamp(2, fechaSQL);
                pst.setLong(3, factura.getProducto().getCodigo());
                pst.setLong(4, factura.getOrden().getNumOrden());
                pst.setInt(5, factura.getCantidad());
                pst.setDouble(6, factura.getCostoTotal());
                pst.executeUpdate();
                
            }catch(SQLException e){
                System.out.println("Error en el insertado de la BD" + e);
            }
        }
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        botonOrdenarOprimido.setVisible(false);
        anadirProducto.setVisible(true);
        Hbox1.setVisible(true);
        Hbox2.setVisible(true);
        Panel.setVisible(true);
        PanelAñadir.setVisible(true);
        PanelFoto.setVisible(true);
        PanelSpinner.setVisible(true);
        Spinner.setVisible(true);
        Vbox1.setVisible(true);
        imagenComida.setVisible(true);
        nombreProducto.setVisible(true);
        precioProducto.setVisible(true);
        numFactura();
        setQuantity();

    }

}
