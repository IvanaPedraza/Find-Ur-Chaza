/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import Logica.ControladorFactura;
import Logica.ControladorOrden;
import Modelo.*;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Line;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author IVANA
 */
public class FacturaOrdenesClienController implements Initializable{
    
    private ControladorOrden controladorOrden = App.bdOrd.getControladorOrden();
    private ControladorFactura controladorFactura = App.bdFac.getControladorFactura();
    private Cliente clienteActual = InicioSesionController.getClienteLog();
    private static Orden ordenActual = new Orden();
    private ObservableList<Factura> datosFacturas;
    public Mensaje mensaje = new Mensaje();
    
    @FXML
    private Button BotonOrdenes;

    @FXML
    private Button BotonProductos;

    @FXML
    private Button BotonRegresar;
    
    @FXML
    private ImageView Camaron;

    @FXML
    private ImageView CirculoDeUsuario;

    @FXML
    private TableColumn<Factura, Integer> ColumnaCantidad;

    @FXML
    private TableColumn<Factura, Date> ColumnaFecha;

    @FXML
    private TableColumn<Factura, Long> ColumnaID;

    @FXML
    private TableColumn<Factura, Double> ColumnaPrecioTotal;

    @FXML
    private TableColumn<Factura, String> ColumnaProducto;

    @FXML
    private Label Correo;

    @FXML
    private ImageView FacturaCompra;

    @FXML
    private ImageView FindUrChazPequeño;

    @FXML
    private Line Linea;

    @FXML
    private Label Numero;

    @FXML
    private AnchorPane Panel1;

    @FXML
    private AnchorPane Panel2;

    @FXML
    private Label PerfilCliente;

    @FXML
    private ImageView PerfilUsuario;

    @FXML
    private TableView<Factura> TablaFactura;

    @FXML
    private Text TextFieldTotal;

    @FXML
    private Label TotalOrden;

    @FXML
    private Label Usuario;

    @FXML
    private ImageView degradeFondoChazasRecorte;

    @FXML
    private ImageView fBlancoTransparente;

    @FXML
    private ImageView michianvorguesa;

    @FXML
    private ImageView sushi2;
    
    @FXML
    private Label numeroOrden;
    
    @FXML
    private Label labelOrden;
    
    @FXML
    private void primerEstilo() {
        BotonOrdenes.getStylesheets().clear();
        BotonOrdenes.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        BotonProductos.getStylesheets().clear();
        BotonProductos.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }
    
    @FXML
    private void switchToMenuProductosCliente() throws IOException {
        App.setRoot("menuProductosCliente");
    }
    
    @FXML
    private void switchToInicioSesion() throws IOException {
        App.setRoot("InicioSesion");
    }
    
    @FXML
    private void switchToDatosDelUsuarioCliente() throws IOException {
        App.setRoot("DatosDelUsuarioCliente");
    }
    
    @FXML
    void switchToMenuChazas() throws IOException {
        App.setRoot("menuChazas");

    }
    
    private void cargarDatosFactura(){
        datosFacturas = FXCollections.observableArrayList();
        Factura[] facturasPorOrden = controladorFactura.buscarFacturasPorOrden(ordenActual);
        for(int i = 0;i < facturasPorOrden.length;i++){
            datosFacturas.add(facturasPorOrden[i]);
        }
        ColumnaID.setCellValueFactory(new PropertyValueFactory<>("numReferencia"));
        ColumnaFecha.setCellValueFactory(new PropertyValueFactory<>("fechaFactura"));
        ColumnaProducto.setCellValueFactory(cellData -> {
            Producto producto = cellData.getValue().getProducto();
            String productoNombre = producto.getNombre();
            return new SimpleObjectProperty<String>(productoNombre);
        });
        ColumnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        ColumnaPrecioTotal.setCellValueFactory(new PropertyValueFactory<>("costoTotal"));
        
        TablaFactura.setItems(datosFacturas);
    }
    
    private double calcularTotalOrden(){
        Factura[] facturasPorOrden = controladorFactura.buscarFacturasPorOrden(ordenActual);
        double totalFacturaOrden = 0;
        for(int i = 0; i < facturasPorOrden.length;i++){
            totalFacturaOrden += facturasPorOrden[i].getCostoTotal();
        }
        return totalFacturaOrden;
    }
    
    public static void setOrden(Orden orden){
        ordenActual = orden;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        degradeFondoChazasRecorte.setVisible(true);
        Linea.setVisible(true);
        FacturaCompra.setVisible(true);
        sushi2.setVisible(true);
        Camaron.setVisible(true);
        PerfilUsuario.setVisible(true);
        Numero.setVisible(true);
        Correo.setVisible(true);
        TextFieldTotal.setVisible(true);
        Usuario.setVisible(true);
        TotalOrden.setVisible(true);
        Panel2.setVisible(true);
        TablaFactura.setVisible(true);
        ColumnaID.setVisible(true);
        fBlancoTransparente.setVisible(true);
        Panel1.setVisible(true);
        CirculoDeUsuario.setVisible(true);
        michianvorguesa.setVisible(true);
        FindUrChazPequeño.setVisible(true);
        ColumnaFecha.setVisible(true);
        ColumnaProducto.setVisible(true);
        PerfilCliente.setVisible(true);
        BotonOrdenes.setVisible(true);
        BotonProductos.setVisible(true);
        PerfilCliente.setText(clienteActual.getNombre() + " " + clienteActual.getApellido());
        Usuario.setText(clienteActual.getNombre());
        Correo.setText(clienteActual.getCorreo());
        Numero.setText(clienteActual.getTelefono());
        numeroOrden.setText(String.valueOf(ordenActual.getNumOrden()));
        cargarDatosFactura();
        TotalOrden.setText(String.valueOf("$ " + calcularTotalOrden()));
    }
    
}
