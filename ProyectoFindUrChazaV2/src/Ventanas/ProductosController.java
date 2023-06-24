/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import Modelo.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author IVANA
 */
public class ProductosController implements Initializable{
    private static Producto productoActual = new Producto();
    
    @FXML
    private ImageView Añadir;

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
    private Spinner<?> Spinner;

    @FXML
    private VBox Vbox1;

    @FXML
    private ImageView imagenComida;

    @FXML
    private Label nombreProducto;

    @FXML
    private Label precioProducto;
    
    
    
    public void setData(Producto producto){
        this.productoActual = producto;
        nombreProducto.setText(productoActual.getNombre());
        precioProducto.setText(String.valueOf(productoActual.getPrecio()));
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        Añadir.setVisible(true);
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

    }
    
}
