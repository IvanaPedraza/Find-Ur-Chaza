package Ventanas;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Modelo.Chaza;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

public class chazasController {

    @FXML
    private ImageView Imgchaza;

    @FXML
    private Label nombreChaza;
    
    private Chaza chaza;

    @FXML
    void verInfoCliente(MouseEvent event) {

    }

       public void setData(Chaza chaza) {
        this.chaza = chaza;
        nombreChaza.setText(chaza.getNombreChaza());
        Image image = new Image(getClass().getResourceAsStream(chaza.getImgSrc()));
        Imgchaza.setImage(image);
    }



    }
