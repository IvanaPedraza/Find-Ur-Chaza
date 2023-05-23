package Ventanas;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class vistaDatosController {
   @FXML
    private ImageView Wallpaper;

    @FXML
    private ImageView datosDelUsuario;

    @FXML
    private Label labelNombreUsuario;

    @FXML
    private TextField nombreCompleto;

    @FXML
    private Button nuevoVendedor;

    @FXML
    private Button nuevoVendedor1;

    @FXML
    private AnchorPane panel;

    @FXML
    private TextField textFieldApellido;

    @FXML
    private TextField textFieldCorreo;

    @FXML
    private TextField textFieldTelefono;
    

    public void initialize(URL arg0, ResourceBundle arg1){

        Font myFont = null;
        try {
            myFont = Font.loadFont(new FileInputStream(new File("../fuentes/TitanOne-Regular.ttf")), 10);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        nuevoVendedor.setFont(myFont);

}

}