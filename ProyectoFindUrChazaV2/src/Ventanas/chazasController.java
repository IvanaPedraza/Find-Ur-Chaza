package Ventanas;

import Logica.ControladorChaza;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Modelo.Chaza;
import Modelo.Producto;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

public class chazasController implements Initializable{

    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private Chaza chazaActual = new Chaza();

    @FXML
    private ImageView Imgchaza;

    @FXML
    private Label nombreChaza;

    
    
    public void setData(Chaza chaza){
        this.chazaActual = chaza;
        nombreChaza.setText(chazaActual.getNombreChaza());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        Imgchaza.setVisible(true);
        nombreChaza.setVisible(true);

    }
    

}
