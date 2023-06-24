package Ventanas;

import Logica.ControladorChaza;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import Modelo.Chaza;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class chazasController implements Initializable{

    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private Chaza chazaActual = new Chaza();

    @FXML
    private ImageView Imgchaza;

    @FXML
    private AnchorPane chazaCard;

    @FXML
    private Label nombreChaza;

    @FXML
    void verProductosChaza() {
        Chaza chazaEscogida = chazaActual;
        
    }
    
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
