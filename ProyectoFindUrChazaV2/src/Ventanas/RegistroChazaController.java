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
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class RegistroChazaController {
    private AVLChaza arbolChaza = new AVLChaza();
    private Vendedor vendedorChaza = registroDatosVendedorController.vendedorActual;
    private Chaza chazaActual = new Chaza();

    @FXML
    private Button Registrar;

      @FXML
    private AnchorPane Panel1;

    @FXML
    private ImageView Wallpaper;

    @FXML
    private TextField añadirDescripcion;

    @FXML
    private TextField nombrarChaza;

    @FXML
    private TextField ubicacionChaza;

    @FXML
    private Button volver;

    @FXML
    private Button volver1;

    @FXML
    private void primerEstilo() {
        Registrar.getStylesheets().clear();
        Registrar.getStylesheets().addAll(this.getClass().getResource("../Estilos/Style's.css").toExternalForm());
    }

    @FXML
    private Button Volver;

    @FXML
    void registroChaza(MouseEvent event) throws IOException {
        String nombreChaza = nombrarChaza.getText().trim();
        String ubicacion = ubicacionChaza.getText().trim();
        String descripcion = añadirDescripcion.getText().trim();

        if (!nombreChaza.equals("") || !ubicacion.equals("") || !descripcion.equals("")) {
            chazaActual = new Chaza(nombreChaza, ubicacion, descripcion, vendedorChaza);
            arbolChaza.insert(chazaActual);
            arbolChaza.postOrderTraversal();
            App.setRoot("InicioVendedor");

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos para continuar! :)");

        }

    }

}
