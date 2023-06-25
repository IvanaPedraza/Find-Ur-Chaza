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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author IVANA
 */
public class ProductosVendedorController implements Initializable{
    private Producto productoActual = new Producto();
    //private static Orden ordenActual = menuProductosClienteController.ordenActual;
    private ControladorFactura controladorFactura = App.bdFac.getControladorFactura();
    private Factura facturaActual = new Factura();
    private long numFactura = 0;
    public Mensaje mensaje = new Mensaje();
    private int cantidad;

    @FXML
    private HBox Hbox1;

    @FXML
    private HBox Hbox2;

    @FXML
    private AnchorPane Panel;

    @FXML
    private AnchorPane PanelFoto;

    @FXML
    private AnchorPane Paneleliminar;

    @FXML
    private VBox Vbox1;

    @FXML
    private ImageView imagenComida;
    
    @FXML
    private ImageView Basura;
    
    @FXML
    private Label nombreProducto;

    @FXML
    private Label precioProducto;
    

    public void setData(Producto producto) {
        this.productoActual = producto;
        nombreProducto.setText(productoActual.getNombre());
        precioProducto.setText("$" + String.valueOf(productoActual.getPrecio()));

    }

    /*
    public void setOrden(Orden orden) {
        this.ordenActual = orden;
    }
*/

    public void eliminarFacturaProd() {
        try {
            controladorFactura.eliminarFactura(numFactura);
        } catch (Exception e) {
            mensaje.mensajeError("Ha ocurrido un error en la eliminación del producto");
        }
    }

    private long numFactura() {
        long numeroFacturas = controladorFactura.cantidadFacturas();
        numFactura = 100 + numeroFacturas;
        return numFactura;
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        Hbox1.setVisible(true);
        Hbox2.setVisible(true);
        Panel.setVisible(true);
        PanelFoto.setVisible(true);
        Paneleliminar.setVisible(true);
        Vbox1.setVisible(true);
        imagenComida.setVisible(true);
        nombreProducto.setVisible(true);
        precioProducto.setVisible(true);
        Basura.setVisible(true);
    }
    
}
