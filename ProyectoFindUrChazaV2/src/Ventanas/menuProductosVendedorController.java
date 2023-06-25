/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

/**
 *
 * @author IVANA
 */

import Logica.*;
import Modelo.Chaza;
import Modelo.Producto;
import Modelo.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class menuProductosVendedorController implements Initializable {
    
    private Vendedor vendedorActual = InicioSesionController.getVendedorLog();
    public static Chaza chazaEscogida = new Chaza();
    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private ControladorProducto controladorProducto = App.bdPro.getControladorProducto();
    private ObservableList<Producto> cardListProducto = FXCollections.observableArrayList();
    public Mensaje mensaje = new Mensaje();
    String estados[] = {"Abierto", "Cerrado"};
    
    @FXML
    private AnchorPane Panel;
    
    @FXML
    private AnchorPane Panel2;
    
    @FXML
    private AnchorPane Panel3;
    
    @FXML
    private ImageView Fondo;
    
    @FXML
    private ImageView Tienda;
    
    @FXML
    private ImageView michiHamborgueso;
    
    @FXML
    private ImageView findUrChaza;
    
    @FXML
    private ImageView fotoPerfilV;
    
    @FXML
    private ImageView fotoPerfilV2;
    
    @FXML
    private Label nombreVendedor;
    
    @FXML
    private Label nombreVendedorInfo;
    
    @FXML
    private Label nombreChaza;
    
    @FXML
    private ChoiceBox Choice_BoxEstado;
    
    @FXML
    private Text Estado;
    
    @FXML
    private Button Añadir; 
    
    @FXML
    private Button Productos;
    
    @FXML
    private Button TusChazas;
    
    @FXML
    private Button TusOrdenes;
    
    @FXML
    private Separator separador;
    
    @FXML
    private ScrollPane scrollGridPane;
    
    @FXML
    private GridPane producto_GridPane;
    
    @FXML
    private Label DescripcionChaza;
    
    @FXML
    private void primerEstilo() {
        TusOrdenes.getStylesheets().clear();
        TusOrdenes.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        TusChazas.getStylesheets().clear();
        TusChazas.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        Productos.getStylesheets().clear();
        Productos.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        Añadir.getStylesheets().clear();
        Añadir.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }
    
    @FXML
    private void switchToMenuChazasVendedor() throws IOException {
        App.setRoot("menuChazasVendedor");
    }
    
    @FXML
    private void switchToOrdenesProductosVendedor() throws IOException {
        App.setRoot("ordenesProductosVendedor");
    }
    
    @FXML
    private void switchToInicioSesion() throws IOException {
        App.setRoot("InicioSesion");
    }
    
    @FXML
    private void switchToDatosDelVendedor() throws IOException {
        App.setRoot("DatosDelUsuarioVendedor");
    }
    
    @FXML
    void anadirProducto() {
        
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
                load.setLocation(getClass().getResource("ProductosVendedor.fxml"));
                AnchorPane pane = load.load();
                ProductosVendedorController cardC = load.getController();
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
    
    
    private void estadoChazaBox(){
        Choice_BoxEstado.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>(){
                    public void changed(ObservableValue ov, Number value, Number new_value){
                        cambiarEstado(new_value.intValue());
                    }
                }
        );
    }
    
    
    private void cambiarEstado(int index){
        Choice_BoxEstado.setValue(estados[index]);
        int value = 0;
        if(index == 0){
            value = 1;
        }
        controladorChaza.actualizarChaza(chazaEscogida.getNombreChaza(), "Estado", String.valueOf(value));
        mensaje.mensajeConfirmacion("Estado de la chaza " + chazaEscogida.getNombreChaza() + " cambiado con éxito!");
    }
    
    
    private void estadoInicial(){
        int value = chazaEscogida.getEstadoChaza();
        if(value == 1){
            Choice_BoxEstado.setValue(estados[0]);
        }else{
            Choice_BoxEstado.setValue(estados[1]);
        }
    }
    
    /*@FXML
    private void btnC(MouseEvent event
    ) {
    
    }*/
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        DescripcionChaza.setVisible(true);
        producto_GridPane.setVisible(true);
        scrollGridPane.setVisible(true);
        TusOrdenes.setVisible(true);
        separador.setVisible(true);
        TusChazas.setVisible(true);
        Productos.setVisible(true);
        Añadir.setVisible(true);
        Estado.setVisible(true);
        Choice_BoxEstado.setVisible(true);
        Choice_BoxEstado.setItems(FXCollections.observableArrayList(estados));
        nombreChaza.setVisible(true);
        nombreVendedorInfo.setVisible(true);
        nombreVendedor.setVisible(true);
        fotoPerfilV2.setVisible(true);
        fotoPerfilV.setVisible(true);
        findUrChaza.setVisible(true);
        michiHamborgueso.setVisible(true);
        Tienda.setVisible(true);
        Fondo.setVisible(true);
        Panel3.setVisible(true);
        Panel2.setVisible(true);
        Panel.setVisible(true);
        nombreVendedorInfo.setText(vendedorActual.getNombre() + " " + vendedorActual.getApellido());
        nombreVendedor.setText(vendedorActual.getNombre());
        nombreChaza.setText(chazaEscogida.getNombreChaza());
        DescripcionChaza.setText(chazaEscogida.getDescripcion());
        estadoInicial();
        estadoChazaBox();
        productoDisplayCard();
    }
    
}
