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
    @FXML
    private ImageView FindUrChazPequeño;
    
    @FXML
    private ImageView michianvorguesa;
    
    @FXML
    private ImageView CirculoDeUsuario;
    
    @FXML
    private Button BotonOrdenar;
    
    @FXML
    private void primerEstilo() {
        BotonOrdenar.getStylesheets().clear();
        BotonOrdenar.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }
    
    @FXML
    private ImageView degradeFondoChazasRecorte;
    
    @FXML
    private ImageView fBlancoTransparente;
    
    @FXML
    private ScrollPane Ordenes;
    
    @FXML
    private AnchorPane Panel1;
    
    @FXML
    private AnchorPane Panel2;
    
    @FXML
    private AnchorPane Panel3;
    
    @FXML
    private TextField TextFieldFecha;
    
    @FXML
    private TextField TextFieldPrecio;
    
    @FXML
    private TextField TextFieldID;
    
    @FXML
    private TextField TextFieldOrden;
    
    @FXML
    private TextField TextFieldUsuario;
    
    @FXML
    private TextField TextFieldTotal;
    
    @FXML
    private TextField TextFieldCorreo;
    
    @FXML
    private TextField TextFieldNumero;
    
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        degradeFondoChazasRecorte.setVisible(true);
        Linea.setVisible(false);
        FacturaCompra.setVisible(false);
        sushi2.setVisible(false);
        Camaron.setVisible(false);
        PerfilUsuario.setVisible(false);
        TextFieldNumero.setVisible(false);
        TextFieldCorreo.setVisible(false);
        TextFieldTotal.setVisible(false);
        TextFieldUsuario.setVisible(false);
        TextFieldOrden.setVisible(false);
        TextFieldID.setVisible(false);
        TextFieldPrecio.setVisible(false);
        TextFieldFecha.setVisible(false);
        Panel2.setVisible(false);
        Ordenes.setVisible(true);
        fBlancoTransparente.setVisible(false);
        Panel3.setVisible(true);
        Panel1.setVisible(true);
        CirculoDeUsuario.setVisible(true);
        michianvorguesa.setVisible(true);
        BotonOrdenar.setVisible(true);
        FindUrChazPequeño.setVisible(true);

    }
    
     @FXML
    private void btnO(MouseEvent event
    ) {
        degradeFondoChazasRecorte.setVisible(true);
        michianvorguesa.setVisible(true);
        BotonOrdenar.setVisible(true);
        FindUrChazPequeño.setVisible(true);
        Linea.setVisible(true);
        FacturaCompra.setVisible(true);
        sushi2.setVisible(true);
        Camaron.setVisible(true);
        PerfilUsuario.setVisible(true);
        TextFieldNumero.setVisible(true);
        TextFieldCorreo.setVisible(true);
        TextFieldTotal.setVisible(true);
        TextFieldUsuario.setVisible(true);
        TextFieldOrden.setVisible(true);
        TextFieldID.setVisible(true);
        TextFieldPrecio.setVisible(true);
        TextFieldFecha.setVisible(true);
        Panel2.setVisible(true);
        fBlancoTransparente.setVisible(true);
        Panel1.setVisible(true);
        Panel3.setVisible(false);
        Ordenes.setVisible(false);
        CirculoDeUsuario.setVisible(true);
    }
}
