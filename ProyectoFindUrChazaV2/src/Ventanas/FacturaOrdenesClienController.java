/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

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
/**
 *
 * @author IVANA
 */
public class FacturaOrdenesClienController implements Initializable{
    
    private Cliente clienteActual = InicioSesionController.getClienteLog();
    
    @FXML
    private ImageView FindUrChazPequeño;
    
    @FXML
    private ImageView michianvorguesa;
    
    @FXML
    private ImageView CirculoDeUsuario;
   
    
    @FXML
    private Button BotonOrdenes;
    
    @FXML
    private Button BotonProductos;
    
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
    private void primerEstilo() {
        BotonOrdenes.getStylesheets().clear();
        BotonOrdenes.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
        BotonProductos.getStylesheets().clear();
        BotonProductos.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }
    
    @FXML
    private ImageView degradeFondoChazasRecorte;
    
    @FXML
    private ImageView fBlancoTransparente;
    
    
    @FXML
    private AnchorPane Panel1;
    
    @FXML
    private AnchorPane Panel2;
    
    @FXML
    private Label Usuario;
   
    @FXML
    private Text TextFieldTotal;
    
    @FXML
    private Label Correo;
    
    @FXML
    private Label Numero;
    
    @FXML
    private Label TotalOrden;
    
    @FXML
    private Label PerfilCliente;
    
    @FXML
    private ImageView PerfilUsuario;
    
    @FXML
    private ImageView sushi2;
    
    @FXML
    private ImageView Camaron;
    
    @FXML
    private ImageView FacturaCompra;
    
    @FXML
    private Line Linea;
    
    @FXML
    private TableView TablaFactura;
    
    @FXML
    private TableColumn ColumnaID;
    
    @FXML
    private TableColumn ColumnaFecha;
    
    @FXML
    private TableColumn ColumnaOrden;
    
    @FXML
    private TableColumn ColumnaProducto;
    
    
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
        TablaFactura.setVisible(false);
        ColumnaID.setVisible(true);
        fBlancoTransparente.setVisible(true);
        Panel1.setVisible(true);
        CirculoDeUsuario.setVisible(true);
        michianvorguesa.setVisible(true);
        FindUrChazPequeño.setVisible(true);
        ColumnaFecha.setVisible(true);
        ColumnaOrden. setVisible(true);
        ColumnaProducto.setVisible(true);
        PerfilCliente.setVisible(true);
        BotonOrdenes.setVisible(true);
        BotonProductos.setVisible(true);
        PerfilCliente.setText(clienteActual.getNombre() + " " + clienteActual.getApellido());
        Usuario.setText(clienteActual.getNombre());
        Correo.setText(clienteActual.getCorreo());
        Numero.setText(clienteActual.getTelefono());
    }
    
}
