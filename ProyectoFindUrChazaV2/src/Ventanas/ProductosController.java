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
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
/**
 *
 * @author IVANA
 */
public class ProductosController {
    
    @FXML
    private AnchorPane Panel;
    
    @FXML
    private AnchorPane PanelFoto;
    
    @FXML
    private AnchorPane PanelSpinner;
    
    @FXML
    private AnchorPane PanelAñadir;
    
    @FXML 
    private ImageView Comida2;
    
    @FXML 
    private ImageView Añadir;
    
    @FXML
    private Spinner Spinner;
    
    @FXML
    private HBox Hbox2;
    
    @FXML
    private VBox Vbox1;
    
    @FXML
    private HBox Hbox1;
    
    @FXML
    private Label nombreProducto;
    
    @FXML
    private Label precioProducto;
    
    
}
