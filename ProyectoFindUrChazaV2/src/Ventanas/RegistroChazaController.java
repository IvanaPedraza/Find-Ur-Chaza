package Ventanas;

import EstructurasDeDatos.AVLChaza;
import Modelo.Chaza;
import Modelo.Vendedor;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Ventanas.*;
import static Ventanas.registroDatosVendedorController.vendedorActual;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import javafx.scene.text.Text;

public class RegistroChazaController implements Initializable{
    private AVLChaza arbolChaza = new AVLChaza();
    private Vendedor vendedorChaza = registroDatosVendedorController.vendedorActual;
    private Chaza chazaActual = new Chaza();
    public Mensaje mensaje = new Mensaje();

    @FXML
    private AnchorPane Panel1;

    @FXML
    private ImageView Wallpaper;

    @FXML
    private Button botonRegistroChaza;

    @FXML
    private Text descripcionChaza;

    @FXML
    private Text nombreChaza;

    @FXML
    private TextField textFieldDescripcion;

    @FXML
    private TextField textFieldNombreChaza;

    @FXML
    private TextField textFieldUbicacion;

    @FXML
    private Text ubicacionChaza;

    @FXML
    private Button volverInicioVendedor;
    
    @FXML
    void registrarChaza() throws IOException {
        String nombreChaza = textFieldNombreChaza.getText().trim();
        String ubicacionChaza = textFieldUbicacion.getText().trim();
        String descripcionChaza = textFieldDescripcion.getText().trim();
        
        if(!nombreChaza.equals("") || !ubicacionChaza.equals("") || !descripcionChaza.equals("")){
            chazaActual = new Chaza(nombreChaza, ubicacionChaza, descripcionChaza, vendedorChaza);
            arbolChaza.insert(chazaActual);
            arbolChaza.postOrderTraversal();
            mensaje.mensajeInformacion("Se ha ingresado correctamente \n" +
                    chazaActual.getNombreChaza());
            App.setRoot("InicioVendedor");
        }else{
            mensaje.mensajeAdvertencia("Debes llenar todos los campos para continuar! :)");
        }
    }

    @FXML
    void retornarInicioVendedor() throws IOException {
        App.setRoot("InicioVendedor");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Panel1.setVisible(true);
        Wallpaper.setVisible(true);
        botonRegistroChaza.setVisible(true);
        descripcionChaza.setVisible(true);
        nombreChaza.setVisible(true);
        textFieldDescripcion.setVisible(true);
        textFieldNombreChaza.setVisible(true);
        textFieldUbicacion.setVisible(true);
        ubicacionChaza.setVisible(true);
        volverInicioVendedor.setVisible(true);
    }

}
