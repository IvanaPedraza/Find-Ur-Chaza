/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

/**
 *
 * @author IVANA
 */

import BaseDeDatos.Conexion;
import Logica.ControladorChaza;
import Logica.ControladorCliente;
import Logica.ControladorVendedor;
import Modelo.Cliente;
import Modelo.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import java.net.Proxy;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
public class ordenesProductosVendedorController implements Initializable{
    
    private Vendedor vendedorActual = InicioSesionController.getVendedorLog();
    
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
    private TableView TablaOrdenesClientes;
    
    @FXML
    private TableColumn ColumnaCliente;
    
    @FXML
    private TableColumn ColumnaProducto;
    
    @FXML
    private TableColumn ColumnaCantidad;
    
    @FXML
    private TableColumn ColumnaNumeroOrden;
    
    @FXML
    private TableColumn ColumnaTotal;
    
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
        TablaOrdenesClientes.setVisible(true);
        Vendedor.setVisible(true);
        GatitoConParrilla.setVisible(true);
        MichiPerfilVendedor.setVisible(true);
        FindUrChazaChikito.setVisible(true);
        michiHamborgueso.setVisible(true);
        Fondo.setVisible(true);
        ColumnaTotal.setVisible(true);
        Vendedor.setText(vendedorActual.getNombre() + " " + vendedorActual.getApellido());
        
    }
}
