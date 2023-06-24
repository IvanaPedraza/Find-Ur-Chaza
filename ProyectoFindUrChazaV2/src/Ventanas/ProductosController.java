/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import Modelo.*;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author IVANA
 */
public class ProductosController {
    private static Producto productoActual = new Producto();
    
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
    
    public void setData(Producto producto){
        this.productoActual = producto;
        nombreProducto.setText(productoActual.getNombre());
        precioProducto.setText(String.valueOf(productoActual.getPrecio()));
        
    }
    
    
}
