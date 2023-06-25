/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

/**
 *
 * @author IVANA
 */

import Logica.ControladorFactura;
import Logica.ControladorOrden;
import Modelo.Chaza;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Orden;
import Modelo.Producto;
import Modelo.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.DefaultStringConverter;
public class ordenesProductosVendedorController implements Initializable{
    
    private Vendedor vendedorActual = InicioSesionController.getVendedorLog();
    private Chaza chazaActual = menuProductosVendedorController.chazaEscogida;
    private ControladorOrden controladorOrden = App.bdOrd.getControladorOrden();
    private ControladorFactura controladorFactura = App.bdFac.getControladorFactura();
    private ObservableList<Orden> datosOrdenes;
    
    @FXML
    private AnchorPane Panel1;
    
    
    @FXML
    private ImageView Fondo;
    
    @FXML
    private ImageView michiHamborgueso;
    
    @FXML
    private ImageView FindUrChazaChikito;
    
    @FXML
    private ImageView MichiPerfilVendedor;
    
    @FXML
    private ImageView GatitoConParrilla;
    
    @FXML
    private Label Vendedor;
    
    @FXML
    private TableView<Orden> TablaOrdenesChaza;
    
    @FXML
    private TableColumn<Orden, String> ColumnaCliente;
    
    @FXML
    private TableColumn<Orden, String> ColumnaProducto;
    
    @FXML
    private TableColumn<Orden, Integer> ColumnaCantidad;
    
    @FXML
    private TableColumn<Orden, Long> ColumnaNumeroOrden;
    
    @FXML
    private TableColumn<Orden, Date> ColumnaFechaOrden;
    
    @FXML
    private TableColumn<Orden, Double> ColumnaTotal;
    
    @FXML
    private Button BotonOrdenes;
    
    @FXML
    private Button BotonProductos;
    
    
    @FXML
    private void switchToInicioSesion() throws IOException {
        App.setRoot("InicioSesion");
    }
    
    @FXML
    private void switchTomenuProductosVendedor() throws IOException {
        App.setRoot("menuProductosVendedor");
    }
    
    @FXML
    private void switchToDatosDelVendedor() throws IOException {
        App.setRoot("DatosDelUsuarioVendedor");
    }
    
    private void cargarDatosOrden(){
        datosOrdenes = FXCollections.observableArrayList();
        String productosOrden = "";
        Orden[] ordenesPorChaza = controladorOrden.buscarOrdenPorChaza(chazaActual);
        for(int i = 0; i < ordenesPorChaza.length;i++){
            datosOrdenes.add(ordenesPorChaza[i]);
        }
        ColumnaCliente.setCellValueFactory(cellData -> {
            Cliente cliente = cellData.getValue().getCliente();
            String nombreCliente = cliente.getNombre();
            return new SimpleObjectProperty<String>(nombreCliente);
        });
        /*
        ColumnaProducto.setCellValueFactory(cellData -> {
            String productos = verProductosPorOrden(cellData.getValue());
            return new SimpleObjectProperty<String>(productos);
        });
        */
        ColumnaProducto.setCellFactory(column -> new TableCell<Orden, String>(){
            private final ComboBox<String> comboBox = new ComboBox<>();
            {
            comboBox.prefWidthProperty().bind(column.widthProperty());
            comboBox.getStylesheets().add(getClass().getResource("/Estilos/comboBox.css").toExternalForm());
            }
            @Override
            protected void updateItem(String item, boolean empty){
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null);
                }else{
                    Orden orden = getTableView().getItems().get(getIndex());
                    String[] productos = verProductosPorOrden(orden);
                    comboBox.setItems(FXCollections.observableArrayList(productos));
                    comboBox.setValue(item);
                    setGraphic(comboBox);
                }
            }
        });
        ColumnaCantidad.setCellValueFactory(cellData -> {
            int cantidadTotal = cantidadTotalOrden(cellData.getValue());
            return new SimpleObjectProperty<Integer>(cantidadTotal);
        });
        ColumnaNumeroOrden.setCellValueFactory(new PropertyValueFactory<>("numOrden"));
        ColumnaFechaOrden.setCellValueFactory(new PropertyValueFactory<>("fechaOrden"));
        
        ColumnaTotal.setCellValueFactory(cellData -> {
            double costoTotal = costoTotalOrden(cellData.getValue());
            return new SimpleObjectProperty<Double>(costoTotal);
        });
        
        TablaOrdenesChaza.setItems(datosOrdenes);
        
    }
    
    private String[] verProductosPorOrden(Orden orden){
        Factura[] facturasPorOrden = controladorFactura.buscarFacturasPorOrden(orden);
        String ProductosPorOrden = "";
        for(int i = 0; i < facturasPorOrden.length;i++){
            String prod = facturasPorOrden[i].getProducto().getNombre();
            ProductosPorOrden = ProductosPorOrden + " " + prod + ",";
        }
        ProductosPorOrden = ProductosPorOrden.substring(0, ProductosPorOrden.length()-1);
        String[] productosNombre = ProductosPorOrden.trim().split(", ");
        return productosNombre;
    }
    
    private ObservableList obsLiProd(String[] prodName){
        ObservableList<String> obs = FXCollections.observableArrayList();
        for(int i = 0;i < prodName.length;i++){
            obs.add(prodName[i]);
        }
        return obs;
    }
    
    private int cantidadTotalOrden(Orden orden){
        Factura[] facturasPorOrden = controladorFactura.buscarFacturasPorOrden(orden);
        int cantidadTotal = 0;
        for(int i = 0; i < facturasPorOrden.length;i++){
            cantidadTotal += facturasPorOrden[i].getCantidad();
        }
        return cantidadTotal;
    }
    
    private double costoTotalOrden(Orden orden){
        Factura[] facturasPorOrden = controladorFactura.buscarFacturasPorOrden(orden);
        double costoTotal = 0;
        for(int i = 0; i < facturasPorOrden.length;i++){
            costoTotal += facturasPorOrden[i].getCostoTotal();
        }
        return costoTotal;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        
        Panel1.setVisible(true);
        ColumnaProducto.setVisible(true);
        BotonProductos.setVisible(true);
        BotonOrdenes.setVisible(true);
        ColumnaNumeroOrden.setVisible(true);
        ColumnaCantidad.setVisible(true);
        ColumnaCliente.setVisible(true);
        TablaOrdenesChaza.setVisible(true);
        Vendedor.setVisible(true);
        GatitoConParrilla.setVisible(true);
        MichiPerfilVendedor.setVisible(true);
        FindUrChazaChikito.setVisible(true);
        michiHamborgueso.setVisible(true);
        Fondo.setVisible(true);
        ColumnaTotal.setVisible(true);
        Vendedor.setText(vendedorActual.getNombre() + " " + vendedorActual.getApellido());
        cargarDatosOrden();
    }
}
