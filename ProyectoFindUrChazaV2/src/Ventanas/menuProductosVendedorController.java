/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

/**
 *
 * @author IVANA
 */

import EstructurasDeDatos.AVLChaza;
import EstructurasDeDatos.NodeChaza;
import Logica.*;
import Modelo.Cliente;
import Modelo.Chaza;
import Modelo.Orden;
import Modelo.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class menuProductosVendedorController implements Initializable {
    private Vendedor vendedorActual = InicioSesionController.getVendedorLog();
    
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
    private Button Editar; 
    
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
    private TextArea DescripcionChaza;
    
    @FXML
    private void primerEstilo() {
        TusOrdenes.getStylesheets().clear();
        TusOrdenes.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        TusChazas.getStylesheets().clear();
        TusChazas.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        Productos.getStylesheets().clear();
        Productos.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        Editar.getStylesheets().clear();
        Editar.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
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
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        DescripcionChaza.setVisible(true);
        producto_GridPane.setVisible(true);
        scrollGridPane.setVisible(true);
        TusOrdenes.setVisible(true);
        separador.setVisible(true);
        TusChazas.setVisible(true);
        Productos.setVisible(true);
        Editar.setVisible(true);
        Estado.setVisible(true);
        Choice_BoxEstado.setVisible(true);
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
        nombreVendedorInfo.setText("¡Bienvenido " + vendedorActual.getNombre() + " " + vendedorActual.getApellido() + "!");
        //chazaDisplayCard();
    }
    
}
