package Ventanas;

import Logica.ControladorChaza;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import Modelo.Chaza;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class chazasController implements Initializable{

    private ControladorChaza controladorChaza = App.bdCha.getControladorChaza();
    private static Chaza chazaActual = new Chaza();

    @FXML
    private ImageView Imgchaza;

    @FXML
    private AnchorPane chazaCard;

    @FXML
    private Label nombreChaza;

    @FXML
    void enviarChaza(MouseEvent event) throws IOException{
        menuProductosClienteController.chazaEscogida = chazaActual;
        irAMenu(event);
    }
    
    private void irAMenu(MouseEvent event) throws IOException{
        App.setRoot("menuProductosCliente");
        
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
