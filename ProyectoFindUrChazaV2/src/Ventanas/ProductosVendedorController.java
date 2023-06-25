/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import Logica.ControladorFactura;
import Modelo.*;
import java.net.URL;
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
public class ProductosVendedorController implements Initializable{
    private Producto productoActual = new Producto();
    private static Orden ordenActual = menuProductosClienteController.ordenActual;
    private ControladorFactura controladorFactura = App.bdFac.getControladorFactura();
    private Factura facturaActual = new Factura();
    private long numFactura = 0;
    public Mensaje mensaje = new Mensaje();
    private int cantidad;
    
    @FXML
    private ImageView anadirProducto;

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
    
    public void setQuantity(){
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
        
    }
    
    
    public void setData(Producto producto){
        this.productoActual = producto;
        nombreProducto.setText(productoActual.getNombre());
        precioProducto.setText("$" + String.valueOf(productoActual.getPrecio()));
        Spinner.setValueFactory(spin);
        
    }
    
    public void anadirProductoFac() throws Exception{
        long numeroFactura = numFactura();
        this.numFactura = numeroFactura;
        cantidad = Spinner.getValue();
        Date fechaFactura = new Date();
        if(cantidad != 0 && controladorFactura.existeFactura(numeroFactura) == false){
            double costoTotal = cantidad * productoActual.getPrecio();
            facturaActual = controladorFactura.agregarNuevaFactura(numeroFactura, fechaFactura, productoActual, ordenActual, cantidad, costoTotal);
            System.out.println("La factura se creo como: " + facturaActual.getNumReferencia());
        }else if(controladorFactura.existeFactura(numeroFactura) == true && cantidad != controladorFactura.buscarFacturaPorId(numeroFactura).getCantidad()){
            controladorFactura.actualizarFactura(numeroFactura, "Cantidad", String.valueOf(cantidad));
        }
    }
    
    public void eliminarFacturaProd(){
        try{
            controladorFactura.eliminarFactura(numFactura);
            spin.setValue(0);
        }catch(Exception e){
            mensaje.mensajeError("Ha ocurrido un error en la eliminación del producto");
        }
    }
    private long numFactura(){
        long numeroFacturas = controladorFactura.cantidadFacturas();
        return 100 + numeroFacturas;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
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
        setQuantity();

    }
    
}
